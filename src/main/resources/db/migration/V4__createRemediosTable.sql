create table remedios (
    id bigint not null auto_increment,
    nome varchar(50),
    classe varchar(60),
    meia_vida varchar(200),
    dose_usual varchar(255),
    dose_terapeutica varchar(255),
    colaterais TEXT,
    manejo TEXT,


    primary key (id)
)