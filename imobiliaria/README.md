TRABALHO IMOBILIARIA
-
Diagrama UML
-
![UML](https://github.com/user-attachments/assets/e7349574-e042-4a8b-bebb-1c8d4965c00f)
-
Diagrama MER
-
![MER](https://github.com/user-attachments/assets/cf0fe981-42ff-4052-9f9d-85e5e5d05d82)
-
INSTRUÇÕES SQL
-
Criação do Banco
````sql
CREATE DATABASE IF NOT EXISTS imobiliaria;
use imobiliaria;

CREATE TABLE cliente (
  id_cliente INT AUTO_INCREMENT PRIMARY KEY,
  nome       VARCHAR(120) NOT NULL,
  cpf        CHAR(11) NOT NULL UNIQUE,
  telefone   VARCHAR(20),
  email      VARCHAR(120)
);

CREATE TABLE imovel (
  id_imovel  INT AUTO_INCREMENT PRIMARY KEY,
  tipo       VARCHAR(40) NOT NULL,            
  endereco   VARCHAR(200) NOT NULL,
  cidade     VARCHAR(80) NOT NULL,
  estado     CHAR(2) NOT NULL,
  cep        CHAR(8),
  quartos    INT DEFAULT 0,
  banheiros  INT DEFAULT 0,
  area_m2    DECIMAL(10,2),
  valor_aluguel_sugerido DECIMAL(10,2),
  status     ENUM('DISPONIVEL','ALUGADO','INATIVO') NOT NULL DEFAULT 'DISPONIVEL'
);

CREATE TABLE contrato (
  id_contrato INT AUTO_INCREMENT PRIMARY KEY,
  id_imovel   INT NOT NULL,
  id_cliente  INT NOT NULL,
  valor_mensal DECIMAL(10,2) NOT NULL,
  data_inicio DATE NOT NULL,
  data_fim    DATE NOT NULL,
  ativo       BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT fk_contrato_imovel  FOREIGN KEY (id_imovel)  REFERENCES imovel(id_imovel),
  CONSTRAINT fk_contrato_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
  CONSTRAINT chk_datas CHECK (data_fim > data_inicio)
);
````
Inserção de Registros
````sql
INSERT INTO cliente (nome, cpf, telefone, email) VALUES
('Lucas Costa', '12345678901', '47999990001', 'lucas@gmail.com'),
('Jalison Santos', '98765432100', '47999990002', 'jali@gmail.com'),
('Victor Hugo', '55522277788', '47999990003', 'vitinho@gmail.com');

INSERT INTO imovel (tipo, endereco, cidade, estado, cep, quartos, banheiros, area_m2, valor_aluguel_sugerido, status) VALUES
('Apartamento', 'Rua A, 100', 'Joinville', 'SC', '89200000', 2, 1, 60.0, 2000.00, 'DISPONIVEL'),
('Casa',        'Rua B, 200', 'Joinville', 'SC', '89200001', 3, 2,120.0, 3500.00, 'DISPONIVEL'),
('Sala',        'Av. C, 300', 'Joinville', 'SC', '89200002', 0, 1, 35.0, 1500.00, 'DISPONIVEL');

INSERT INTO contrato (id_imovel, id_cliente, valor_mensal, data_inicio, data_fim, ativo)
VALUES (1, 1, 2100.00, '2025-08-01', '2026-07-31', TRUE);
````
