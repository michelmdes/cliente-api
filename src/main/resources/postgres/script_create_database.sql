-- Scripts de criação do banco de dados da API de Cliente
create database CLIENTE;


CREATE TABLE cliente (
	id serial NOT NULL,
	nome varchar(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	rg varchar(10),
	cpf varchar(11),
	email varchar(255) NOT NULL,
	telefone varchar(15),
	id_genero bigint NOT NULL,
	CONSTRAINT cliente_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE endereco (
	id serial NOT NULL,
	logradouro varchar(255) NOT NULL,
	numero varchar(10) NOT NULL,
	complemento varchar(255) NOT NULL,
	bairro varchar(255) NOT NULL,
	cep varchar(8) NOT NULL,
	descricao varchar(255),
	id_cliente bigint NOT NULL,
	id_cidade bigint NOT NULL,
	CONSTRAINT endereco_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE cidade (
	id serial NOT NULL,
	nome varchar(255) NOT NULL,
	id_estado bigint NOT NULL,
	CONSTRAINT cidade_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE estado (
	id serial NOT NULL,
	nome varchar(255) NOT NULL,
	sigla varchar(2) NOT NULL,
	CONSTRAINT estado_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE genero (
	id serial NOT NULL,
	nome varchar(50) NOT NULL,
	CONSTRAINT genero_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);



ALTER TABLE cliente ADD CONSTRAINT cliente_fk0 FOREIGN KEY (id_genero) REFERENCES genero(id);

ALTER TABLE endereco ADD CONSTRAINT endereco_fk0 FOREIGN KEY (id_cliente) REFERENCES cliente(id);
ALTER TABLE endereco ADD CONSTRAINT endereco_fk1 FOREIGN KEY (id_cidade) REFERENCES cidade(id);

ALTER TABLE cidade ADD CONSTRAINT cidade_fk0 FOREIGN KEY (id_estado) REFERENCES estado(id);



-- Carga de dados das tabelas

insert into estado (nome, sigla) values ('Acre', 'AC');
insert into estado (nome, sigla) values ('Alagoas', 'AL');
insert into estado (nome, sigla) values ('Amapá', 'AP');
insert into estado (nome, sigla) values ('Amazonas', 'AM');
insert into estado (nome, sigla) values ('Bahia', 'BA');
insert into estado (nome, sigla) values ('Ceará', 'CE');
insert into estado (nome, sigla) values ('Distrito Federal', 'DF');
insert into estado (nome, sigla) values ('Espírito Santo', 'ES');
insert into estado (nome, sigla) values ('Goiás', 'GO');
insert into estado (nome, sigla) values ('Maranhão', 'MA');
insert into estado (nome, sigla) values ('Mato Grosso', 'MT');
insert into estado (nome, sigla) values ('Mato Grosso do Sul', 'MS');
insert into estado (nome, sigla) values ('Minas Gerais', 'MG');
insert into estado (nome, sigla) values ('Pará', 'PA');
insert into estado (nome, sigla) values ('Paraíba', 'PB');
insert into estado (nome, sigla) values ('Paraná', 'PR');
insert into estado (nome, sigla) values ('Pernambuco', 'PE');
insert into estado (nome, sigla) values ('Piauí', 'PI');
insert into estado (nome, sigla) values ('Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values ('Rio Grande do Norte', 'RN');
insert into estado (nome, sigla) values ('Rio Grande do Sul', 'RS');
insert into estado (nome, sigla) values ('Rondônia', 'RO');
insert into estado (nome, sigla) values ('Roraima', 'RR');
insert into estado (nome, sigla) values ('Santa Catarina', 'SC');
insert into estado (nome, sigla) values ('São Paulo', 'SP');
insert into estado (nome, sigla) values ('Sergipe', 'SE');
insert into estado (nome, sigla) values ('Tocantins', 'TO');


insert into cidade (nome, id_estado) values ('Rio Branco', 1);
insert into cidade (nome, id_estado) values ('Maceió', 2);
insert into cidade (nome, id_estado) values ('Macapá', 3);
insert into cidade (nome, id_estado) values ('Manaus', 4);
insert into cidade (nome, id_estado) values ('Salvador', 5);
insert into cidade (nome, id_estado) values ('Fortaleza', 6);
insert into cidade (nome, id_estado) values ('Brasília', 7);
insert into cidade (nome, id_estado) values ('Vitória', 8);
insert into cidade (nome, id_estado) values ('Goiânia', 9);
insert into cidade (nome, id_estado) values ('São Luís', 10);
insert into cidade (nome, id_estado) values ('Cuiabá', 11);
insert into cidade (nome, id_estado) values ('Campo Grande', 12);
insert into cidade (nome, id_estado) values ('Belo Horizonte', 13);
insert into cidade (nome, id_estado) values ('Belém', 14);
insert into cidade (nome, id_estado) values ('João Pessoa', 15);
insert into cidade (nome, id_estado) values ('Curitiba', 16);
insert into cidade (nome, id_estado) values ('Recife', 17);
insert into cidade (nome, id_estado) values ('Teresina', 18);
insert into cidade (nome, id_estado) values ('Rio de Janeiro', 19);
insert into cidade (nome, id_estado) values ('Natal', 20);
insert into cidade (nome, id_estado) values ('Porto Alegre', 21);
insert into cidade (nome, id_estado) values ('Porto Velho', 22);
insert into cidade (nome, id_estado) values ('Boa Vista', 23);
insert into cidade (nome, id_estado) values ('Florianópolis', 24);
insert into cidade (nome, id_estado) values ('São Paulo', 25);
insert into cidade (nome, id_estado) values ('Aracaju', 26);
insert into cidade (nome, id_estado) values ('Palmas', 27);


insert into genero (nome) values ('Masculino');
insert into genero (nome) values ('Feminino');
insert into genero (nome) values ('Outro');


