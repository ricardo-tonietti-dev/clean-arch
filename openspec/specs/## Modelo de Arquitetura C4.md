## Modelo de Arquitetura C4

```mermaid
flowchart TB
  subgraph Sistema
    api[API REST / UsuarioController]
    app[Casos de Uso<br/>Criar, Listar, Alterar, Excluir]
    repo[RepositorioDeUsuario<br/>Interface]
    jpa[RepositorioDeUsuarioJpa]
    db[(PostgreSQL)]
  end

  api --> app
  app --> repo
  repo --> jpa
  jpa --> db
```

### C4Context

- Person(client, "Cliente", "Consumidor da API REST")
- System(api, "codechella API", "Backend Spring Boot")
- SystemDb(db, "Banco de Dados", "PostgreSQL")
- Rel(client, api, "usa")
- Rel(api, db, "persiste dados em")