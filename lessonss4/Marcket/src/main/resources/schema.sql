DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER (
  PERSON_ID INT PRIMARY KEY,
  NAME VARCHAR(250)  NOT NULL,
  EMAIL_ADDRESS VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS ORDERS;

CREATE TABLE ORDERS (
  ORDER_ID INT PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  PERSON_ID INT,
  FOREIGN KEY (PERSON_ID) REFERENCES CUSTOMER(PERSON_ID),
  PRICE INT NOT NULL
);