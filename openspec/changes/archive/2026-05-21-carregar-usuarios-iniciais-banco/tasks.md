## 1. Preparacao dos dados de referencia

- [x] 1.1 Revisar os usuarios definidos em `UtilizaUsuarioComArquivo.java`
- [x] 1.2 Corrigir CPFs duplicados para manter consistencia com a busca por CPF

## 2. Bootstrap do banco

- [x] 2.1 Excluir todos os dados existentes da tabela `usuarios` antes da carga inicial
- [x] 2.2 Criar os `INSERTs` com os usuarios definidos no arquivo de referencia
- [x] 2.3 Ajustar a configuracao da aplicacao para executar o script SQL no Postgres

## 3. Validacao

- [x] 3.1 Validar a compilacao da aplicacao com a nova carga inicial
- [x] 3.2 Atualizar a documentacao do ambiente local com o comportamento do seed
