create database dbtarefa;
use dbtarefa;

create table tarefas(
	id integer not null auto_increment,
    titulo text not null,
    descricao text not null,
    dataCriacao datetime default current_timestamp,
    primary key(id)
);

select * from tarefas;