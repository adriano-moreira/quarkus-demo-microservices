#!/usr/bin/env bash
set -ex


## JVM

cd demo-bff
./mvnw clean package
docker build . -f ./src/main/docker/Dockerfile.jvm -t docker.io/adrianomoreira86/quarkus-demo-bff:jvm
cd -

cd demo-ms1
./mvnw clean package
docker build . -f ./src/main/docker/Dockerfile.jvm -t docker.io/adrianomoreira86/quarkus-demo-ms1:jvm
cd -

## NATIVE
# cd demo-bff
# ./mvnw clean package -Pnative
# docker build . -f ./src/main/docker/Dockerfile.native -t docker.io/adrianomoreira86/quarkus-demo-bff:native
# cd -

# cd demo-ms1
# ./mvnw clean package -Pnative
# docker build . -f ./src/main/docker/Dockerfile.native -t docker.io/adrianomoreira86/quarkus-demo-ms1:native
# cd -