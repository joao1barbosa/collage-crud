CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL PRIMARY KEY UNIQUE NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    student_registration INT REFERENCES student(registration)
);