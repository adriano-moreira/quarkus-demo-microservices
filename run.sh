#!/usr/bin/env bash
set -ex

TEST_ID="$(date +'%Y-%m-%d-%H-%M')"
TEST_FAST=false

#TEST_ID='2024-09-22-18-00'

export TEST_ID
export TEST_FAST


mkdir -p "./reports/$TEST_ID/k6-summary"

# ./scripts/buildLocalDockerImages.sh

./scripts/runTests.sh


# rm -v report/tmp/k6-*.json
cd scripts && npx tsx createReport.ts