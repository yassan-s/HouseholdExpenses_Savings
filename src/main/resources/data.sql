INSERT INTO household_expenses(
     id
  , user_id
  , recode_date
  , category_id
  , money
  , income_cost_flg
  , note
  , created_at
  , updated_at
)
VALUES
  (1, 1, '2021-12-01', 1, 10000, 1, '収入1', '2022-01-25 12:00:00', '2022-01-25 12:00:00'),
  (2, 2, '2021-12-02', 1, 20000, 1, '収入2', '2022-01-25 12:00:00', '2022-01-25 12:00:00'),
  (3, 1, '2021-12-03', 2, 30000, 0, 'テスト投稿2', '2022-01-25 12:00:00', '2022-01-25 12:00:00'),
  (4, 2, '2021-12-04', 3, 40000, 0, 'テスト投稿2', '2022-01-25 12:00:00', '2022-01-25 12:00:00');

INSERT INTO categories(
    id
  , category_name
 )
VALUES
  (1, '収入'),
  (2, '生活費'),
  (3, '食費'),
  (4, '貯金');

INSERT INTO users(
    id
  , name
  , password
 )
VALUES
  (1, 'aaa', '$2a$10$m6GDCdDlMc4Bta7OIG/qxOAbO9zVQYsDANCr2imr.nezZH7EU4rPu'),
  (2, 'bbb', '$2a$10$ISTJJn2xMXYib/vuzOkkC.39.07EX3lYZLNu9zn8c9eUTJkpZUSXi');

INSERT INTO wish_lists(
    id
  , user_id
  , wishitem
  , itemmoney
  , itempicture
  , purchased_flg
  , created_at
  , updated_at
)
VALUES
  (1, 1, 'スッキリわかるJava', 3000, 'test1.img', 0, '2022-02-22 12:00:00', '2022-02-23 12:00:00'),
  (2, 2, 'スッキリわかるSql', 2000, 'test2.img', 1, '2022-02-20 12:00:00', '2022-02-21 12:00:00');