SELECT * FROM sticky_notes_db.notes;

INSERT INTO `notes` (`id`, `body`, `date`, `is_done`, `title`, `author_id`) VALUES
(1,	'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vulputate convallis nisl, quis venenatis dui pretium vitae. Donec sit amet hendrerit nulla. Fusce dui odio, tincidunt a imperdiet vel, suscipit eu sem. In et lectus maximus, condimentum risus quis, tempus sem. Nullam commodo mauris ut molestie maximus.',	'2017-02-10 00:00:00',	1,	'Title 1', 1),
(2,	'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vulputate convallis nisl, quis venenatis dui pretium vitae. Donec sit amet hendrerit nulla. Fusce dui odio, tincidunt a imperdiet vel, suscipit eu sem. In et lectus maximus, condimentum risus quis, tempus sem. Nullam commodo mauris ut molestie maximus.',	'2017-01-09 00:00:00',	0,	'Title 2', 2),
(3,	'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vulputate convallis nisl, quis venenatis dui pretium vitae. Donec sit amet hendrerit nulla. Fusce dui odio, tincidunt a imperdiet vel, suscipit eu sem. In et lectus maximus, condimentum risus quis, tempus sem. Nullam commodo mauris ut molestie maximus.',	'2016-12-08 00:00:00',	0,	'Title 3', 2),
(4,	'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vulputate convallis nisl, quis venenatis dui pretium vitae. Donec sit amet hendrerit nulla. Fusce dui odio, tincidunt a imperdiet vel, suscipit eu sem. In et lectus maximus, condimentum risus quis, tempus sem. Nullam commodo mauris ut molestie maximus.',	'2017-06-07 00:00:00',	1,	'Title 4', 3),
(5,	'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vulputate convallis nisl, quis venenatis dui pretium vitae. Donec sit amet hendrerit nulla. Fusce dui odio, tincidunt a imperdiet vel, suscipit eu sem. In et lectus maximus, condimentum risus quis, tempus sem. Nullam commodo mauris ut molestie maximus.',	'2015-02-06 00:00:00',	1,	'Title 5', 4);