CREATE TABLE IF NOT EXISTS users(
    id_user SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_Name VARCHAR(100) NOT NULL,
    sex VARCHAR(1),
    age INTEGER,
    city VARCHAR(50),
    interests VARCHAR(500)
);

COMMENT ON TABLE users IS 'Пользователи';
COMMENT ON COLUMN users.id_user is 'id пользователя';
COMMENT ON COLUMN users.first_name is 'Имя пользователя';
COMMENT ON COLUMN users.last_Name is 'Фамилия пользователя';
COMMENT ON COLUMN users.sex is 'Пол пользователя';
COMMENT ON COLUMN users.age is 'Возраст пользователя';
COMMENT ON COLUMN users.city is 'Город пользователя';
COMMENT ON COLUMN users.interests is 'Интересы пользователя';



