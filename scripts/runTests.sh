#!/bin/bash

# clean-up
docker compose down
docker compose --profile jvm down
docker compose --profile native down

TEST_TYPES="load-test stress-test" #breackpoint-test
RUNTIMES="jvm native"
C_TYPES="worker-thread io-thread virtual-thread"
TESTS_SCENARIO="nothing rest-client database-slow" # mix


TESTS_SCENARIO="rest-client database-slow database-fast redis" # mix

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
                    ./scripts/script.k6.js 

                docker compose --profile "$RUNTIME" down
                sleep 2

            done
        done
    done
done