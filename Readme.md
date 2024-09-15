# quarkus-demo-microservices

Projeto de estudo, sobre Quarkus com alguns testes de carga

Objetivo dos testes de stress:
- ~~Comparar Quarkus LTS: **3.2** VS **3.8** VS **3.15**~~
- ~~Comparar versões JVMs: **Java 17** VS **Java 21**~~
- Comparar modelos de concorrência: **Worker Threads** VS **IO Threads/Event Loop** VS **Virtual Threads**
- Comparar **JVM** VS **Native**


Requisitos para gerar images docker localmente pelo script `./buildLocalDockerImages.sh`
- Java 21
- Docker

Requisitos para executar local:
- Docker



Executar todos os testes
```sh
./runStessTest.sh
```