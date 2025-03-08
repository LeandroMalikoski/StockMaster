CREATE TABLE product (
                         id BIGINT NOT NULL auto_increment PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description VARCHAR(255),
                         price DOUBLE NOT NULL,
                         stock INTEGER NOT NULL,
                         dateCreated DATETIME,
                         category BIGINT NOT NULL,
                         supplier BIGINT NOT NULL,
                         CONSTRAINT FK_category FOREIGN KEY (category) REFERENCES category(id) ON DELETE CASCADE,
                         CONSTRAINT FK_supplier FOREIGN KEY (supplier) REFERENCES supplier(id) ON DELETE CASCADE
);
