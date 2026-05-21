## Context

A aplicacao ja usa Postgres com variaveis de ambiente em application.properties, mas o time nao tem um banco local padronizado. A proposta e fornecer um banco Docker que funcione com os defaults existentes e facilite o onboarding.

## Goals / Non-Goals

**Goals:**
- Disponibilizar um banco Postgres local via Docker Compose com configuracao padrao.
- Garantir que a aplicacao conecte sem ajustes manuais (env vars opcionais).
- Documentar fluxo de subir, parar e resetar o banco.

**Non-Goals:**
- Configuracao de banco para producao ou CI.
- Definir ferramentas de migracao ou seeds complexos.
- Alterar a modelagem de dados.

## Decisions

- **Usar Postgres via Docker Compose**: a aplicacao ja esta configurada para Postgres, reduzindo divergencias entre ambientes.
- **Manter defaults via env vars**: usar `DB_HOST`, `DB_USER` e `DB_PASSWORD` com valores padrao para manter compatibilidade com o `application.properties` atual.
- **Persistencia local com volume**: manter dados entre reinicios e permitir reset manual quando necessario.
- **Arquivo `.env` opcional**: oferecer um `.env.example` para personalizacao local sem alterar o codigo.

## Risks / Trade-offs

- **Conflito de porta 5432** → Permitir override de porta via env vars e documentar.
- **Senhas padrao expostas localmente** → Indicar uso apenas em desenvolvimento e permitir override via `.env`.
- **Dados persistidos inesperados** → Documentar comando de reset que remove o volume.
