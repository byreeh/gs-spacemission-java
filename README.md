# SpaceMission - 

Sistema de Gerenciamento de Missões Espaciais — Global Solution 2026/1 FIAP

## Integrantes
- Ilda Adosfo - RM: 568233 | Turma: 1TDSPA
- Renata Lessa - RM: 568510 | Turma: 1TDSPR

## Tecnologias
- Java 21
- Quarkus 3.36.0
- Oracle Database (FIAP)
- HTML, CSS e JavaScript

## Como executar
1. Clone o repositório
2. `git checkout RM568510`
3. Configure o `application.properties` com suas credenciais Oracle
4. `./mvnw quarkus:dev`
5. Acesse: `http://localhost:8080`

## Endpoints
- GET /missoes
- POST /missoes
- PUT /missoes/{id}
- DELETE /missoes/{id}
- GET /astronautas
- POST /astronautas
- PUT /astronautas/{id}
- DELETE /astronautas/{id}
- GET /veiculos
- POST /veiculos
- PUT /veiculos/{id}
- DELETE /veiculos/{id}

## Deploy
Link: https://gs-spacemission-java.onrender.com
