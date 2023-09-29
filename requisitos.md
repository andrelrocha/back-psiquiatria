**DONE**
CREATE USER - OK!
SISTEMA DE LOGIN - OK!
SISTEMA RECUPERAÇÃO DE SENHA - OK!
UPDATE USER - OK!
DELETE USER - OK!
CREATE ADMIN - OK!
LIST USER BY ID - OK!


---- DOENCAID é ENUM com as 5 doenças do documento

**TO DO**
LIST USER {
- All - {retorna todos paginado, ordenado por nome}
- byName; {retorna todos paginado, ordenado por nome}
- byEmail;
- byCrf; 
- byProfile;
}

CRIAR TABLE DIRETRIZ
- CADA DIRETRIZ RECEBERÁ TEXTO, TÓPICO, DOENCAID -> doencaID será enum {string}
CREATE DIRETRIZ [rota exclusiva adm] - doencaId not null (string), título(varchar(255)), text (TEXT)
UPDATE DIRETRIZ [rota exclusiva adm]
DELETE DIRETRIZ [rota exclusiva adm]
LISTAR DIRETRIZES BY DOENCAID - receberá do front o doencaId e exibirá todos os textos com o doencaId

CRIAR TABLE SINTOMAS
- cada sintoma receberá - sintoma_desc, doencaId que estiver relacionado

CRIAR TABLE REMÉDIOS
{CONFERIR DADOS REMÉDIOS}


SUGESTAO DIRETRIZ 
- User irá sugerir doença, tópico e texto
- ao sugerir, será enviado email para arildo para que ele confirme
- ele pode aceitar, criando o registro na table doencas, ou recusar, apagando 
- posso pensar em uma column CONFIRMATION_STATUS