#!/usr/bin/env bash
set -ex

# generate unique output folder
TEST_ID="$(date +'%Y-%m-%d-%H-%M')"
export TEST_ID

# clean-up
docker compose down
docker compose --profile jvm down
docker compose --profile native down

export TEST_VUS_LIST="1 5 20 60"
export RUNTIMES="jvm native"
export C_TYPES="worker-thread io-thread virtual-thread"
export TESTS_SCENARIO="nothing rest-client database-slow database-fast redis" # mix
mkdir -p "./reports/$TEST_ID/k6-summary"

for TEST_TYPE in $TEST_TYPES; do
    for TEST_SCENARIO in $TESTS_SCENARIO; do
        for C_TYPE in $C_TYPES; do
            for RUNTIME in $RUNTIMES; do

                docker compose --profile "$RUNTIME" up -d
                sleep 3

                scripts/docker.k6.sh run \
                    --env "TEST_ID=$TEST_ID" \
                    --env "TEST_FAST=$TEST_FAST" \
                    --env "TEST_TYPE=$TEST_TYPE" \
                    --env "RUNTIME=$RUNTIME" \
                    --env "C_TYPE=$C_TYPE" \
                    --env "TEST_SCENARIO=$TEST_SCENARIO" \
                    --summary-trend-stats="min,med,p(90),p(99),max" \
                    --vus 10 --duration 30s
                    ./scripts/script.k6.js

                docker compose --profile "$RUNTIME" down
                sleep 2

            done
        done
    done
done

# rm -v report/tmp/k6-*.json
cd scripts && npx tsx createReport.ts