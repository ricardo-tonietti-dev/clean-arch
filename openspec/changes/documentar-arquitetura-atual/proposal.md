# Proposta: Documentar a Arquitetura Atual do Projeto

## Objetivo

Gerar documentação de arquitetura do projeto `codechella` seguindo o padrão OpenSpec, com foco na estrutura atual de pacotes, principais entidades, casos de uso implementados e tecnologias utilizadas.

## Contexto

O projeto é um backend Java com Spring Boot estruturado em camadas de domínio, casos de uso, adaptadores e infraestrutura. Embora a arquitetura esteja alinhada a conceitos de Clean Architecture, não existe atualmente uma especificação formal que descreva os limites de cada camada, os fluxos de dados e os pontos de integração.

## O que será entregue

- Uma especificação OpenSpec detalhada em `openspec/specs/arquitetura-atual.spec.md`.
- Um diagrama de componentes que ilustra a relação entre API REST, casos de uso, portas e adaptadores de persistência.
- Um conjunto de artefatos OpenSpec de proposta, design e tarefas para formalizar e rastrear essa documentação como uma mudança.

## Benefícios

- Facilita a comunicação entre desenvolvedores sobre a arquitetura atual.
- Serve de base para futuras refatorações e melhorias.
- Ajuda a identificar lacunas entre modelo de domínio e persistência.
- Alinha o projeto com disciplina de documentação OpenSpec.
