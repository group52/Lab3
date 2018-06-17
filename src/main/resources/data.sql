Truncate table entity;
INSERT INTO entity
(id, title, parent_Id, entity_type)
VALUES
(1, 'SSU', null, 1);
INSERT INTO entity
(id, title, parent_Id, entity_type)
VALUES
(2, 'SNAU', null, 1);
INSERT INTO entity
(id, title, parent_Id, entity_type)
VALUES
(3, 'SSPU', null, 1);
Truncate table entity_parameter;
INSERT INTO entity_parameter
(entity_id, parameter_id, string_value, int_value, decimal_value, id_value)
VALUES
(1, 1, 'Sumy', null, null, null);
