#!/bin/bash

docker compose up -d
sleep 3
stress-test/k6.sh run ./stress-test/worker-thread-myself.js
docker compose down


docker compose up -d
sleep 3
stress-test/k6.sh run ./stress-test/io-thread-myself.js
docker compose down


docker compose up -d
sleep 3
stress-test/k6.sh run ./stress-test/virtual-thread-myself.js
docker compose down