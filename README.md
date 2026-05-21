# Codechella - Desenvolvimento local

## Banco local via Docker

Requisitos:
- Docker
- Docker Compose

Subir o banco:

```bash
docker compose up -d
```

Parar o banco:

```bash
docker compose down
```

Resetar o banco (remove o volume):

```bash
docker compose down -v
```

## Variaveis de ambiente

Os defaults estao no arquivo `.env.example`. Para sobrescrever, crie um `.env` na raiz do projeto.

Principais variaveis:
- DB_HOST (padrao: localhost)
- DB_PORT (padrao: 5432)
- DB_USER (padrao: postgres)
- DB_PASSWORD (padrao: Info@123)
- POSTGRES_DB (padrao: codechella_db)

## Executar a aplicacao com o banco Docker

Use o profile `docker` para carregar `application-docker.properties`:

```bash
SPRING_PROFILES_ACTIVE=docker ./mvnw spring-boot:run
```
