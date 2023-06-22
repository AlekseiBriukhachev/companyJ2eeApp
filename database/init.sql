CREATE TABLE Company (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         company_name VARCHAR(255) NOT NULL,
                         legal_form VARCHAR(255),
                         address_id INT,
                         FOREIGN KEY (address_id) REFERENCES Address(id)
);

CREATE TABLE Address (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         postal_code VARCHAR(10),
                         city VARCHAR(255) NOT NULL,
                         street VARCHAR(255) NOT NULL,
                         house VARCHAR(10) NOT NULL,
                         apartment VARCHAR(10)
);

CREATE TABLE Branch (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        branch_name VARCHAR(255) NOT NULL,
                        address_id INT,
                        company_id INT,
                        FOREIGN KEY (address_id) REFERENCES Address(id),
                        FOREIGN KEY (company_id) REFERENCES Company(id)
);

