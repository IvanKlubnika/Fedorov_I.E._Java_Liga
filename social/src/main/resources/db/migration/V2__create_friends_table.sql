CREATE TABLE IF NOT EXISTS friends
(
    id_friend SERIAL NOT NULL,

    id_user SERIAL,
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);
COMMENT ON TABLE friends IS 'Друзья';
COMMENT ON COLUMN friends.id_user is 'Id пользователя';
COMMENT ON COLUMN friends.id_friend is 'Id друга';
