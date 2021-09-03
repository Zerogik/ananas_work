USE studio;
INSERT INTO salary_type (id, name)
VALUES (1, 'sal20'),
       (2, 'sal30'),
       (3, 'sal40'),
       (4, 'sal45');
INSERT INTO role (id, name)
VALUES (1, 'admin'),
       (2, 'director'),
       (3, 'engineer');
INSERT INTO staff (id, name, username, password, contact, email, role_id, activity, salary_id)
VALUES (1, 'Алексей Искров', 'zerogik', '150278', '8(963)618-40-45', 'iskrovalexey@gmail.com', 1, true, 4);
INSERT INTO clients (name, contacts, email, note)
VALUES ('zeslone', '8(963)618-40-45', 'rogik@inbox.ru', 'злобные упыри'),
       ('Этери Бериашвили', '8(925)002-03-00', 'eteriberi@gmail.com',
        'певица, голос 2, нука все вместе, джаз паркинг, препод хора Ларисы долиной'),
       ('репер коля', '03', 'тупой не имеет почты', 'shvine');
INSERT INTO price (name, cost)
VALUES ('record hour', 1200),
       ('mix vox+minus', 3000),
       ('rec + mix vox & minus', 6000),
       ('mix multitrack', 10000),
       ('aranj', 15000),
       ('aranj +text', 18000),
       ('aaranj for key', 22000);
INSERT INTO staff (id, name, username, password, contact, email, role_id, activity, salary_id)
VALUES (2,'Чистяков Онотоле', 'админсись', 'qwerty', '89520080007', 'alacurdin@gmail.com', 2, 1, 4),
       (3, 'Gonza Bartochkov', 'fooflo', 'ytrewq', '89216676869', 'gonza@mai.ru', 3, 1, 2);
INSERT INTO staff (id, name, username, password, contact, email, role_id, activity, salary_id)
VALUES (4, 'Jirobas Inna', 'fat_fat', '123', '89268768786', 'faat@mail.ru', 3, 1, 1)
INSERT INTO projects (name, completed, client_id)
VALUES ('voron', 0, 2),
       ('pro konya', 1, 2),
       ('гангстер прыщ', 0, 3),
       ('crack', 1, 3),
       ('j-j-j', 0, 1),
       ('r-r-r', 1, 1);
INSERT INTO source (name)
VALUES ('yandex search'),
       ('yandex contexst'),
       ('google search'),
       ('google adw'),
       ('instagramm'),
       ('youtube')
       ;
INSERT INTO source (staff_s_id)
VALUES (1),
       (3),
       (2),
       (4)
;