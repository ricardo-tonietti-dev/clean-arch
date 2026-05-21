# Design da Proposta: Documentar Arquitetura Atual

## Escopo do design

A documentação deve cobrir:
- Pacotes e responsabilidades por camada.
- Entidades de domínio e mapeamento de persistência.
- Casos de uso existentes e seus fluxos.
- Tecnologia empregada e dependências de infraestrutura.
- Diagrama de componentes que mostra as dependências entre controller, casos de uso, porta de repositório, adaptador JPA e banco de dados.

## Abordagem

1. Usar o documento existente `openspec/specs/arquitetura-atual.spec.md` como especificação principal.
2. Enriquecer o documento com um diagrama de componentes Mermaid para facilitar visualização.
3. Capturar observações arquiteturais e pontos de melhoria como parte da especificação.
4. Registrar a mudança em `openspec/changes/documentar-arquitetura-atual/` para manter traço de um novo trabalho OpenSpec.

## Critérios de aceitação

- A especificação descreve claramente as camadas: Domain, Use Cases, Adapters, Infrastructure.
- O diagrama de componentes ilustra o fluxo entre controlador, casos de uso, repositório e banco.
- Existe um artefato de proposta e um conjunto de tarefas para completar a mudança.
- A especificação menciona as tecnologias principais: Spring Boot, Spring Data JPA, PostgreSQL, Hibernate e Java 17.
