INSERT INTO cars (name,description,category) VALUES ('Tucker 1948','Description of Tucker 1948','classic');
INSERT INTO cars (name,description,category) VALUES ('Chevrolet Corvette','Description of Chevrolet Corvette','classic');
INSERT INTO cars (name,description,category) VALUES ('Chevrolet Impala Coupe','Description of Chevrolet Impala Coupe','classic');
INSERT INTO cars (name,description,category) VALUES ('Cadillac Deville Convertible','Description of Cadillac Deville Convertible','classic');
INSERT INTO cars (name,description,category) VALUES ('Chevrolet Bel-Air','Description of Chevrolet Bel-Air','classic');
INSERT INTO cars (name,description,category) VALUES ('Cadillac Eldorado','Description of Cadillac Eldorado','classic');
INSERT INTO cars (name,description,category) VALUES ('Ferrari 250 GTO','Description of Ferrari 250 GTO','classic');
INSERT INTO cars (name,description,category) VALUES ('Dodge Challenger','Description of Dodge Challenger','classic');
INSERT INTO cars (name,description,category) VALUES ('Camaro SS 1969','Description of Camaro SS 1969','classic');
INSERT INTO cars (name,description,category) VALUES ('Ford Mustang 1976','Description of Ford Mustang 1976','classic');

INSERT INTO cars (name,description,category) VALUES ('Ferrari FF','Description of Ferrari FF','sportive');
INSERT INTO cars (name,description,category) VALUES ('AUDI GT Spyder','Description of AUDI GT Spyder','sportive');
INSERT INTO cars (name,description,category) VALUES ('Porsche Panamera','Description of Porsche Panamera','sportive');
INSERT INTO cars (name,description,category) VALUES ('Lamborghini Aventador','Description of Lamborghini Aventador','sportive');
INSERT INTO cars (name,description,category) VALUES ('Chevrolet Corvette Z06','Description of Chevrolet Corvette Z06','sportive');
INSERT INTO cars (name,description,category) VALUES ('BMW M5','Description of BMW M5','sportive');
INSERT INTO cars (name,description,category) VALUES ('Renault Megane RS Trophy','Description of Renault Megane RS Trophy','sportive');
INSERT INTO cars (name,description,category) VALUES ('Maserati Grancabrio Sport','Description of Maserati Grancabrio Sport','sportive');
INSERT INTO cars (name,description,category) VALUES ('McLAREN MP4-12C','Description of McLAREN MP4-12C','sportive');
INSERT INTO cars (name,description,category) VALUES ('MERCEDES-BENZ C63 AMG','Description of MERCEDES-BENZ C63 AMG','sportive');

INSERT INTO cars (name,description,category) VALUES ('Bugatti Veyron','Description of Bugatti Veyron','luxury');
INSERT INTO cars (name,description,category) VALUES ('Ferrari Enzo','Description of Ferrari Enzo','luxury');
INSERT INTO cars (name,description,category) VALUES ('Lamborghini Reventon','Description of Lamborghini Reventon','luxury');
INSERT INTO cars (name,description,category) VALUES ('Leblanc Mirabeau','Description of Leblanc Mirabeau','luxury');
INSERT INTO cars (name,description,category) VALUES ('Shelby Supercars Ultimate','Description of Shelby Supercars Ultimate','luxury');
INSERT INTO cars (name,description,category) VALUES ('Pagani Zonda','Description of Pagani Zonda','luxury');
INSERT INTO cars (name,description,category) VALUES ('Koenigsegg CCX','Description of Koenigsegg CCX','luxury');
INSERT INTO cars (name,description,category) VALUES ('Mercedes SLR McLaren','Description of Mercedes SLR McLaren','luxury');
INSERT INTO cars (name,description,category) VALUES ('Rolls Royce Phantom','Description of Rolls Royce Phantom','luxury');
INSERT INTO cars (name,description,category) VALUES ('Lexus LFA','Description of Lexus LFA','luxury');


INSERT INTO roles (id, name) VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT INTO users (id, email, login, name, password) VALUES (1,NULL,'admin','admin','$2a$10$sHI5fBdkr74hT9itoQy45eaHLl066MtgvoDavHtKVhoEAanXr81Tq');
INSERT INTO users (id, email, login, name, password) VALUES (2,NULL,'user','user','$2a$10$dCNBHbBeoOuJktp9CUd.1eZaQg.RiHlFgpr0MZhuOlgX1Bf1w6PMi');

INSERT INTO user_roles (user_id, role_id) VALUES (1,1),(2,2);
