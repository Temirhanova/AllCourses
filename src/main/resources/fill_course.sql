INSERT INTO "public"."user" ("id", "firstname", "secondname", "email", "role", "password") VALUES (1, 'Вася', 'Пупкин', 'mail@mail.ru', 1, 'pass')

INSERT INTO "public"."teacher" ("id", "user_id", "description", photo) VALUES (1, 1, 'Самый лучший преподаватель', '')

INSERT INTO "public"."course" ("id", "moderation_status", "name", "description", "teacher_id") VALUES (1, DEFAULT, 'Программирование за 1 месяц', 'Хороший курс', 1)

INSERT INTO "public"."course" ("id", "moderation_status", "name", "description", "teacher_id") VALUES (2, DEFAULT, 'Английский язык для новичков', 'Отличный', 1)