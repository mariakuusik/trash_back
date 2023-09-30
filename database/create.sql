-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-27 10:12:47.405

-- tables
-- Table: company
CREATE TABLE company (
                         id serial  NOT NULL,
                         user_id int  NULL,
                         name varchar(255)  NOT NULL,
                         registrationcode varchar(10)  NOT NULL,
                         is_active boolean  NOT NULL DEFAULT true,
                         CONSTRAINT company_pk PRIMARY KEY (id)
);

-- Table: component
CREATE TABLE component (
                           id serial  NOT NULL,
                           name varchar(255)  NOT NULL,
                           CONSTRAINT component_pk PRIMARY KEY (id)
);

-- Table: component_sorting
CREATE TABLE component_sorting (
                                   id serial  NOT NULL,
                                   component_id int  NOT NULL,
                                   bin_name varchar(255)  NOT NULL,
                                   instructions varchar(500)  NOT NULL,
                                   CONSTRAINT component_sorting_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
                       id serial  NOT NULL,
                       product_id int  NULL,
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
                         name varchar(255)  NOT NULL,
                         upc varchar(14)  NOT NULL,
                         is_active boolean  NOT NULL DEFAULT true,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);

CREATE INDEX product_upc_index on product (upc ASC);

-- Table: product_component_material
CREATE TABLE product_component_material (
                                            id serial  NOT NULL,
                                            product_id int  NOT NULL,
                                            material_id int  NOT NULL,
                                            component_id int  NOT NULL,
                                            CONSTRAINT product_component_material_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(128)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        username varchar(30)  NOT NULL,
                        password varchar(30)  NOT NULL,
                        is_active boolean  NOT NULL DEFAULT true,
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

-- Reference: image_product (table: image)
ALTER TABLE image ADD CONSTRAINT image_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
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

-- Reference: product_material_component (table: product_component_material)
ALTER TABLE product_component_material ADD CONSTRAINT product_material_component
    FOREIGN KEY (component_id)
        REFERENCES component (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_material_material (table: product_component_material)
ALTER TABLE product_component_material ADD CONSTRAINT product_material_material
    FOREIGN KEY (material_id)
        REFERENCES material (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_material_product (table: product_component_material)
ALTER TABLE product_component_material ADD CONSTRAINT product_material_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: sorting_instructions_component (table: component_sorting)
ALTER TABLE component_sorting ADD CONSTRAINT sorting_instructions_component
    FOREIGN KEY (component_id)
        REFERENCES component (id)
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

