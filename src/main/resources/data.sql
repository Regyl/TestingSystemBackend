INSERT INTO roles VALUES ('Professor');
INSERT INTO roles VALUES ('Administrator');
INSERT INTO roles VALUES ('Student');

-- Inserting default admin
INSERT INTO users (username, password) VALUES ('admin', '$2a$10$1wc171TcLoMz1JzMJpK6s.Bf0qT7FHY4V8CKlAW7kVcDiRIS8KkgS');
INSERT INTO users_authorities VALUES ('admin', 'Administrator');

-- Inserting default professor
INSERT INTO users (username, password) VALUES ('professor', '$2a$10$Ogk9pTtBLnty8lqAmdZU4uTsysFiJqvgug5Sm9CEpFt5IwllMy8EC');
INSERT INTO users_authorities VALUES ('professor', 'Professor');

-- Inserting default student

-- Inserting students
INSERT INTO users (username, password) VALUES ('vova', '$2a$10$i8QLwf9igC54Muwox50WUOPG9sa/7zn551mfMM1izgOD6zKNgeP0.');
INSERT INTO users_authorities VALUES ('vova', 'Student');
INSERT INTO student VALUES ('acbaf82c-6d47-4e3a-b690-c1b424f88d08', 2021, '07-01-2002', 'Владимир', null, 'Долбицын', 'idk', null, 'vova');

INSERT INTO users (username, password) VALUES ('eug', '$2a$10$eWZ/Uw6JFoYb40w3ufkKhOfJQ9mrMtFQu5/rzPmU8UNN4CzwY4/AS');
INSERT INTO users_authorities VALUES ('eug', 'Student');
INSERT INTO student VALUES (gen_random_uuid(), 2021, '12-08-2002', 'Евгений', null, 'Новиков', 'Алексеевич', null, 'eug');

INSERT INTO subject VALUES ('acbaf82c-6d47-4e3a-b690-c1b424f88d08', 'MathematicsAndMechanics', 'Математика');

INSERT INTO test VALUES ('acbaf82c-6d47-4e3a-b690-c1b424f88d08', '2022-01-17', 'Тест #1', '2021-12-01', 1, 'acbaf82c-6d47-4e3a-b690-c1b424f88d08');

INSERT INTO question VALUES ('acbaf82c-6d47-4e3a-b690-c1b424f88d08', 'Думай, человек', 'Сколько будет 2+2*(2+3)?', 'acbaf82c-6d47-4e3a-b690-c1b424f88d08');

INSERT INTO answer VALUES (gen_random_uuid(), false, '20', 'acbaf82c-6d47-4e3a-b690-c1b424f88d08');
INSERT INTO answer VALUES (gen_random_uuid(), true, '12', 'acbaf82c-6d47-4e3a-b690-c1b424f88d08');

INSERT INTO student_result VALUES (gen_random_uuid(), 1, 'acbaf82c-6d47-4e3a-b690-c1b424f88d08', 'acbaf82c-6d47-4e3a-b690-c1b424f88d08')