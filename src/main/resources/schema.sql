declare
cnt number:=0;
query VARCHAR2(4000);
begin
select count(1) into cnt from user_sequences where sequence_name='ID_ENTITY';
if cnt=0 then
execute immediate 'CREATE SEQUENCE id_entity';
end if;

select count(1) into cnt from user_tables where table_name='GRP5_ENTITY';
  if cnt=0 then
    begin
      query:='CREATE TABLE GRP5_entity' ||
      '( id    NUMBER(10)' ||
      ', title     VARCHAR2(4000)' ||
      ', parent_Id  NUMBER(10)' ||
      ', entity_type NUMBER(3)' ||
      ', CONSTRAINT  grp5_entity_id_uk  PRIMARY KEY (id))' ;
      execute immediate query;
    end;
  end if;

  select count(1) into cnt from user_tables where table_name='GRP5_ENTITY_PARAMETER';
  if cnt=0 then
    begin
      query:='CREATE TABLE GRP5_entity_parameter' ||
             '( parameter_id NUMBER(10)' ||
             ', entity_id NUMBER(10)' ||
             ', string_value VARCHAR2(4000)' ||
             ', int_value NUMBER(10)' ||
             ', decimal_value NUMBER(10,5)' ||
             ', id_value NUMBER(10)' ||
             ', date_value DATE)' ;
      execute immediate query;
    end;
  end if;

  select count(1) into cnt from user_tables where table_name='GRP5_USERS';
  if cnt=0 then
    begin
      query:='CREATE TABLE GRP5_USERS' ||
             '( USERNAME VARCHAR2(36) not null,' ||
             ' PASSWORD VARCHAR2(36) not null,' ||
             ' ROLE_ID   VARCHAR2(50) not null,' ||
             ' FIRSTNAME VARCHAR(50) not null,' ||
             ' LASTNAME VARCHAR(50) not null )' ;
      execute immediate query;
    end;
  end if;

  select count(1) into cnt from user_triggers where trigger_name='GRP5_ENTITY_TR';
  if cnt=0 then
    begin
      query:='create or replace trigger GRP5_ENTITY_TR before insert on GRP5_ENTITY' ||
             ' for each row' ||
             ' declare' ||
             ' foo number;' ||
             ' begin' ||
             ' if :new.id is null then' ||
             ' select id_entity.nextval into foo from dual;' ||
             ' :new.id := foo;' ||
             ' end if;' ||
             ' end;' ;
      execute immediate query;
    end;
  end if;


end;
^;