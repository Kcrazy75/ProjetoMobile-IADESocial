# Capítulo: Base de Dados

## 1. Introdução

Neste capítulo, apresentamos a Base de Dados desenvolvida para o projeto *IADE Social*. Este sistema inclui as operações de criação de tabelas (*Create*), inserção de dados fictícios (*Insert*), e consultas (*Queries*) para testar e validar a funcionalidade do sistema. A implementação foi realizada utilizando o MySQLWorkbench.

## 2. Estrutura da Base de Dados

A base de dados é composta por seis tabelas principais:

- **Users**: Armazena informações básicas dos utilizadores.
- **Profiles**: Registra os perfis associados aos utilizadores.
- **Posts**: Contém as publicações feitas pelos utilizadores.
- **Comments**: Registra comentários nos posts.
- **Likes**: Armazena as interações de curtidas.
- **Followers**: Representa as relações de seguidores entre os utilizadores.

## 3. Exemplos de Dados

Foram inseridos dados fictícios nas tabelas para testes, incluindo utilizadores, perfis, publicações, comentários, likes e relações de seguidores.

## 4. Consultas

Algumas das consultas relevantes incluem:

- Listar utilizadores e respetivos perfis.
- Contar o número total de posts por utilizador.
- Listar os likes com os utilizadores que os realizaram.
- Identificar utilizadores com mais seguidores.
- Mostrar utilizadores que se seguem mutuamente.
