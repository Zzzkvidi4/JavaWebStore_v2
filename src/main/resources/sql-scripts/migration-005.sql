INSERT
  INTO product_types(product_type_id, name)
  VALUES (1, 'Videocard');

INSERT
  INTO product_types(product_type_id, name)
  VALUES (2, 'Motherboard');

INSERT
  INTO product_types(product_type_id, name)
  VALUES (3, 'CPU');

INSERT
  INTO countries(country_id, name)
  VALUES (1, 'USA');

INSERT
  INTO countries(country_id, name)
  VALUES (2, 'Korea');

INSERT
  INTO countries(country_id, name)
  VALUES (3, 'England');

INSERT
  INTO products(product_id, product_type_id, country_id, name, count, price)
  VALUES (1, 1, 1, 'Acer GTX 1050 TI', 100, 9900.50);

INSERT
  INTO products(product_id, product_type_id, country_id, name, count, price)
  VALUES (2, 1, 2, 'Acer GT 750 TI', 65, 7500.50);

INSERT
  INTO products(product_id, product_type_id, country_id, name, count, price)
  VALUES (3, 1, 2, 'Acer Radeon 560X', 100, 12000.50);

INSERT
  INTO products(product_id, product_type_id, country_id, name, count, price)
  VALUES (4, 2, 1, 'Acer M930', 20, 4000.50);

INSERT
INTO products(product_id, product_type_id, country_id, name, count, price)
VALUES (5, 3, 1, 'i7-9350', 20, 4000.50);

INSERT
INTO products(product_id, product_type_id, country_id, name, count, price)
VALUES (6, 3, 1, 'FX-8350', 20, 8000);

INSERT
INTO products(product_id, product_type_id, country_id, name, count, price)
VALUES (7, 3, 3, 'FX-6350', 10, 6000);