/*CREATE TABLE IF NOT EXISTS profiles ( id BIGINT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255) );
INSERT INTO profiles (id, name, email)
VALUES (1, 'John Doe', 'john.doe@example.com'),
       (2, 'Jane Smith', 'jane.smith@example.com'),
       (3, 'Bob Johnson', 'bob.johnson@example.com') ON CONFLICT DO NOTHING;*/