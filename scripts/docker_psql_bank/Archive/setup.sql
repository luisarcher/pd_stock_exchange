

/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     13/11/2019 23:15:11                          */
/*==============================================================*/


drop table account;

drop table administration;

drop table movements;

drop table users;

drop sequence sequence_account;

drop sequence sequence_admin;

drop sequence sequence_movement;

drop sequence sequence_user;

create sequence sequence_account
increment 1
start 1000;

create sequence sequence_admin;

create sequence sequence_movement
increment 1;

create sequence sequence_user
increment 1;

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users (
   id_user              serial not null,
   username             varchar(128)         not null,
   passwd               varchar(128)         not null,
   name                 varchar(255)         not null,
   nif                  varchar(9)           null,
   created_at           date                 null,
   constraint pk_users primary key (id_user)
);

/*==============================================================*/
/* Table: account                                               */
/*==============================================================*/
create table account (
   id_account           serial not null,
   id_user              int4                 null,
   balance              float8               null,
   id_status            int4                 null,
   created_at           date                 null,
   constraint pk_account primary key (id_account),
   constraint fk_account_reference_users foreign key (id_user)
      references users (id_user)
      on delete restrict on update restrict
);

/*==============================================================*/
/* Table: administration                                        */
/*==============================================================*/
create table administration (
   id_admin             int4                 not null,
   username             varchar(255)         null,
   passwd               varchar(255)         null,
   constraint pk_administration primary key (id_admin)
);

/*==============================================================*/
/* Table: movements                                             */
/*==============================================================*/
create table movements (
   id_movement          serial not null,
   id_account           int4                 null,
   description          varchar(255)         null,
   val                  float8               null,
   final_balance        float8               null,
   created_at           date                 null,
   constraint pk_movements primary key (id_movement),
   constraint fk_movement_reference_account foreign key (id_account)
      references account (id_account)
      on delete restrict on update restrict
);

ALTER TABLE users ALTER COLUMN id_user SET DEFAULT nextval('sequence_user');
ALTER TABLE account ALTER COLUMN id_account SET DEFAULT nextval('sequence_account');
ALTER TABLE movements ALTER COLUMN id_movement SET DEFAULT nextval('sequence_movement');
ALTER TABLE administration ALTER COLUMN id_admin SET DEFAULT nextval('sequence_admin');


insert into administration (username, passwd) values ('admin', 'admin');

insert into users (username, passwd, name, nif) 
values ('user', '123', 'user1', '122233454');

insert into account (id_user, balance, id_status) 
values (1, 540.97, 1);

insert into movements (id_account, description, val, final_balance) 
values (1000, 'descricao movimento', 50.00, 450.97);

