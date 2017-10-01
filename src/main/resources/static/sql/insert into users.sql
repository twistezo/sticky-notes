SELECT * FROM stickynotes_db.users;

INSERT INTO `users` (`id`, `first_name`, `last_name`, `password`, `role`, `username`) VALUES
	(1,	'Adam1',	'Last1',	'$2a$10$zYCGrJGBYRJlAoHLNTTJZ.8Gw5pq0gvZFpXHOUz5axZx6.iUjjiNi',	"ROLE_USER",	'user1'),
    (2,	'Adam2',	'Last2',	'$2a$10$zYCGrJGBYRJlAoHLNTTJZ.8Gw5pq0gvZFpXHOUz5axZx6.iUjjiNi',	"ROLE_USER",	'user2'),
    (3,	'Adam3',	'Last3',	'$2a$10$zYCGrJGBYRJlAoHLNTTJZ.8Gw5pq0gvZFpXHOUz5axZx6.iUjjiNi',	"ROLE_USER",	'user3'),
    (4,	'Adam4',	'Last4',	'$2a$10$zYCGrJGBYRJlAoHLNTTJZ.8Gw5pq0gvZFpXHOUz5axZx6.iUjjiNi',	"ROLE_USER",	'user4'),
    (5,	'Adam5',	'Last5',	'$2a$10$zYCGrJGBYRJlAoHLNTTJZ.8Gw5pq0gvZFpXHOUz5axZx6.iUjjiNi',	"ROLE_USER",	'user5'),
    (4,	'admin',	'admin',	'$2a$10$BNrszFdB7dJ6DcstsDgyDumaKHA8XtTTsuczVl5ZmuL/UJX4.VE12',	"ROLE_USER",	'admin');