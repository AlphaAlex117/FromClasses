-- Author: Alexander Lafontaine

SET SQL_SAFE_UPDATES = 0;
DELETE FROM `purchase`;
DELETE FROM `bought_from`;
DELETE FROM `products`;
DELETE FROM `product_type`;
DELETE FROM `suppliers`;
DELETE FROM `ingredients`;
DELETE FROM `customers`;
DELETE FROM `hourly_workers`;
DELETE FROM `fulltime_workers`;
DELETE FROM `managers`;
DELETE FROM `employees`;
SET SQL_SAFE_UPDATES = 1;

INSERT INTO `employees` VALUES (100, 'Alexander', 'Lafontaine', '2229 Lincoln Way, Ames, IA 50011', 1001001000), (101, 'Alexa', 'Fuentes', '2229 Lincoln Way, Ames, IA 50011', 2002002000), (102, 'Alex', 'Le Fuente', '2229 Lincoln Way, Ames, IA 50011', 3003003000), (103, 'Xander', 'Fountain', '2229 Lincoln Way, Ames, IA 50011', 4004004000), (104, 'Alexandre', 'Fountaine', '2229 Lincoln Way, Ames, IA 50011', 5005005000),
(105, 'Alejandro', 'La Fuente', '2229 Lincoln Way, Ames, IA 50011', 6006006000), (106, 'Alexandra', 'The Fountain', '2229 Lincoln Way, Ames, IA 50011', 6006006000), (107, 'Alejandra', 'La Fuente', '2229 Lincoln Way, Ames, IA 50011', 6006006000), (108, 'Alexai', 'Fontanez', '2229 Lincoln Way, Ames, IA 50011', 6006006000), (109, 'Alexis', 'Fuentes', '2229 Lincoln Way, Ames, IA 50011', 6006006000),
(110, 'Aleksandr', 'Fontan', '2229 Lincoln Way, Ames, IA 50011', 6006006000), (111, 'Aleksandar', 'Fontanata', '2229 Lincoln Way, Ames, IA 50011', 6006006000), (112, 'İskender', 'Çeşme', '2229 Lincoln Way, Ames, IA 50011', 6006006000);
INSERT INTO `managers` VALUES (100, 10, 300000, 101), (101, 2, 300000, 102), (102, 3, 300000, 103), (103, 4, 300000, 104);
INSERT INTO `fulltime_workers` VALUES (104, 'Title1', 200000), (105, 'Title2', 200000), (106, 'Title1', 200000), (107, 'Title2', 200000);
INSERT INTO `hourly_workers` VALUES (108, 12, 13, 'Specialty1'), (109, 12, 13, 'Specialty2'), (110, 12, 13, 'Specialty1'), (111, 12, 13, 'Specialty2');
INSERT INTO `customers` VALUES (200, 'Arissa', 'Morris', '2229 Lincoln Way, Ames, IA 50011', 7007007000), (201, 'Courtnie', 'Obrien', '2229 Lincoln Way, Ames, IA 50011', 7007007000), (202, 'Coen', 'Reed', '2229 Lincoln Way, Ames, IA 50011', 7007007000), (203, 'Dave', 'Galvan', '2229 Lincoln Way, Ames, IA 50011', 7007007000);
INSERT INTO `ingredients` VALUES (1, 'Potato'), (2, 'Apple'), (3, 'Mayo'), (4, 'Egg');
INSERT INTO `suppliers` VALUES ('PotatoBrand', '2229 Lincoln Way, Ames, IA 50011'), ('AppleInc', '2229 Lincoln Way, Ames, IA 50011'), ('MayoCo', '2229 Lincoln Way, Ames, IA 50011'), ('EggBoiInc', '2229 Lincoln Way, Ames, IA 50011');
INSERT INTO `product_type` VALUES ('Vegetable'), ('Fruit'), ('Sauce'), ('Protein');
INSERT INTO `products` VALUES (300, 'Potato Salad', 5.99, 10, 108, 'Vegetable'), (301, 'Potato Salad2', 5.99, 10, 109, 'Fruit'), (302, 'Potato Salad3', 5.99, 10, 110, 'Sauce'), (303, 'Potato Salad', 5.99, 10, 111, 'Protein');
INSERT INTO `bought_from` VALUES (300, 1, 'PotatoBrand', 10, 1.99, '2022-01-01'), (301, 2, 'AppleInc', 10, 1.99, '2022-01-01'), (302, 3, 'MayoCo', 10, 1.99, '2022-01-01'), (303, 4, 'EggBoiInc', 10, 1.99, '2022-01-01');
INSERT INTO `purchase` VALUES (300, 200, 1), (301, 201, 2), (302, 202, 1), (303, 203, 3);