insert into administration (username, passwd) values ('admin', 'admin');

insert into users (username, passwd, name, nif) 
values ('user', '123', 'user1', '122233454');

insert into account (id_user, balance, id_status) 
values (1, 540.97, 1);

insert into movements (id_account, description, val, final_balance) 
values (1000, 'descricao movimento', 50.00, 450.97);