CREATE DATABASE IF NOT EXISTS StockMasterDB;
USE StockMasterDB;

CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(100) NOT NULL UNIQUE,
passwordHash VARCHAR(255) NOT NULL
);

CREATE TABLE customers (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(150) NOT NULL,
document VARCHAR(50) NOT NULL UNIQUE,
address VARCHAR(255) NOT NULL,
number VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
notes TEXT
);

CREATE TABLE employers (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
personalId VARCHAR(50) NOT NULL UNIQUE,
address VARCHAR(255) NOT NULL,
number VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
role VARCHAR(100) NOT NULL
);

CREATE TABLE suppliers (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
taxId VARCHAR(50) NOT NULL UNIQUE,
address VARCHAR(255) NOT NULL,
number VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
notes TEXT
);

CREATE TABLE products (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
category VARCHAR(100) NOT NULL,
supplierId INT NOT NULL,
quantity INT NOT NULL,
costValue DECIMAL(15,2) NOT NULL,
sellValue DECIMAL(15,2) NOT NULL,
notes TEXT,
FOREIGN KEY (supplierId) REFERENCES suppliers(id) ON DELETE CASCADE
);

CREATE TABLE sales (
id INT AUTO_INCREMENT PRIMARY KEY,
productId INT NOT NULL,
customerId INT NOT NULL,
quantity INT NOT NULL,
saleDate DATE NOT NULL,
value DECIMAL(15, 2) NOT NULL,
profit DECIMAL(15, 2) NOT NULL,
FOREIGN KEY (productId) REFERENCES products(id)ON DELETE CASCADE,
FOREIGN KEY (customerId) REFERENCES customers(id) ON DELETE CASCADE
);

CREATE TABLE stock_entries(
id INT AUTO_INCREMENT PRIMARY KEY,
productId INT NOT NULL,
supplierId INT NOT NULL,
quantity INT NOT NULL,
entryDate DATE NOT NULL,
notes TEXT,
FOREIGN KEY (productId) REFERENCES products(id) ON DELETE CASCADE,
FOREIGN KEY (supplierId) REFERENCES suppliers(id) ON DELETE CASCADE
);

CREATE TABLE stock_outs(
id INT AUTO_INCREMENT PRIMARY KEY,
productId INT NOT NULL,
quantity INT NOT NULL,
exitDate DATE NOT NULL,
notes TEXT NOT NULL,
FOREIGN KEY (productId) REFERENCES products(id) ON DELETE CASCADE
);

-- Inserts --
-- 1. Usuários do sistema
INSERT INTO users (username, passwordHash)
VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3');

-- 2. Clientes
INSERT INTO customers (name, document, address, number, email, notes)
VALUES ('João Silva', '12345678900', 'Rua das Flores', '11987654321', 'joaosilva@email.com', 'Cliente preferencial');

-- 3. Funcionários
INSERT INTO employers (name, personalId, address, number, email, role)
VALUES ('Maria Souza', '98765432100', 'Av. Central', '11912345678', 'maria.souza@email.com', 'Estoquista');

-- 4. Fornecedores
INSERT INTO suppliers (name, taxId, address, number, email, notes)
VALUES ('Fornecedor XPTO', '55444333000122', 'Rua Industrial', '1133334444', 'contato@xpto.com.br', 'Fornecedor oficial de eletrônicos');

-- 5. Produtos (ligado ao fornecedor 1)
INSERT INTO products (name, category, supplierId, quantity, costValue, sellValue, notes)
VALUES ('Mouse Gamer', 'Periféricos', 1, 50, 5000.00, 12000.00, 'Modelo RGB com 6 botões');

-- 6. Vendas (ligado ao cliente 1 e produto 1)
INSERT INTO sales (productId, customerId, quantity, saleDate, value, profit)
VALUES (1, 1, 2, '2025-09-21', 24000.00, 14000.00);

-- 7. Entradas de estoque (produto 1 vindo do fornecedor 1)
INSERT INTO stock_entries (productId, supplierId, quantity, entryDate, notes)
VALUES (1, 1, 20, '2025-09-15', 'Reposição inicial de estoque');

-- 8. Saídas de estoque (produto 1 vendido)
INSERT INTO stock_outs (productId, quantity, exitDate, notes)
VALUES (1, 2, '2025-09-21', 'Venda para cliente João Silva');