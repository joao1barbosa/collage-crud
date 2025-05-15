 Collage CRUD

Este projeto é uma aplicação simples de cadastro e controle de estudantes e usuários, com autenticação e controle de acesso baseado em cargos. Utiliza Java com Maven, PostgreSQL como banco de dados e integração via Docker para facilitar o setup do ambiente.

## 🚀 Funcionalidades

- Cadastro, listagem, edição e remoção de estudantes.
- Cadastro e autenticação de usuários.
- Controle de acesso com base no cargo (admin ou user).
- Banco de dados inicializado automaticamente com dados de exemplo.
- Execução via terminal ou IDE.

## 🐳 Setup com Docker

1. Certifique-se de ter o Docker.
2. Execute o script de configuração:

```sh
./config_db.sh
```

Isso criará um contêiner PostgreSQL com os scripts SQL executados automaticamente.

## 💻 Executando a Aplicação

Após configurar o banco, a aplicação pode ser executada de duas formas:
1. Via IDE

Abra o projeto em sua IDE Java favorita (como IntelliJ ou Eclipse) e execute a classe Main.java.
2. Via Terminal

Certifique-se de estar na raiz do projeto e execute:

```sh
mvn compile
mvn exec:java
```

## 🔐 Controle de Acesso

O sistema define dois tipos de usuário:

  - ADMIN: Acesso total a todas as funcionalidades (CRUD completo).

  - USER: Acesso apenas à visualização de seus próprios dados (sem CPF e ID).

O vínculo entre o usuário comum e os dados do estudante é feito por meio da matrícula (chave estrangeira).

As verificações de acesso são feitas tanto na camada de serviço quanto em verificações adicionais nas requisições de administrador.

## 🧪 Scripts SQL

Os scripts SQL na pasta initdb/ são executados em ordem alfabética na criação do banco:

1. Criação da tabela de alunos.
2. Inserção de alunos de exemplo.
3. Criação da tabela de usuários.
4. Inserção de usuários de exemplo (um admin e um user).

## 📄 Licença

Este projeto está licenciado sob a [MIT License](https://github.com/joao1barbosa/collage-crud/blob/main/LICENSE).
