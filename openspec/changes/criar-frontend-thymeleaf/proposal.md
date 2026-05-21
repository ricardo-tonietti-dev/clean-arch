# Proposta: Criar frontend web com Thymeleaf

## Why

O projeto atualmente expoe apenas endpoints REST para o recurso de usuarios, o que limita a validacao rapida do fluxo por pessoas nao tecnicas e torna a demonstracao do produto mais trabalhosa. Precisamos de uma interface web inicial, acoplada ao backend existente, para navegar pelo CRUD de usuarios diretamente no navegador.

## What Changes

- Adicionar suporte a renderizacao server-side com Thymeleaf.
- Criar um fluxo web em `/usuarios` com listagem, cadastro, edicao e confirmacao de exclusao.
- Preservar os endpoints REST existentes em um prefixo separado `/api/usuarios`.
- Aplicar uma camada visual inicial com Bootstrap e estilos proprios para validar a experiencia antes de iterar o design.
- Tratar estados de feedback da interface, como sucesso, erro, lista vazia e validacoes de formulario.

## Capabilities

### New Capabilities
- `frontend-thymeleaf`: navegar pelo CRUD de usuarios via interface web server-side.

### Modified Capabilities
- `usuarios-api`: mover o endpoint REST de usuarios para um prefixo dedicado sem remover o comportamento atual.

## Impact

- Novos controllers MVC, templates Thymeleaf e assets estaticos.
- Ajuste de roteamento entre interface web e API REST.
- Pequena extensao da camada de aplicacao para consultar usuario por CPF e suportar as telas de edicao e exclusao.