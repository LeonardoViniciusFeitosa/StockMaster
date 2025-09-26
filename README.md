# StockMaster (Em desenvolvimento)

## Descrição
O **StockMaster** é um sistema desktop para gestão de estoque de empresas, desenvolvido em Java com JPA/Hibernate e MySQL. Ele permite o cadastro e controle de produtos, fornecedores, clientes, funcionários, entradas e saídas de estoque, além de gerenciamento de vendas.

## Tecnologias Utilizadas
* Java
* Maven (gerenciamento de dependências)
* Jakarta Persistence (JPA) com Hibernate 
* MySQL
* Swing (Java Desktop) para interface gráfica

## Funcionalidades
* Cadastro e gerenciamento de produtos
* Cadastro de fornecedores
* Cadastro de clientes
* Cadastro de funcionários
* Registro de entradas e saídas de estoque
* Controle de vendas
* Sistema de login

## Estrutura do Projeto
```
StockMasterDB/
├── src/main/java/br/com/stockmaster/stockmasterdb/
│   ├── classes/       # Entidades JPA (User, Customer, Product, Supplier, etc.)
│   ├── dao/           # DAOs para acesso ao banco de dados
│   ├── util/          # Utilitários (ex: JPAUtil)
│   └── view/          # Telas Swing (cadastros, login, menus)
├── src/main/resources/
│   └── META-INF/persistence.xml  # Configuração JPA/Hibernate
├── database SQL/
│   └── StockMasterDB.SQL         # Script de criação do banco de dados e tabelas
├── pom.xml                       # Configuração Maven e dependências
└── README.md
```
## Configuração e Execução
### 1. Pré-requisitos
* Java 17+
* Maven 3.8+
* MySQL 8+

### 2. Criar Banco de Dados;
O projeto inclui o script database SQL/StockMasterDB.SQL, que cria o banco de dados StockMasterDB, todas as tabelas e registros iniciais. Para criar o banco:

Abra seu SGBD (MySQL Workbench, DBeaver ou outro cliente MySQL).

Execute o script database SQL/StockMasterDB.SQL.

O script já contém o comando ```CREATE DATABASE IF NOT EXISTS StockMasterDB;```.

Verifique se o banco foi criado corretamente.

### 3. Configurar Credenciais
Edite o arquivo ```src/main/resources/META-INF/persistence.xml``` e ajuste o usuário e senha do banco:
```
<property name="jakarta.persistence.jdbc.user" value="YOURUSER" />
<property name="jakarta.persistence.jdbc.password" value="YOURPASSWORD" />
```

### 4. Compilar e Executar
No terminal, dentro da pasta do projeto:
```
mvn clean install
mvn exec:java
```
(ou execute a classe principal diretamente pela sua IDE, como IntelliJ ou NetBeans).

### 5. Acesso ao Sistema
Após iniciar o sistema, utilize as credenciais já cadastradas no banco:
* Usuário: admin
* Senha: admin

**Importante:** este usuário foi inserido no banco com senha em hash MD5 (21232f297a57a5a743894a0e4a801fc3) e já estará disponível após rodar o script StockMasterDB.SQL.
Se desejar, é possível criar novos usuários clicando em “Ainda não tem uma conta?” na tela de login.

### Autores
Projeto desenvolvido por Leonardo Vinicius.
