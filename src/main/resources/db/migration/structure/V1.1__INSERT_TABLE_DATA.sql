INSERT INTO product (product_id, name, production_unit) VALUES
    (1, 'Codo', 'gr'),
    (2, 'Tubo Delgado', 'gr'),
    (3, 'Tornillo', 'gr');

INSERT INTO raw_material (raw_material_id, name, weight_per_bag_kg) VALUES
    (1, 'Pampa Blanca', 25.0),
    (2, 'Ovoplus', 80.0),
    (3, 'Pampa Blanca', 30.0);

INSERT INTO product_raw_material (product_id, raw_material_id, estimated_quantity_kg_per_unit) VALUES
    (1, 1, 0.95),
    (1, 2, 0.05),
    (2, 1, 0.90),
    (2, 2, 0.10),
    (3, 1, 0.92),
    (3, 2, 0.07),
    (3, 3, 0.01);

INSERT INTO production (production_id, start_date, end_date, product_id, produced_quantity_kg, shift, production_line, operator_name) VALUES
    (1, '2025-04-22 06:00:00', '2025-04-22 14:00:00', 1, 1000.0, 'Mañana', 'Linea 1', 'Raul Soliz'),
    (2, '2025-04-22 14:00:00', '2025-04-22 22:00:00', 2, 850.0, 'Tarde', 'Linea 2', 'Paul Quiroga');

INSERT INTO raw_material_consumption (consumption_id, production_id, raw_material_id, used_bags_quantity, total_kg) VALUES
    (1, 1, 1, 40, 1000.0),
    (2, 1, 2, 0, 50.0),
    (3, 2, 1, 34, 850.0),
    (4, 2, 2, 0, 85.0);

INSERT INTO downtime (downtime_id, production_id, start_datetime, end_datetime, downtime_type, reason, machine) VALUES
    (1, 1, '2025-04-22 09:30:00', '2025-04-22 10:00:00', 'Mantenimiento', 'Lubricación', 'Mixer A'),
    (2, 2, '2025-04-22 17:45:00', '2025-04-22 18:15:00', 'Falla', 'Sobrecalentamiento de la bobina', 'Conveyor 2');

INSERT INTO waste (waste_id, production_id, quantity_kg, reason) VALUES
    (1, 1, 20.0, 'Empaquetamiento roto'),
    (2, 2, 15.0, 'Exceso de producto');
