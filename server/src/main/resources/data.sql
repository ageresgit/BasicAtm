DROP TABLE IF EXISTS PaymentCards;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Currency;

CREATE TABLE Currency (
    id INT PRIMARY KEY,
    iso varchar(3) NOT NULL
);

CREATE TABLE Accounts (
  id INT PRIMARY KEY,
  currency INT NOT NULL,
  balance DECIMAL NOT NULL,
    foreign key (currency) references Currency(id)
);

CREATE TABLE PaymentCards (
  pan varchar(16) PRIMARY KEY,
  pin varchar(4) NOT NULL,
  account INT NOT NULL,
    foreign key (account) references Accounts(id)
);

INSERT INTO Currency (id, iso) VALUES
  (1, 'RUB'),
  (2, 'USD'),
  (3, 'EUR');

INSERT INTO Accounts (id, currency, balance) VALUES
  (1001, 1, 1000),
  (1002, 2, 20000),
  (1003, 3, 0);

INSERT INTO PaymentCards (pan, pin, account) VALUES
  ('0234023402340234', '0234', 1001),
  ('2340234023402340', '2340', 1002),
  ('3456345634563456', '3456', 1003);
