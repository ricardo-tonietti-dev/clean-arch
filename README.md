# Codechella - Desenvolvimento local

## Requisitos

- Java 21
- Docker
- Docker Compose
- curl
- Postman (opcional, para testar a API graficamente)

## Subir o banco local

Na raiz do projeto, em `clean-arch`, execute:

```bash
docker compose up -d
```

Parar o banco:

```bash
docker compose down
```

Resetar o banco removendo o volume:

```bash
docker compose down -v
```

O container sobe um PostgreSQL com os seguintes defaults:

- `POSTGRES_DB=codechella_db`
- `POSTGRES_USER=postgres`
- `POSTGRES_PASSWORD=Info@123`
- `POSTGRES_PORT=5432`

## Subir a aplicacao

Use o profile `docker` para conectar no banco do `docker compose`:

```bash
cd /home/rictoro/cursos/clean-arch
SPRING_PROFILES_ACTIVE=docker ./mvnw spring-boot:run
```

Se o wrapper do Maven nao estiver executando no seu ambiente, ajuste a permissao uma vez:

```bash
chmod +x ./mvnw
```

Com o profile `docker`, a aplicacao sobe em `8080`:

- Frontend: `http://localhost:8080/usuarios`
- Backend REST: `http://localhost:8080/api/usuarios`

Sem o profile `docker`, a aplicacao continua usando a porta `8081`, definida em `application.properties`.

## Carga inicial de usuarios

Ao iniciar a aplicacao, a tabela `usuarios` e reinicializada via `data.sql`.

Para os exemplos deste README, use como referencia os dados presentes em `usuarios.txt`, principalmente estes registros:

- Maria | `789.456.132-25` | `2000-10-15` | `maria@mail.com`
- Jaoa | `789.456.132-25` | `2000-10-15` | `joao@mail.com`
- Ricardo | `789.456.132-25` | `2000-10-15` | `ricardo@mail.com`
- Pri | `789.456.132-25` | `2000-10-15` | `pri@mail.com`

Observacao: o arquivo `usuarios.txt` possui CPF repetido. Para exemplos de criacao abaixo, foi usado um CPF livre para evitar conflito de cadastro.

## Usando o frontend

Fluxo principal no navegador:

1. Abra `http://localhost:8080/usuarios` para listar os usuarios.
2. Clique em `Novo usuario` para abrir o formulario de cadastro.
3. Preencha nome, CPF, nascimento e email e envie o formulario.
4. Use `Editar` para alterar um usuario existente.
5. Use `Excluir` para abrir a tela de confirmacao e confirmar a remocao.

### Frontend via curl

Mesmo sendo um fluxo web, todas as telas e formularios podem ser exercitados com `curl`.

Abrir a home, que redireciona para a listagem:

```bash
curl -i http://localhost:8080/
```

Listar a tela principal de usuarios:

```bash
curl -i http://localhost:8080/usuarios
```

Abrir a tela de novo cadastro:

```bash
curl -i http://localhost:8080/usuarios/novo
```

Cadastrar via formulario web usando os dados da Pri do `usuarios.txt` e um CPF livre:

```bash
curl -i -X POST http://localhost:8080/usuarios \
	-H 'Content-Type: application/x-www-form-urlencoded' \
	--data-urlencode 'nome=Pri' \
	--data-urlencode 'cpf=789.456.132-26' \
	--data-urlencode 'nascimento=2000-10-15' \
	--data-urlencode 'email=pri@mail.com'
```

Abrir a tela de edicao da Maria:

```bash
curl -i http://localhost:8080/usuarios/789.456.132-25/editar
```

Atualizar a Maria via formulario web:

```bash
curl -i -X POST http://localhost:8080/usuarios/789.456.132-25 \
	-H 'Content-Type: application/x-www-form-urlencoded' \
	--data-urlencode 'nome=Maria Atualizada' \
	--data-urlencode 'cpf=789.456.132-25' \
	--data-urlencode 'nascimento=2000-10-15' \
	--data-urlencode 'email=maria@mail.com'
```

Abrir a tela de confirmacao de exclusao da Maria:

```bash
curl -i http://localhost:8080/usuarios/789.456.132-25/excluir
```

Confirmar a exclusao da Maria:

```bash
curl -i -X POST http://localhost:8080/usuarios/789.456.132-25/excluir
```

## Usando o backend via Postman

Base URL para colecao ou requests avulsos:

```text
http://localhost:8080/api/usuarios
```

No Postman, use `Body > raw > JSON` para `POST` e `PUT`.

### 1. Listar usuarios

Metodo: `GET`

URL:

```text
http://localhost:8080/api/usuarios
```

curl equivalente:

```bash
curl -i http://localhost:8080/api/usuarios
```

### 2. Cadastrar usuario

Metodo: `POST`

URL:

```text
http://localhost:8080/api/usuarios
```

Body JSON de exemplo usando os dados da Pri do `usuarios.txt` e um CPF livre:

```json
{
	"cpf": "789.456.132-26",
	"nome": "Pri",
	"nascimento": "2000-10-15",
	"email": "pri@mail.com"
}
```

curl equivalente:

```bash
curl -i -X POST http://localhost:8080/api/usuarios \
	-H 'Content-Type: application/json' \
	-d '{
		"cpf": "789.456.132-26",
		"nome": "Pri",
		"nascimento": "2000-10-15",
		"email": "pri@mail.com"
	}'
```

### 3. Atualizar usuario

Metodo: `PUT`

URL:

```text
http://localhost:8080/api/usuarios/789.456.132-25
```

Body JSON de exemplo usando a Maria como referencia:

```json
{
	"cpf": "789.456.132-25",
	"nome": "Maria Atualizada",
	"nascimento": "2000-10-15",
	"email": "maria@mail.com"
}
```

curl equivalente:

```bash
curl -i -X PUT http://localhost:8080/api/usuarios/789.456.132-25 \
	-H 'Content-Type: application/json' \
	-d '{
		"cpf": "789.456.132-25",
		"nome": "Maria Atualizada",
		"nascimento": "2000-10-15",
		"email": "maria@mail.com"
	}'
```

### 4. Excluir usuario

Metodo: `DELETE`

URL:

```text
http://localhost:8080/api/usuarios/789.456.132-25
```

curl equivalente:

```bash
curl -i -X DELETE http://localhost:8080/api/usuarios/789.456.132-25
```

## Resumo rapido

Subir banco e aplicacao:

```bash
cd /home/rictoro/cursos/clean-arch
docker compose up -d
SPRING_PROFILES_ACTIVE=docker ./mvnw spring-boot:run
```

Collection Postman versionada no repositorio:

- `postman/Codechella.postman_collection.json`

Entradas principais:

- Frontend: `http://localhost:8080/usuarios`
- Backend: `http://localhost:8080/api/usuarios`
