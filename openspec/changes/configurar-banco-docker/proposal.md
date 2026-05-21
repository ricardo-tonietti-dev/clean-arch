## Why

O ambiente local nao tem um banco padronizado, o que dificulta o onboarding e gera inconsistencias de configuracao. Precisamos de uma forma simples e repetivel de subir o banco com Docker.

## What Changes

- Adicionar configuracao de banco de dados via Docker Compose para uso local.
- Definir variaveis de ambiente padrao para conexao da aplicacao ao banco.
- Documentar como subir, parar e resetar o banco local.

## Capabilities

### New Capabilities
- `banco-docker`: provisionar um banco local via Docker e permitir que a aplicacao conecte usando configuracao padrao.

### Modified Capabilities
- 

## Impact

- Novo arquivo de compose e/ou scripts auxiliares.
- Ajustes em configuracao de ambiente (ex.: application.properties e env vars).
- Documentacao no repositorio para uso em desenvolvimento local.
