CREATE TABLE product (
		product_id SERIAL PRIMARY KEY,
		product_name VARCHAR(32),
		price DECIMAL(8, 2),
		amount INT,
		promotion BOOLEAN
);
		
CREATE TABLE card (
	card_id SERIAL PRIMARY KEY,
	registration_date DATE NOT NULL DEFAULT CURRENT_DATE,
	total_purchase DECIMAL(10, 2),
	client_id INT
);

INSERT INTO product (product_name, price, amount, promotion)
VALUES
('Rose', 1.2, 208, false),
('Lily', 2.3, 21, false),
('Carnation', 1.75, 46, true),
('Alstromeria', 3.3, 25, false),
('Peony', 5, 12, true),
('Freesa', 1.8, 32, true),
('Chrysantemum', 1, 60, true),
('Hydramgea', 3.8, 8, true),
('Sunflower', 4.4, 15, true);

INSERT INTO card (registration_date, total_purchase, client_id)
VALUES
('2022-07-11', 458.23, 1),
('2022-07-27', 2107.60, 2),
('2022-07-31', 871.17, 3),
('2022-08-8', 1888.23, 4),
('2022-08-19', 1919.23, 5),
('2022-08-29', 119.44, 6),
('2022-09-01', 6000.03, 7);
