CREATE SEQUENCE id_entity;
CREATE SEQUENCE id_entity_parameter;
DROP TABLE entity;
CREATE TABLE entity
( id    NUMBER DEFAULT id_entity.NEXTVAL
    , title     VARCHAR2(4000)
    , parent_Id      NUMBER(10)
    , entity_type NUMBER(3)
    , PRIMARY KEY (`id`)
    , CONSTRAINT     entity_id_uk
UNIQUE (id)
) ;
DROP TABLE entity_parameter;
CREATE TABLE entity_parameter
( parameter_id    NUMBER DEFAULT id_entity_parameter.NEXTVAL
    , entity_id NUMBER(10)
    , string_value VARCHAR2(4000)
    , int_value NUMBER(10)
    , decimal_value NUMBER(10,5)
    , id_value NUMBER(10)
    , PRIMARY KEY (`parameter_id`)
) ;