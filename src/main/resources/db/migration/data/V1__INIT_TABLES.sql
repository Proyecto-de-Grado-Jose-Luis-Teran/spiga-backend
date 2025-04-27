CREATE TABLE product (
    product_id UUID PRIMARY KEY,
    name VARCHAR(255),
    production_unit VARCHAR(255)
);

CREATE TABLE raw_material (
    raw_material_id UUID PRIMARY KEY,
    name VARCHAR(255),
    weight_per_bag_kg FLOAT
);

CREATE TABLE product_raw_material (
    product_id UUID,
    raw_material_id UUID,
    estimated_quantity_kg_per_unit FLOAT,
    PRIMARY KEY (product_id, raw_material_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (raw_material_id) REFERENCES raw_material(raw_material_id)
);

CREATE TABLE production (
    production_id UUID PRIMARY KEY,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    product_id UUID,
    produced_quantity_kg FLOAT,
    shift VARCHAR(100),
    production_line VARCHAR(100),
    operator_name VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE raw_material_consumption (
    consumption_id UUID PRIMARY KEY,
    production_id UUID,
    raw_material_id UUID,
    used_bags_quantity INT,
    total_kg FLOAT,
    FOREIGN KEY (production_id) REFERENCES production(production_id),
    FOREIGN KEY (raw_material_id) REFERENCES raw_material(raw_material_id)
);

CREATE TABLE downtime (
    downtime_id UUID PRIMARY KEY,
    production_id UUID,
    start_datetime TIMESTAMP,
    end_datetime TIMESTAMP,
    downtime_type VARCHAR(255),
    reason VARCHAR(255),
    machine VARCHAR(255),
    FOREIGN KEY (production_id) REFERENCES production(production_id)
);

CREATE TABLE waste (
    waste_id UUID PRIMARY KEY,
    production_id UUID,
    quantity_kg FLOAT,
    reason VARCHAR(255),
    FOREIGN KEY (production_id) REFERENCES production(production_id)
);
