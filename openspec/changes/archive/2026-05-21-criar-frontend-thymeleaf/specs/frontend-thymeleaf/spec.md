## ADDED Requirements

### Requirement: Interface web de usuarios
O sistema SHALL disponibilizar uma interface web server-side em `/usuarios` para visualizar e operar o cadastro de usuarios.

#### Scenario: Acessar listagem principal
- **WHEN** o usuario acessa `/usuarios`
- **THEN** a aplicacao exibe a lista de usuarios cadastrados
- **AND** a interface apresenta acao para cadastrar um novo usuario

#### Scenario: Exibir estado vazio
- **WHEN** nao houver usuarios cadastrados
- **THEN** a aplicacao exibe uma mensagem de estado vazio
- **AND** oferece uma acao para iniciar o primeiro cadastro

### Requirement: Cadastro e edicao via formulario web
O sistema SHALL permitir cadastrar e editar usuarios por meio de formularios HTML renderizados no servidor.

#### Scenario: Cadastrar usuario valido
- **WHEN** o usuario envia um formulario valido em `/usuarios`
- **THEN** a aplicacao persiste o novo usuario
- **AND** redireciona para a listagem com mensagem de sucesso

#### Scenario: Exibir erro de validacao
- **WHEN** o formulario web contem CPF invalido ou campos obrigatorios ausentes
- **THEN** a aplicacao reexibe o formulario
- **AND** mostra as mensagens de validacao correspondentes

#### Scenario: Editar usuario existente
- **WHEN** o usuario acessa `/usuarios/{cpf}/editar`
- **THEN** a aplicacao exibe os dados atuais do usuario correspondente

### Requirement: Confirmacao de exclusao
O sistema SHALL exigir uma etapa de confirmacao antes de excluir um usuario pela interface web.

#### Scenario: Confirmar exclusao
- **WHEN** o usuario acessa `/usuarios/{cpf}/excluir`
- **THEN** a aplicacao exibe um resumo do registro selecionado
- **AND** oferece uma acao explicita para concluir a exclusao

#### Scenario: Excluir usuario existente
- **WHEN** o usuario confirma a exclusao de um usuario existente
- **THEN** a aplicacao remove o registro
- **AND** redireciona para a listagem com mensagem de sucesso

### Requirement: Separacao entre interface web e API REST
O sistema SHALL preservar os endpoints REST de usuarios sob um prefixo dedicado `/api/usuarios`.

#### Scenario: Consumir API REST existente
- **WHEN** um cliente HTTP chama `/api/usuarios`
- **THEN** a aplicacao responde com o mesmo comportamento CRUD ja suportado anteriormente para usuarios