create table diretrizes (
     id bigint not null auto_increment,
     doenca varchar(100) not null,
     topico varchar(255),
     text TEXT not null,

     primary key (id)
 )