INSERT INTO household_expenses(
     id
  , user_id
  , recode_date
  , category_id
  , money
  , income_cost_flg
  , note
)
VALUES
  (1, 1, '2021-12-01', 1, 10000, 1, '収入1'),
  (2, 1, '2021-12-02', 1, 20000, 1, '収入2'),
  (3, 1, '2021-12-03', 2, 30000, 0, 'テスト投稿2'),
  (4, 1, '2021-12-04', 3, 40000, 0, 'テスト投稿2');

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
  (1, 'aaa', 'aaa'),
  (2, 'bbb', 'bbb');
