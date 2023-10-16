package jr.acens.api.domain.diretriz.useCase;

import jr.acens.api.domain.DoencasConverter;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.Diretriz;
import jr.acens.api.domain.diretriz.DiretrizRepository;
import jr.acens.api.infra.utils.mail.MailDTO;
import jr.acens.api.infra.utils.mail.MailSenderMime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SuggestDiretrizUseCase {
    @Autowired
    private DiretrizRepository repository;

    @Autowired
    private CreateDiretrizUseCase createDiretrizUseCase;

    @Autowired
    private MailSenderMime mailSender;

    @Value("${spring.mail.username}")
    private String login;



    public void suggestDiretriz(DiretrizDTO data) {
        /*
        System.out.println("AQUI FUNCIONOU");
        var diretrizExists = repository.existsByTopico(data.topico());
        System.out.println("AQUI DEPOIS DE EXISTIR");
        if (diretrizExists) {
            System.out.println("OK NAO ERA PARA ISSO TER ACONTECIDO");
            /////////////////////
            //CASO DE ATUALIZAR//
            /////////////////////
        }
        */

        createDiretrizUseCase.createDiretriz(data);

        var subject = "Confirmar sugestão diretriz";
        var body = "Você recebeu uma sugestão de diretriz no tópico da doença:\nTÓPICO: " + data.topico() + "\nDOENCA: "
                + data.doenca() + "\nPara recusar ou aceitar, acesse a rota de admin da aplicação.";

        var mailDTO = new MailDTO(subject, login, body);

        mailSender.sendMail(mailDTO);
    }
}
