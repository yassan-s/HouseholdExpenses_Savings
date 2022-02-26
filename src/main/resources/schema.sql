CREATE TABLE IF NOT EXISTS household_expenses
(
   id INT NOT NULL AUTO_INCREMENT,
   user_id int NOT NULL,
   recode_date date NOT NULL,
   category_id int(2) NOT NULL,
   money int NOT NULL,
   income_cost_flg int NOT NULL,
   note varchar(100),
   created_at datetime NOT NULL,
   updated_at datetime,
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS categories
(
   id INT NOT NULL AUTO_INCREMENT,
   category_name varchar(100) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS users
(
   id int(11) NOT NULL AUTO_INCREMENT,
   name varchar(50) NOT NULL,
   password varchar(200) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS wish_lists
(
   id int NOT NULL AUTO_INCREMENT,
   user_id int NOT NULL,
   wishitem varchar(50) NOT NULL,
   itemmoney int NOT NULL,
   itempicture varchar(100),
   purchased_flg int NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime,
   PRIMARY KEY(id)
);
