INSERT INTO product (product_id, name, production_unit) VALUES
    ('550e8400-e29b-41d4-a716-446655440000', 'Codo', 'gr'),
    ('550e8400-e29b-41d4-a716-446655440001', 'Tubo Delgado', 'gr'),
    ('550e8400-e29b-41d4-a716-446655440002', 'Tornillo', 'gr');

INSERT INTO raw_material (raw_material_id, name, weight_per_bag_kg) VALUES
    ('550e8400-e29b-41d4-a716-446655440003', 'Pampa Blanca', 25.0),
    ('550e8400-e29b-41d4-a716-446655440004', 'Ovoplus', 80.0),
    ('550e8400-e29b-41d4-a716-446655440005', 'Pampa Blanca', 30.0);

INSERT INTO product_raw_material (product_id, raw_material_id, estimated_quantity_kg_per_unit) VALUES
    ('550e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440003', 0.95),
    ('550e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440004', 0.05),
    ('550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440003', 0.90),
    ('550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440004', 0.10),
    ('550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440003', 0.92),
    ('550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440004', 0.07),
    ('550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440005', 0.01);

INSERT INTO production (production_id, start_date, end_date, product_id, produced_quantity_kg, shift, production_line, operator_name) VALUES
    ('550e8400-e29b-41d4-a716-446655440006', '2025-04-22 06:00:00', '2025-04-22 14:00:00', '550e8400-e29b-41d4-a716-446655440000', 1000.0, 'Mañana', 'Linea 1', 'Raul Soliz'),
    ('550e8400-e29b-41d4-a716-446655440007', '2025-04-22 14:00:00', '2025-04-22 22:00:00', '550e8400-e29b-41d4-a716-446655440001', 850.0, 'Tarde', 'Linea 2', 'Paul Quiroga');

INSERT INTO raw_material_consumption (consumption_id, production_id, raw_material_id, used_bags_quantity, total_kg) VALUES
    ('550e8400-e29b-41d4-a716-446655440008', '550e8400-e29b-41d4-a716-446655440006', '550e8400-e29b-41d4-a716-446655440003', 40, 1000.0),
    ('550e8400-e29b-41d4-a716-446655440009', '550e8400-e29b-41d4-a716-446655440006', '550e8400-e29b-41d4-a716-446655440004', 0, 50.0),
    ('550e8400-e29b-41d4-a716-446655440010', '550e8400-e29b-41d4-a716-446655440007', '550e8400-e29b-41d4-a716-446655440003', 34, 850.0),
    ('550e8400-e29b-41d4-a716-446655440011', '550e8400-e29b-41d4-a716-446655440007', '550e8400-e29b-41d4-a716-446655440004', 0, 85.0);

INSERT INTO downtime (downtime_id, production_id, start_datetime, end_datetime, downtime_type, reason, machine) VALUES
    ('550e8400-e29b-41d4-a716-446655440012', '550e8400-e29b-41d4-a716-446655440006', '2025-04-22 09:30:00', '2025-04-22 10:00:00', 'Mantenimiento', 'Lubricación', 'Mixer A'),
    ('550e8400-e29b-41d4-a716-446655440013', '550e8400-e29b-41d4-a716-446655440007', '2025-04-22 17:45:00', '2025-04-22 18:15:00', 'Falla', 'Sobrecalentamiento de la bobina', 'Conveyor 2');

INSERT INTO waste (waste_id, production_id, quantity_kg, reason) VALUES
    ('550e8400-e29b-41d4-a716-446655440014', '550e8400-e29b-41d4-a716-446655440006', 20.0, 'Empaquetamiento roto'),
    ('550e8400-e29b-41d4-a716-446655440015', '550e8400-e29b-41d4-a716-446655440007', 15.0, 'Exceso de producto');
