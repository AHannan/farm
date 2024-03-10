INSERT INTO farmer (id, name) VALUES
(1, 'John Doe'),
(2, 'Jane Smith');

INSERT INTO crop_type (id, name) VALUES
(1, 'Corn'),
(2, 'Potatoes'),
(3, 'Wheat');

INSERT INTO field (id, planting_area, farmer_id) VALUES
(1, 10.5, 1), -- John Doe's field
(2, 8.2, 2);  -- Jane Smith's field

INSERT INTO season (id, name) VALUES
(1, 'Spring'),
(2, 'Summer'),
(3, 'Autumn'),
(4, 'Winter');

INSERT INTO harvest (id, crop_type_id, actual_product, season_id, field_id) VALUES
(1, 1, 100.5, 1, 1), -- Corn harvested by John Doe in Spring
(2, 2, 75.2, 2, 2);  -- Potatoes harvested by Jane Smith in Summer

INSERT INTO plant (id, crop_type_id, expected_product, season_id, field_id) VALUES
(1, 1, 120.0, 1, 1), -- Corn planted by John Doe in Spring
(2, 2, 80.0, 2, 2);  -- Potatoes planted by Jane Smith in Summer
