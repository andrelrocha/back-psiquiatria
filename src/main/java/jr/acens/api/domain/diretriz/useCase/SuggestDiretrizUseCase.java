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

        createDiretrizUseCase.createDiretriz(data);

        var subject = "Confirmar sugestão diretriz";
        var body = "Você recebeu uma sugestão de diretriz Na doença: " + data.doenca() +
                "\nPara recusar, aceitar ou editar, acesse a rota de admin da aplicação.";

        var mailDTO = new MailDTO(subject, login, body);

        mailSender.sendMail(mailDTO);
    }
}
