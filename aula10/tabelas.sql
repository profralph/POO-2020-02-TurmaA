CREATE TABLE IF NOT EXISTS produto(

    id_produto INTEGER,
    nome NVARCHAR(100),
    preco NUMERIC(10,2)
);

INSERT INTO produto(id_produto, nome, preco) VALUES(1, 'Mesa', 89.90);
INSERT INTO produto(id_produto, nome, preco) VALUES(2, 'Cadeira', 34.40);

