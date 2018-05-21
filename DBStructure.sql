CREATE SEQUENCE id_entity;
CREATE SEQUENCE id_entity_parameter;
DROP TABLE entity;
CREATE TABLE entity
( id    NUMBER(10)
    , title     VARCHAR2(4000)
    , parent_Id  NUMBER(10)
    , entity_type NUMBER(3)
    , PRIMARY KEY (`id`)
    , CONSTRAINT     entity_id_uk
UNIQUE (id)
) ;
create or replace trigger entity_tr before insert on entity
 for each row
 declare
     foo number;
 begin
    if :new.id is null then
        select id_entity.nextval into foo from dual;
        :new.id := foo;
    end if;
end;
DROP TABLE entity_parameter;
CREATE TABLE entity_parameter
( parameter_id NUMBER(10)
  , entity_id NUMBER(10)
  , string_value VARCHAR2(4000)
  , int_value NUMBER(10)
  , decimal_value NUMBER(10,5)
  , id_value NUMBER(10)
  , date_value DATE
) ;
