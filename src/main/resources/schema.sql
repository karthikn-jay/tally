DROP TABLE IF EXISTS TALLY_TRANSACTIONS;

CREATE TABLE TALLY_TRANSACTIONS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  item_size VARCHAR(50) DEFAULT NULL,
  item_qty INT(19),
  item_val INT(19)
);