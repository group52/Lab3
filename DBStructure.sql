DROP TABLE entity;
CREATE TABLE entity
    ( id    NUMBER(10)
    , title     VARCHAR2(4000)
    , parent_Id      NUMBER(10)          
    , entity_type NUMBER(3)     
    , CONSTRAINT     entity_id_uk
                     UNIQUE (id)
    ) ;
DROP TABLE entity_parameter;
CREATE TABLE entity_parameter
    ( entity_id    NUMBER(10)
    , parameter_id NUMBER(10)
    , string_value VARCHAR2(4000)
    , int_value NUMBER(10)
    , decimal_value NUMBER(10,5)
    , id_value NUMBER(10)
    ) ;    