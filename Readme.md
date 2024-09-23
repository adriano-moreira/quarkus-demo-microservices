# Quarkus benchmark

## Objetivo
Entender melhor os ganhos ao usar programação reativa e virtual-threads com Quarkus, e entender melhor os 


## Como ?
- Realizando 3 tipos de testes de carga:
    - [x] Carga Tipica ([load-test/average-load test](https://grafana.com/docs/k6/latest/testing-guides/test-types/load-testing/))
    - [x] Estresse (stress-test)
    - [ ] Ponto de Ruptura ([soak-test](https://grafana.com/docs/k6/latest/testing-guides/test-types/breakpoint-testing/))

- Em 5 Scenarios/Endpoints:
    - [ ] `GET ../use/nothing` - um endpoint que apenas retorna 200, não faz nada
    - [ ] `GET ../use/rest-client`
    - [ ] `GET ../use/postgres`
    - [ ] `GET ../use/redis`
    - [ ] `GET ../use/mix`

### Teste de Carga(Load Test)
- Simulando 500 usuários, com uma espera de 1 segundo a cada request

### Teste de Stress
 - 

### Teste de Ponto de Ruptura




## Resultado:


## Minha opnião atual


 dos testes de stress:
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



Other benchmarks:
https://medium.com/@bensatriya3/benchmarking-api-performance-go-fiber-vs-java-springboot-vs-express-js-28679a8c8dc8