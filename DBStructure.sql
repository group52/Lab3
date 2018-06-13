CREATE SEQUENCE id_entity;
CREATE SEQUENCE id_entity_parameter;
DROP TABLE GRP5_entity;
CREATE TABLE GRP5_entity
( id    NUMBER(10)
  , title     VARCHAR2(4000)
  , parent_Id  NUMBER(10)
  , entity_type NUMBER(3)
  , CONSTRAINT  entity_id_uk  PRIMARY KEY (id)
) ;

create or replace trigger entity_tr before insert on GRP5_entity
  for each row
  declare
    foo number;
  begin
    if :new.id is null then
      select id_entity.nextval into foo from dual;
      :new.id := foo;
    end if;
  end;
DROP TABLE GRP5_entity_parameter;
CREATE TABLE GRP5_entity_parameter
( parameter_id NUMBER(10)
  , entity_id NUMBER(10)
  , string_value VARCHAR2(4000)
  , int_value NUMBER(10)
  , decimal_value NUMBER(10,5)
  , id_value NUMBER(10)
  , date_value DATE
) ;
DROP TABLE GRP5_USERS;
create table GRP5_USERS
(
  USERNAME VARCHAR2(36) not null,
  PASSWORD VARCHAR2(36) not null,
  ROLE_ID   VARCHAR2(50) not null,
  FIRSTNAME VARCHAR(50) not null,
  LASTNAME VARCHAR(50) not null

) ;