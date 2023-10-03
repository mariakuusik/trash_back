-- Insert data into 'role' Table
INSERT INTO role (name) VALUES
        ('Admin'),
        ('User');

-- Insert data into 'user' Table
INSERT INTO "user" (role_id, username, password, is_active) VALUES
        (1, 'admin', 'admin_password', true),
        (2, 'user', 'user_password', true);

-- Insert data into 'material' Table
INSERT INTO material (name, description) VALUES
        ('PET-1', 'Mingi plastik'),
        ('PET-2', 'Mingi muu plastik'),
        ('T-PAK', 'Komposiitmaterjal');


-- Insert data into 'sorting' Table
INSERT INTO sorting (instructions) VALUES
        ('Sorting instructions for Bin 1'),
        ('Sorting instructions for Bin 2');

-- Insert data into 'bin' Table
INSERT INTO bin (material_id, sorting_id, name, comments) VALUES
        (1, 1, 'Bin 1', 'Comments for Bin 1'),
        (2, 2, 'Bin 2', 'Comments for Bin 2');

-- Insert data into 'image' Table (binary data, adjust as needed)
INSERT INTO image (data) VALUES
        (E'\\x0123456789ABCDEF');

-- Insert data into 'company' Table
INSERT INTO company (user_id, name, registrationcode, is_active) VALUES
        (1, 'Piimamees OÜ', 'ABC123', true),
        (2, 'Jogurtimees AS', 'DEF456', true);

-- Insert data into 'product' Table
INSERT INTO product (company_id, image_id, name, upc, is_active) VALUES
        (1, 1, 'Piim 2.5%', '12345678901234', true),
        (1, NULL, 'Piim 4,5%', '56789012345671', false),
        (1, NULL, 'A test', '56789012345672', false),
        (1, NULL, 'B test', '56789012345673', false),
        (1, NULL, 'C test', '56789012345674', true);

-- Insert data into 'component' Table
INSERT INTO component (name, product_id) VALUES
        ('Tetrapak', 1),
        ('Component 2', 1),
        ('Tetrapak', 2);

-- Insert data into 'component_material' Table
INSERT INTO component_material (material_id, component_id) VALUES
        (3, 1),
        (3, 2);