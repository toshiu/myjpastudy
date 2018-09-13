set current_schema=TEST;
create table STUDENT
(
   STUDENT_ID integer NOT NULL PRIMARY KEY,
   NAME varchar(50),
   SEX char(1),
   AGE smallint,
   BIRTHDAY date,
   ADDRESS varchar(100),
   telephone varchar(20)
)
;
create table FAMILY
(
   MAN varchar(50) NOT NULL,
   WOMAN varchar(50) NOT NULL,
   ADDRESS varchar(100),
   CONSTRAINT PK_FAMILY PRIMARY KEY (MAN,WOMAN)
)
;
create table PROVINCE
(
   PROVINCE_ID integer NOT NULL PRIMARY KEY,
   PROVINCE_NAME varchar(50),
   PROVINCE_MAN varchar(50)
)
;
create table CITY
(
   CITY_ID integer NOT NULL PRIMARY KEY,
   CITY_NAME varchar(50),
   CITY_MAN varchar(50),
   PROVINCE_ID integer NOT NULL
)
;
alter table CITY add CONSTRAINT FK_PROVINCE FOREIGN KEY (PROVINCE_ID) REFERENCES PROVINCE(PROVINCE_ID);