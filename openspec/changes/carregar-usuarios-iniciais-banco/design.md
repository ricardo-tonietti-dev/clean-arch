## Context

A aplicacao cria e atualiza o schema com JPA (`ddl-auto=update`), mas nao possui um mecanismo de seed inicial. Como o recurso de usuarios e o principal fluxo funcional atual, faz sentido subir o ambiente com dados previsiveis.

## Goals / Non-Goals

**Goals:**
- Limpar a tabela `usuarios` antes da carga inicial.
- Inserir os usuarios padrao sempre que a aplicacao iniciar em ambiente local.
- Reaproveitar como referencia os dados mantidos em `UtilizaUsuarioComArquivo.java`.
- Evitar impacto no profile de teste.

**Non-Goals:**
- Introduzir Flyway ou Liquibase.
- Criar carga incremental ou condicional por ambiente de producao.
- Alterar o fluxo funcional de cadastro pela interface web ou API.

## Decisions

- **Usar `data.sql`**: o projeto ainda nao tem ferramenta de migracao, entao a forma mais simples e aderente ao stack atual e usar a inicializacao SQL do Spring Boot.
- **Executar o script apos a criacao do schema**: `spring.jpa.defer-datasource-initialization=true` garante que a tabela `usuarios` exista antes do seed.
- **Forcar inicializacao SQL em Postgres**: `spring.sql.init.mode=always` habilita a execucao do script tambem em banco nao embutido.
- **Desabilitar seed no profile de teste**: `spring.sql.init.mode=never` evita interferencia do bootstrap em testes automatizados.
- **Corrigir CPFs duplicados no arquivo de referencia**: como o sistema usa CPF como identificador logico, a lista-base precisa ter valores distintos para nao gerar comportamento ambiguo.

## Risks / Trade-offs

- **Carga reaplicada a cada inicializacao**: o ambiente local perde alteracoes anteriores na tabela `usuarios`, o que e esperado pela proposta de reset previsivel.
- **Dependencia de Postgres**: o script usa `TRUNCATE ... RESTART IDENTITY`, aderente ao banco padrao atual.
- **Divergencia futura entre Java e SQL**: o arquivo Java continua como referencia manual, então mudancas futuras devem manter os dois artefatos sincronizados.
