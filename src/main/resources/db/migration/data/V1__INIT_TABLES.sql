CREATE TABLE product (
    product_id INT PRIMARY KEY,
    name VARCHAR(255),
    production_unit VARCHAR(255)
);

CREATE TABLE raw_material (
    raw_material_id INT PRIMARY KEY,
    name VARCHAR(255),
    weight_per_bag_kg FLOAT
);

CREATE TABLE product_raw_material (
    product_id INT,
    raw_material_id INT,
    estimated_quantity_kg_per_unit FLOAT,
    PRIMARY KEY (product_id, raw_material_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (raw_material_id) REFERENCES raw_material(raw_material_id)
);

CREATE TABLE production (
    production_id INT PRIMARY KEY,
    start_date DATETIME,
    end_date DATETIME,
    product_id INT,
    produced_quantity_kg FLOAT,
    shift VARCHAR(100),
    production_line VARCHAR(100),
    operator_name VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE raw_material_consumption (
    consumption_id INT PRIMARY KEY,
    production_id INT,
    raw_material_id INT,
    used_bags_quantity INT,
    total_kg FLOAT,
    FOREIGN KEY (production_id) REFERENCES production(production_id),
    FOREIGN KEY (raw_material_id) REFERENCES raw_material(raw_material_id)
);

CREATE TABLE downtime (
    downtime_id INT PRIMARY KEY,
    production_id INT,
    start_datetime DATETIME,
    end_datetime DATETIME,
    downtime_type VARCHAR(255),
    reason VARCHAR(255),
    machine VARCHAR(255),
    FOREIGN KEY (production_id) REFERENCES production(production_id)
);

CREATE TABLE waste (
    waste_id INT PRIMARY KEY,
    production_id INT,
    quantity_kg FLOAT,
    reason VARCHAR(255),
    FOREIGN KEY (production_id) REFERENCES production(production_id)
);
