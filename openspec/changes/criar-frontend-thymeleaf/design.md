# Design: frontend web com Thymeleaf

## Visao geral

O frontend web sera servido pelo proprio Spring Boot usando Thymeleaf, mantendo a aplicacao em renderizacao server-side para reduzir complexidade inicial. O fluxo cobre apenas o recurso de usuarios, que ja existe no backend, e organiza a navegacao em paginas HTML para listagem, cadastro, edicao e confirmacao de exclusao.

## Decisoes principais

### Separacao entre web e API

- A interface web ocupa o prefixo `/usuarios`.
- A API REST existente passa a responder em `/api/usuarios`.
- A rota `/` redireciona para `/usuarios` para dar uma entrada unica ao frontend.

Essa separacao evita conflito de mapeamento entre `@Controller` e `@RestController` e preserva o uso programatico da API.

### Controller MVC dedicado

Foi adotado um controller MVC separado para a interface web, responsavel por:

- carregar a listagem de usuarios
- renderizar o formulario de cadastro e edicao
- renderizar a tela de confirmacao de exclusao
- coordenar mensagens de sucesso e erro por redirect attributes

O controller web chama os casos de uso da aplicacao diretamente, sem depender da API REST interna.

### Consulta por CPF

As telas de edicao e exclusao precisam recuperar um usuario especifico antes de renderizar a pagina. Para isso, a gateway de usuarios ganhou uma operacao de busca por CPF, exposta por um caso de uso dedicado.

### Estrutura de templates

Os templates foram divididos em tres paginas:

- `usuarios/lista.html`
- `usuarios/formulario.html`
- `usuarios/excluir.html`

Essa divisao reduz logica condicional na view e acompanha o mapa de navegacao definido na exploracao.

### Camada visual

- Bootstrap via CDN para grid, componentes base e responsividade.
- CSS proprio em arquivo estatico para identidade visual do fluxo.
- Tipografia e paleta inspiradas no mockup aprovado antes da implementacao.

## Fluxo resumido

1. O usuario acessa `/usuarios` e ve a listagem.
2. Ao escolher cadastrar ou editar, o sistema renderiza `usuarios/formulario.html`.
3. Ao enviar um formulario valido, o sistema persiste os dados e redireciona para a listagem com feedback.
4. Ao escolher excluir, o sistema renderiza `usuarios/excluir.html` com resumo do registro.
5. Ao confirmar a exclusao, o sistema remove o registro e redireciona para a listagem.

## Riscos e limites atuais

- O fluxo ainda depende do banco configurado para subir a aplicacao integralmente.
- Nao foram introduzidos testes automatizados de interface nesta etapa.
- O frontend cobre apenas usuarios, que e o unico recurso funcional exposto no backend atual.