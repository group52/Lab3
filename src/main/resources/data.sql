Truncate table GRP5_ENTITY;
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (1, 'admin', null, 1);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (2, 'password', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (3, 'login', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'mark', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'name', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'surname', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'faculty', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'speciality', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'name', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'surname', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'patronymic', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'record_book', null, 9);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'SSU', null, 1);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'SNAU', null, 1);
INSERT INTO GRP5_ENTITY
(id, title, parent_Id, entity_type)
VALUES
  (null, 'SSPU', null, 1);
INSERT INTO GRP5_ENTITY_PARAMETER
(PARAMETER_ID, ENTITY_ID, STRING_VALUE, INT_VALUE, DECIMAL_VALUE, ID_VALUE, DATE_VALUE)
  VALUES
    (3,1,'admin',null,null,null,null);
INSERT INTO GRP5_ENTITY_PARAMETER
(PARAMETER_ID, ENTITY_ID, STRING_VALUE, INT_VALUE, DECIMAL_VALUE, ID_VALUE, DATE_VALUE)
VALUES
  (2,1,'$2a$10$DOZTF1AfHNpOUUeArcsvUeLS9S73Cw1cS0iwTaNQMA7x9IsTi5Xc2',null,null,null,null);



