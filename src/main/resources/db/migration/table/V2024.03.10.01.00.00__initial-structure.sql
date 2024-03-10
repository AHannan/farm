CREATE TABLE farmer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE crop_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE field (
    id SERIAL PRIMARY KEY,
    planting_area DOUBLE PRECISION NOT NULL,
    farmer_id BIGINT NOT NULL,
CONSTRAINT fk_farmer_field FOREIGN KEY (farmer_id) REFERENCES farmer(id)
);

CREATE TABLE season (
    id SERIAL PRIMARY KEY,
    name VARCHAR(10) NOT NULL
);

CREATE TABLE harvest (
    id SERIAL PRIMARY KEY,
    crop_type_id BIGINT NOT NULL,
    actual_product DOUBLE PRECISION NOT NULL,
    season_id BIGINT NOT NULL,
    field_id BIGINT NOT NULL,
CONSTRAINT fk_crop_type_harvest FOREIGN KEY (crop_type_id) REFERENCES crop_type(id),
CONSTRAINT fk_season_harvest FOREIGN KEY (season_id) REFERENCES season(id),
CONSTRAINT fk_field_harvest FOREIGN KEY (field_id) REFERENCES field(id)
);

CREATE TABLE plant (
    id SERIAL PRIMARY KEY,
    crop_type_id BIGINT NOT NULL,
    expected_product DOUBLE PRECISION NOT NULL,
    season_id BIGINT NOT NULL,
    field_id BIGINT NOT NULL,
CONSTRAINT fk_crop_type_plant FOREIGN KEY (crop_type_id) REFERENCES crop_type(id),
CONSTRAINT fk_season_plant FOREIGN KEY (season_id) REFERENCES season(id),
CONSTRAINT fk_field_plant FOREIGN KEY (field_id) REFERENCES field(id)
);
