-- Insert data into 'role' Table
INSERT INTO role (name) VALUES
                            ('Admin'),
                            ('User');

-- Insert data into 'user' Table
INSERT INTO "user" (role_id, name, username, password, is_active) VALUES
                                                                      (1, 'Admin User', 'admin', 'admin_password', true),
                                                                      (2, 'Regular User', 'user', 'user_password', true);

-- Insert data into 'material' Table
INSERT INTO material (name, description) VALUES
                                             ('PET', 'Polyethylene Terephthalate'),
                                             ('HDPE', 'High-Density Polyethylene'),
                                             ('PVC', 'Polyvinyl Chloride'),
                                             ('LDPE', 'Low-Density Polyethylene'),
                                             ('PP', 'Polypropylene'),
                                             ('PS', 'Polystyrene'),
                                             ('PC', 'Other plastic'),
                                             ('T-PAK', 'Komposiitmaterjal');

-- Insert data into 'bin' Table
INSERT INTO bin (id, name, comments) VALUES
                                     (DEFAULT, 'Plast- ja metallpakend, joogikartong', 'Comments for Bin 1'),
                                     (DEFAULT, 'Papp- ja paberpakend', 'Comments for Bin 2'),
                                     (DEFAULT, 'Klaaspakend', 'Comments for Bin 3'),
                                     (DEFAULT, 'Biojäätmed', 'Comments for Bin 4'),
                                     (DEFAULT, 'Olmejäätmed', 'Comments for Bin 5');

-- Insert data into 'sorting' Table
INSERT INTO sorting (instructions, bin_id) VALUES
            ('Tühjenda pakend, voldi lapikuks, sulge kork', 1),
            ('Loputa pakend', 1);

-- Insert data into 'image' Table (binary data, adjust as needed)
INSERT INTO image (data) VALUES
    (E'\\x0123456789ABCDEF');

-- Insert data into 'company' Table
INSERT INTO company (user_id, name, registration_code, is_active) VALUES
            (1, 'Piimamees OÜ', 'ABC123', true),
            (2, 'Jogurtimees AS', 'DEF456', true);

-- Insert data into 'product' Table
INSERT INTO product (company_id, image_id, name, upc, is_active) VALUES
            (1, 1, 'Piim 2.5%', '12345678901234', true),
            (1, NULL, 'Piim 4,5%', '56789012345671', false),
            (1, NULL, 'Maasikajogurt', '56789012345672', false),
            (1, NULL, 'Banaanijogurt šokolaaditükkidega', '56789012345673', false),
            (1, NULL, 'C test', '56789012345674', true);

-- Insert data into 'component' Table
INSERT INTO component (material_id, sorting_id, name) VALUES
            (3, NULL, 'Tetrapak'),
            (2, NULL, 'Kork'),
            (3, NULL, 'Tops');

-- Insert data into 'product_component' Table
INSERT INTO product_component (product_id, component_id) VALUES
            (1, 1),
            (1, 2);