INSERT INTO columns (id, name) VALUES
                                               (1, 'One'),
                                               (2, 'Two'),
                                               (3, 'Tree'),
                                               (4, 'Four'),
                                               (5, 'Five');

INSERT INTO tasks (id, column_id, name, description, date_of_creation)  VALUES
                                                             (1, 1, 'name1', 'description1', now()),
                                                             (2, 1, 'name2', 'description2', now())
