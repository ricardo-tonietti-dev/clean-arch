## Why

O banco local pode iniciar vazio ou com dados residuais de execucoes anteriores, o que dificulta demonstracoes e testes manuais do fluxo de usuarios. Precisamos de uma carga inicial previsivel para que a aplicacao sempre suba com um conjunto conhecido de registros.

## What Changes

- Adicionar uma carga SQL executada na inicializacao da aplicacao.
- Limpar os registros existentes da tabela de usuarios antes de popular o banco.
- Inserir no banco os usuarios definidos em `UtilizaUsuarioComArquivo.java`.
- Ajustar a configuracao do Spring para executar o script em Postgres sem interferir no profile de teste.

## Capabilities

### New Capabilities
- `carga-inicial-usuarios`: reinicializar a tabela de usuarios e carregar registros padrao ao iniciar a aplicacao.

### Modified Capabilities
- 

## Impact

- Novo script SQL de bootstrap em `src/main/resources`.
- Ajustes de configuracao em profiles da aplicacao.
- Atualizacao do arquivo fonte usado como referencia dos usuarios iniciais.
