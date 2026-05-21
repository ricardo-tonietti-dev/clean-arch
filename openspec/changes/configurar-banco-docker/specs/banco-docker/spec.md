## ADDED Requirements

### Requirement: Banco local via Docker
O sistema SHALL fornecer configuracao para subir um banco Postgres local via Docker para desenvolvimento.

#### Scenario: Subir banco local
- **WHEN** o desenvolvedor executa o comando documentado para subir o banco
- **THEN** um container Postgres fica disponivel na porta configurada para uso local

### Requirement: Defaults de conexao
O sistema SHALL permitir conexao ao banco usando variaveis de ambiente `DB_HOST`, `DB_USER` e `DB_PASSWORD`, com valores padrao compativeis com o banco Docker.

#### Scenario: Conexao com defaults
- **WHEN** as variaveis `DB_HOST`, `DB_USER` e `DB_PASSWORD` nao sao definidas
- **THEN** a aplicacao usa os valores padrao e conecta ao banco Docker local

#### Scenario: Conexao com overrides
- **WHEN** as variaveis `DB_HOST`, `DB_USER` e `DB_PASSWORD` sao definidas pelo usuario
- **THEN** a aplicacao usa os valores fornecidos para conectar ao banco

### Requirement: Documentacao de uso
O sistema SHALL documentar prerequisitos e comandos para subir, parar e resetar o banco local.

#### Scenario: Seguimento da documentacao
- **WHEN** o desenvolvedor segue a documentacao
- **THEN** ele consegue subir, parar e resetar o banco local sem precisar alterar codigo
