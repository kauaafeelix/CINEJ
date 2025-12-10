create database CineJ;
use CineJ;


create table Filme (
id BIGINT primary key auto_increment not null,
titulo varchar (200) not null,
genero varchar (200) not null,
duracao_minutos int not null,
lancamento boolean not null DEFAULT FALSE
);


create table Cliente (
id BIGINT primary key auto_increment not null,
nome varchar (200) not null,
email varchar (200) UNIQUE not null,
saldo_carteira decimal (10,2)
);

create table Sessao (
id BIGINT primary key auto_increment not null, 
filme_id BIGINT not null,
sala varchar(100) not null,
capacidade_maxima int,
data_hora timestamp not null DEFAULT NOW(),
valor_ingresso decimal (10,2),

FOREIGN KEY (filme_id) references Filme (id)
);

create table Ingresso (
id BIGINT primary key auto_increment not null,
cliente_id BIGINT not null,
sessao_id BIGINT not null,
data_compra date not null,
tipo_ingresso enum ("INTEIRA", "MEIA"),
status enum ("ATIVO", "CANCELADO"),

FOREIGN KEY (cliente_id) references Cliente (id),
FOREIGN KEY (sessao_id) references Sessao (id)

);


 
   
  
