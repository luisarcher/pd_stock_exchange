/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     17/11/2019 18:05:35                          */
/*==============================================================*/


drop table ADMINISTRATION;

drop table COMPANY;

drop table MESSAGES;

drop table ORDERS;

drop table PARCEL;

drop table PORTFOLIO;

drop table USERS;

drop sequence SEQUENCE_ADMIN;

drop sequence SEQUENCE_ADMINISTRATION;

drop sequence SEQUENCE_COMPANY;

drop sequence SEQUENCE_MESSAGES;

drop sequence SEQUENCE_ORDERS;

drop sequence SEQUENCE_PARCEL;

drop sequence SEQUENCE_PORTOFOLIO;

drop sequence SEQUENCE_USERS;

create sequence SEQUENCE_ADMIN;

create sequence SEQUENCE_ADMINISTRATION
increment 1;

create sequence SEQUENCE_COMPANY
increment 1;

create sequence SEQUENCE_MESSAGES
increment 1;

create sequence SEQUENCE_ORDERS
increment 1;

create sequence SEQUENCE_PARCEL
increment 1;

create sequence SEQUENCE_PORTOFOLIO
increment 1;

create sequence SEQUENCE_USERS
increment 1;

/*==============================================================*/
/* Table: ADMINISTRATION                                        */
/*==============================================================*/
create table ADMINISTRATION (
   ID_ADMIN             SERIAL not null,
   USERNAME             VARCHAR(255)         null,
   PASSWD               VARCHAR(255)         null,
   constraint PK_ADMINISTRATION primary key (ID_ADMIN)
);

/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/
create table COMPANY (
   ID_COMPANY           SERIAL not null,
   DESCRIPTION          VARCHAR(200)         null,
   AREA                 VARCHAR(200)         null,
   SHARE_QUANT          INT4                 null,
   SHARE_PRICE          FLOAT8               null,
   constraint PK_COMPANY primary key (ID_COMPANY)
);

/*==============================================================*/
/* Table: MESSAGES                                              */
/*==============================================================*/
create table MESSAGES (
   ID_MESSAGE           SERIAL not null,
   ID_TO                INT4                 null,
   ID_FROM              INT4                 null,
   MSG_TEXT             VARCHAR(1024)        null,
   CREATED_AT           DATE                 null,
   ISVIEWED             BOOL                 null,
   constraint PK_MESSAGES primary key (ID_MESSAGE)
);

/*==============================================================*/
/* Table: ORDERS                                                */
/*==============================================================*/
create table ORDERS (
   ID_ORDER             INT4                 not null,
   ID_USER              INT4                 null,
   constraint PK_ORDERS primary key (ID_ORDER)
);

/*==============================================================*/
/* Table: PARCEL                                                */
/*==============================================================*/
create table PARCEL (
   ID_PARCEL            INT4                 not null,
   ID_ORDER             INT4                 null,
   ID_COMPANY           INT4                 null,
   SHARE_QUANT          INT4                 null,
   PRICE                FLOAT8               null,
   constraint PK_PARCEL primary key (ID_PARCEL)
);

/*==============================================================*/
/* Table: PORTFOLIO                                             */
/*==============================================================*/
create table PORTFOLIO (
   ID_PORTFOLIO         SERIAL not null,
   ID_USER              INT4                 null,
   ID_COMPANY           INT4                 null,
   SHARE_QUANT          INT4                 null,
   constraint PK_PORTFOLIO primary key (ID_PORTFOLIO)
);

/*==============================================================*/
/* Table: USERS                                                 */
/*==============================================================*/
create table USERS (
   ID_USER              SERIAL not null,
   USERNAME             VARCHAR(200)         null,
   PASSWD               VARCHAR(200)         null,
   constraint PK_USERS primary key (ID_USER)
);

alter table MESSAGES
   add constraint FK_MESSAGES_REFERENCE_USERS foreign key (ID_TO)
      references USERS (ID_USER)
      on delete restrict on update restrict;

alter table MESSAGES
   add constraint FK_MESSAGES_REFERENCE_USERS2 foreign key (ID_FROM)
      references USERS (ID_USER)
      on delete restrict on update restrict;

alter table ORDERS
   add constraint FK_ORDERS_REFERENCE_USERS foreign key (ID_USER)
      references USERS (ID_USER)
      on delete restrict on update restrict;

alter table PARCEL
   add constraint FK_PARCEL_REFERENCE_COMPANY foreign key (ID_COMPANY)
      references COMPANY (ID_COMPANY)
      on delete restrict on update restrict;

alter table PARCEL
   add constraint FK_PARCEL_REFERENCE_ORDERS foreign key (ID_ORDER)
      references ORDERS (ID_ORDER)
      on delete restrict on update restrict;

alter table PORTFOLIO
   add constraint FK_PORTFOLI_REFERENCE_USERS foreign key (ID_USER)
      references USERS (ID_USER)
      on delete restrict on update restrict;

alter table PORTFOLIO
   add constraint FK_PORTFOLI_REFERENCE_COMPANY foreign key (ID_COMPANY)
      references COMPANY (ID_COMPANY)
      on delete restrict on update restrict;