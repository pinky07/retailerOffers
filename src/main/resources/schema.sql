SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table customer;
TRUNCATE table CustomerTransaction;

DROP TABLE IF EXISTS CustomerTransaction;
drop table if exists customer;
CREATE TABLE Customer(
   id INT IDENTITY  PRIMARY KEY,
    firstName VARCHAR(128) NOT NULL,
    lastName VARCHAR(128) NOT NULL,
    address VARCHAR(128) NOT NULL,
     points VARCHAR(128) NOT NULL,
 );

CREATE TABLE  CustomerTransaction(
  id INT IDENTITY PRIMARY KEY,
  amount VARCHAR(128) NOT NULL,
  purchaseDate VARCHAR(128) NOT NULL,
  customer_id INT
--  foreign key (customer_id) references customer(customer_id)
);

alter table CustomerTransaction
   add
   foreign key (customer_id)
   references customer (id)

--SET FOREIGN_KEY_CHECKS = 1;