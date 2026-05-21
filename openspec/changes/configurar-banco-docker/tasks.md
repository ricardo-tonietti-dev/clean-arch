## 1. Infra de banco local

- [x] 1.1 Adicionar `docker-compose.yml` com Postgres, volume persistente e porta configuravel
- [x] 1.2 Criar `.env.example` com `DB_HOST`, `DB_USER`, `DB_PASSWORD` e porta do Postgres

## 2. Alinhamento de configuracao da aplicacao

- [x] 2.1 Revisar `application.properties` para garantir defaults compativeis com o compose
- [x] 2.2 Documentar como sobrescrever variaveis de ambiente sem alterar codigo

## 3. Documentacao e validacao

- [x] 3.1 Atualizar README ou docs com prerequisitos e comandos (subir/parar/resetar)
- [x] 3.2 Validar fluxo: subir banco, iniciar app e confirmar conexao
- [x] 3.3 Alterar a documentacao e os diagramas de arquitetura, se necessario

## 4. Testes e execucao

- [x] 4.1 Ajustar testes para usar o banco local via Docker quando necessario
- [x] 4.2 Garantir a execucao da aplicacao apontando para o banco Docker
