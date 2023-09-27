INSERT INTO role (id, name) VALUES
    (1, 'Admin'),
    (2, 'User');

INSERT INTO "user" (id, role_id, username, password, is_active) VALUES
    (1, 1, 'admin', 'adminpassword', true),
    (2, 2, 'user1', 'user1password', true);


INSERT INTO company (id, user_id, name, registrationcode, is_active) VALUES
    (1, 1, 'Company 1', '1234567890', true),
    (2, 2, 'Company 2', '0987654321', true);

INSERT INTO component (id, name) VALUES
    (1, 'Component 1'),
    (2, 'Component 2');

INSERT INTO component_sorting (id, component_id, bin_name, instructions) VALUES
    (1, 1, 'Bin 1', 'Instructions for Component 1'),
    (2, 2, 'Bin 2', 'Instructions for Component 2');

INSERT INTO material (id, name, description) VALUES
    (1, 'Material 1', 'Description for Material 1'),
    (2, 'Material 2', 'Description for Material 2');

INSERT INTO product (id, company_id, name, upc, is_active) VALUES
    (1, 1, 'Product 1', '123456789012', true),
    (2, 1, 'Product 2', '987654321012', true);

INSERT INTO product_component_material (id, product_id, material_id, component_id) VALUES
    (1, 1, 1, 1),
    (2, 1, 2, 2),
    (3, 2, 1, 2);