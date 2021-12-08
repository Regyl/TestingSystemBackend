INSERT INTO roles VALUES ('Professor');
INSERT INTO roles VALUES ('Administrator');
INSERT INTO roles VALUES ('Student');

INSERT INTO users (username, password) VALUES ('vova', '$2a$10$PXvzXXJBVqSf0u5qPlfiT.9RIGxuBcNtLzVZmDxfEb2o.Y.5KEod2');
INSERT INTO users (username, password) VALUES ('eug', '$2a$10$PXvzXXJBVqSf0u5qPlfiT.9RIGxuBcNtLzVZmDxfEb2o.Y.5KEod2');
INSERT INTO student VALUES ('acbaf82c-6d47-4e3a-b690-c1b424f88d08', 2021, '07-01-2002', 'Владимир', null, 'Долбицын', 'idk', null, 'vova');
INSERT INTO student VALUES (gen_random_uuid(), 2021, '12-08-2002', 'Евгений', null, 'Новиков', 'Алексеевич', null, 'eug');

INSERT INTO subject VALUES ('acbaf82c-6d47-4e3a-b690-c1b424f88d08', 'MathematicsAndMechanics', 'Математика');

INSERT INTO test VALUES ('acbaf82c-6d47-4e3a-b690-c1b424f88d08', '2022-01-17', 'Тест #1', '2021-12-01', 1, 'acbaf82c-6d47-4e3a-b690-c1b424f88d08');

INSERT INTO question VALUES ('acbaf82c-6d47-4e3a-b690-c1b424f88d08', 'Думай, человек', 'Сколько будет 2+2*(2+3)?', 'acbaf82c-6d47-4e3a-b690-c1b424f88d08');

INSERT INTO answer VALUES (gen_random_uuid(), false, '20', 'acbaf82c-6d47-4e3a-b690-c1b424f88d08');
INSERT INTO answer VALUES (gen_random_uuid(), true, '12', 'acbaf82c-6d47-4e3a-b690-c1b424f88d08');

INSERT INTO student_result VALUES (gen_random_uuid(), 1, 'acbaf82c-6d47-4e3a-b690-c1b424f88d08', 'acbaf82c-6d47-4e3a-b690-c1b424f88d08')