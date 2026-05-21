## ADDED Requirements

### Requirement: Carga inicial previsivel de usuarios
O sistema SHALL limpar a tabela `usuarios` e recarregar um conjunto padrao de registros ao iniciar a aplicacao em ambiente local.

#### Scenario: Reinicializar a tabela de usuarios
- **WHEN** a aplicacao inicializa com a configuracao de banco local habilitada
- **THEN** os registros existentes em `usuarios` sao removidos antes da carga inicial

#### Scenario: Popular usuarios padrao
- **WHEN** a aplicacao conclui a inicializacao do schema
- **THEN** a tabela `usuarios` recebe os usuarios definidos como referencia no projeto
- **AND** cada usuario carregado possui CPF, nome, nascimento e email preenchidos

### Requirement: Isolamento do profile de teste
O sistema SHALL evitar a execucao da carga inicial automatica no profile `test`.

#### Scenario: Executar testes automatizados
- **WHEN** a aplicacao sobe com o profile `test`
- **THEN** o script de carga inicial de usuarios nao e executado automaticamente
