create table users (
     id bigint not null auto_increment,
     login varchar(100) not null,
     password varchar(255) not null,
     token_email varchar(255),
     token_expiration datetime,
     role varchar(100) not null,
     name varchar(255) not null,
     birthday DATE NOT NULL,
     cpf VARCHAR(14) NOT NULL UNIQUE,
     profile VARCHAR(255) NOT NULL,
     professional_id VARCHAR(255),
     phone VARCHAR(20),

     primary key (id)
 )