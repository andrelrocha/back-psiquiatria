**DONE**
CREATE USER - OK!
SISTEMA DE LOGIN - OK!
SISTEMA RECUPERAÇÃO DE SENHA - OK!
UPDATE USER - OK!
DELETE USER - OK!
CREATE ADMIN - OK!
LIST USER BY ID - OK!
LIST ALL USERS COM PAGINAÇÃO - OK!
LIST ALL USERS COM QUERY PERSONALIZADO DO FRONT - OK!
LIST USERS BY PROFILE - OK!
MIGRATION TABLE DIRETRIZ - OK!
CRIAR O DOENCAS_CONVERTER - convertendo string para enum - OK!
CLASS DIRETRIZ - OK!
REPOSITORY DIRETRIZ - OK!
MAIN DTO DIRETRIZ - OK!
SERVICE LAYER DIRETRIZ - OK!
MIGRATION TABLE SINTOMAS - OK!
CLASS SINTOMAS - OK!
REPOSITORY SINTOMAS - OK!
MAIN DTO SINTOMAS - OK!
SERVICE LAYER SINTOMAS - OK!



**{ANDRÉ IRÁ PROTEGER AS ROTAS EXCLUSIVAS PARA ADM, DESENVOLVAM NORMAL}**
//////////////
LUCAS & WALISSON

**DIRETRIZES** 
CREATE DIRETRIZ [rota exclusiva adm] 
UPDATE DIRETRIZ [rota exclusiva adm]
DELETE DIRETRIZ [rota exclusiva adm]
LISTAR DIRETRIZES BY DOENCA - receberá do front o uma string, que passará por DoencasConverter para transformar em enum
e exibirá todos os textos com o doenca recebido

**SINTOMAS**
CREATE SINTOMAS [rota exclusiva adm]
UPDATE SINTOMAS [rota exclusiva adm]
DELETE SINTOMAS [rota exclusiva adm]
LISTAR SINTOMAS BY DOENCA - receberá do front o uma string, que passará por DoencasConverter para transformar em enum
e exibirá todos os sintomas com o doenca recebido




///////////////
ANDRÉ 

CRIAR TABLE REMÉDIOS *{CONFERIR DADOS REMÉDIOS}* 
- MIGRATION TABLE REMÉDIOS
- CLASS REMÉDIOS
- REPOSITORY REMEDIOS

**SUGESTAO DIRETRIZ** 
- User irá sugerir doença, tópico e texto
- ao sugerir, será enviado email para arildo para que ele confirme
- ele pode aceitar, criando o registro na table doencas, ou recusar, apagando 
- posso pensar em uma column CONFIRMATION_STATUS - SÓ EXIBE AS DIRETRIZES QUE ESTEJAM COMO "TRUE"
- nao haverá registro de false, mas uma exclusão do banco de dados direta 
- usuário pode tanto adicionar uma sugestão, quanto sugerir editar uma informação já existente