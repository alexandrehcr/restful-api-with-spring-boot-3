USE DATABASE cars_api;
-- cars
INSERT INTO cars (id,name,description,category) VALUES (1,'Tucker 1948','Description of Tucker 1948','classic');
INSERT INTO cars (id,name,description,category) VALUES (2,'Chevrolet Corvette','Description of Chevrolet Corvette','classic');
INSERT INTO cars (id,name,description,category) VALUES (3,'Chevrolet Impala Coupe','Description of Chevrolet Impala Coupe','classic');
INSERT INTO cars (id,name,description,category) VALUES (4,'Cadillac Deville Convertible','Description of Cadillac Deville Convertible','classic');
INSERT INTO cars (id,name,description,category) VALUES (5,'Chevrolet Bel-Air','Description of Chevrolet Bel-Air','classic');
INSERT INTO cars (id,name,description,category) VALUES (6,'Cadillac Eldorado','Description of Cadillac Eldorado','classic');
INSERT INTO cars (id,name,description,category) VALUES (7,'Ferrari 250 GTO','Description of Ferrari 250 GTO','classic');
INSERT INTO cars (id,name,description,category) VALUES (8,'Dodge Challenger','Description of Dodge Challenger','classic');
INSERT INTO cars (id,name,description,category) VALUES (9,'Camaro SS 1969','Description of Camaro SS 1969','classic');
INSERT INTO cars (id,name,description,category) VALUES (10,'Ford Mustang 1976','Description of Ford Mustang 1976','classic');
INSERT INTO cars (id,name,description,category) VALUES (11,'Ferrari FF','Description of Ferrari FF','sportive');
INSERT INTO cars (id,name,description,category) VALUES (12,'AUDI GT Spyder','Description of AUDI GT Spyder','sportive');
INSERT INTO cars (id,name,description,category) VALUES (13,'Porsche Panamera','Description of Porsche Panamera','sportive');
INSERT INTO cars (id,name,description,category) VALUES (14,'Lamborghini Aventador','Description of Lamborghini Aventador','sportive');
INSERT INTO cars (id,name,description,category) VALUES (15,'Chevrolet Corvette Z06','Description of Chevrolet Corvette Z06','sportive');
INSERT INTO cars (id,name,description,category) VALUES (16,'BMW M5','Description of BMW M5','sportive');
INSERT INTO cars (id,name,description,category) VALUES (17,'Renault Megane RS Trophy','Description of Renault Megacarsne RS Trophy','sportive');
INSERT INTO cars (id,name,description,category) VALUES (18,'Maserati Grancabrio Sport','Description of Maserati Grancabrio Sport','sportive');
INSERT INTO cars (id,name,description,category) VALUES (19,'McLAREN MP4-12C','Description of McLAREN MP4-12C','sportive');
INSERT INTO cars (id,name,description,category) VALUES (20,'MERCEDES-BENZ C63 AMG','Description of MERCEDES-BENZ C63 AMG','sportive');
INSERT INTO cars (id,name,description,category) VALUES (21,'Bugatti Veyron','Description of Bugatti Veyron','luxury');
INSERT INTO cars (id,name,description,category) VALUES (22,'Ferrari Enzo','Description of Ferrari Enzo','luxury');
INSERT INTO cars (id,name,description,category) VALUES (23,'Lamborghini Reventon','Description of Lamborghini Reventon','luxury');
INSERT INTO cars (id,name,description,category) VALUES (24,'Leblanc Mirabeau','Description of Leblanc Mirabeau','luxury');
INSERT INTO cars (id,name,description,category) VALUES (25,'Shelby Supercars Ultimate','Description of Shelby Supercars Ultimate','luxury');
INSERT INTO cars (id,name,description,category) VALUES (26,'Pagani Zonda','Description of Pagani Zonda','luxury');
INSERT INTO cars (id,name,description,category) VALUES (27,'Koenigsegg CCX','Description of Koenigsegg CCX','luxury');
INSERT INTO cars (id,name,description,category) VALUES (28,'Mercedes SLR McLaren','Description of Mercedes SLR McLaren','luxury');
INSERT INTO cars (id,name,description,category) VALUES (29,'Rolls Royce Phantom','Description of Rolls Royce Phantom','luxury');
INSERT INTO cars (id,name,description,category) VALUES (30,'Lexus LFA','Description of Lexus LFA','luxury');

-- roles
INSERT INTO roles (id,name) VALUES (1,'ROLE_ADMIN');
INSERT INTO roles (id,name) VALUES (2,'ROLE_USER');

-- users
INSERT INTO users (id, email,login,name,password) VALUES (1, 'admin@email.com','admin','admin','$2a$10$sHI5fBdkr74hT9itoQy45eaHLl066MtgvoDavHtKVhoEAanXr81Tq');
INSERT INTO users (id, email,login,name,password) VALUES (2, 'user@email','user','user','$2a$10$dCNBHbBeoOuJktp9CUd.1eZaQg.RiHlFgpr0MZhuOlgX1Bf1w6PMi');

-- user_roles
INSERT INTO user_roles (user_id,role_id) VALUES (1,1);
INSERT INTO user_roles (user_id,role_id) VALUES (2,2);