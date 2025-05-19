CREATE TABLE IF NOT EXISTS user_class (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES "user"(id),
    class_id INT NOT NULL REFERENCES class(id)
);