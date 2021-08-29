USE orders;
INSERT INTO salary_type (id, sl_name)
VALUES (1, 'sal20'),
       (2, 'sal30'),
       (3, 'sal40'),
       (4, 'sal45');
INSERT INTO role (id, rl_name)
VALUES (1, 'admin'),
       (2, 'director'),
       (3, 'engineer');
INSERT INTO staff (id, st_name, username, password, contact, email, role_id, activity, salary_id)
VALUES (1, 'Алексей Искров', 'zerogik', '150278', '8(963)618-40-45', 'iskrovalexey@gmail.com', 1, true, 4);