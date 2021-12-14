CREATE TABLE household_expenses
(
   id INT NOT NULL AUTO_INCREMENT,
   user_id int NOT NULL,
   recode_date date NOT NULL,
   category_id int(2) NOT NULL,
   money int NOT NULL,
   income_cost_flg int NOT NULL,
   note varchar(100),
   PRIMARY KEY(id)
);

CREATE TABLE categories
(
   id INT NOT NULL AUTO_INCREMENT,
   category_name varchar(100) NOT NULL,
   PRIMARY KEY(id)
);