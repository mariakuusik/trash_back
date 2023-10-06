-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-10-05 11:53:23.956

-- tables
-- Table: bin
CREATE TABLE bin (
                     id serial  NOT NULL,
                     name varchar(255)  NOT NULL,
                     comments varchar(50)  NULL,
                     CONSTRAINT bin_pk PRIMARY KEY (id)
);

-- Table: company
CREATE TABLE company (
                         id serial  NOT NULL,
                         user_id int  NULL,
                         name varchar(255)  NOT NULL,
                         registration_code varchar(10)  NOT NULL,
                         is_active boolean  NOT NULL,
                         CONSTRAINT company_pk PRIMARY KEY (id)
);

-- Table: component
CREATE TABLE component (
                           id serial  NOT NULL,
                           material_id int  NOT NULL,
                           sorting_id int  NULL,
                           name varchar(255)  NOT NULL,
                           CONSTRAINT component_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
                       id serial  NOT NULL,
                       data bytea  NOT NULL,
                       CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: material
CREATE TABLE material (
                          id serial  NOT NULL,
                          name varchar(255)  NOT NULL,
                          description varchar(500)  NULL,
                          CONSTRAINT material_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
                         id serial  NOT NULL,
                         company_id int  NOT NULL,
                         image_id int  NULL,
                         sorting_id int  NULL,
                         name varchar(255)  NOT NULL,
                         upc varchar(14)  NOT NULL,
                         is_active boolean  NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table: product_component
CREATE TABLE product_component (
                                   id serial  NOT NULL,
                                   product_id int  NOT NULL,
                                   component_id int  NOT NULL,
                                   CONSTRAINT product_component_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(128)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: sorting
CREATE TABLE sorting (
                         id serial  NOT NULL,
                         instructions varchar(500)  NOT NULL,
                         bin_id int  NOT NULL,
                         CONSTRAINT sorting_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        name varchar(255)  NOT NULL,
                        username varchar(30)  NOT NULL,
                        password varchar(30)  NOT NULL,
                        is_active boolean  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: company_user (table: company)
ALTER TABLE company ADD CONSTRAINT company_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: component_material (table: component)
ALTER TABLE component ADD CONSTRAINT component_material
    FOREIGN KEY (material_id)
        REFERENCES material (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: component_sorting (table: component)
ALTER TABLE component ADD CONSTRAINT component_sorting
    FOREIGN KEY (sorting_id)
        REFERENCES sorting (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_company (table: product)
ALTER TABLE product ADD CONSTRAINT product_company
    FOREIGN KEY (company_id)
        REFERENCES company (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_component_component (table: product_component)
ALTER TABLE product_component ADD CONSTRAINT product_component_component
    FOREIGN KEY (component_id)
        REFERENCES component (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_component_product (table: product_component)
ALTER TABLE product_component ADD CONSTRAINT product_component_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_image (table: product)
ALTER TABLE product ADD CONSTRAINT product_image
    FOREIGN KEY (image_id)
        REFERENCES image (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_sorting (table: product)
ALTER TABLE product ADD CONSTRAINT product_sorting
    FOREIGN KEY (sorting_id)
        REFERENCES sorting (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: sorting_bin (table: sorting)
ALTER TABLE sorting ADD CONSTRAINT sorting_bin
    FOREIGN KEY (bin_id)
        REFERENCES bin (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

