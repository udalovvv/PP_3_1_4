INSERT INTO users (`age`, `email`, `first_name`, `last_name`, `password`)
VALUES ('19', 'admin@mail.com', 'admin', 'admin', '$2a$10$ov6OYlvUk6PFPxdfRvMShesl.OLLfinoS3PTUlWMXB7yG1JeEC3/m');

INSERT INTO users (`age`, `email`, `first_name`, `last_name`, `password`)
VALUES ('19', 'user@mail.com', 'user', 'user', '$2a$10$MAiYOVGvk/vNcLdQGzFx8OR.a8cE5XkWREjSS8WGOxC5/UFvrR6gK');

INSERT INTO roles (`name`)
VALUES ('ROLE_ADMIN');

INSERT INTO roles (`name`)
VALUES ('ROLE_USER');

INSERT INTO users_roles (`user_id`, `role_id`)
VALUES (1, 1);

INSERT INTO users_roles (`user_id`, `role_id`)
VALUES (2, 2);