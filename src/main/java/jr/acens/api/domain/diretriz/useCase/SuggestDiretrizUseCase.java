package jr.acens.api.domain.diretriz.useCase;

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
    private MailSenderMime mailSender;

    @Value("${spring.mail.username}")
    private String login;

    public void suggestDiretriz(DiretrizDTO data) {
        var diretrizExists = repository.existsByTopico(data.topico());
        if (diretrizExists) {
            /////////////////////
            //CASO DE ATUALIZAR//
            /////////////////////
        }

        var diretriz = new Diretriz(data);
        repository.save(diretriz);

        var subject = "Confirmar sugestão diretriz";
        var body = "Você recebeu uma sugestão de diretriz no tópico da doença:\n" + data.topico() + "\n"
                + data.doencas() + "\nPara recusar ou aceitar, acesse a rota de admin da aplicação.";

        var mailDTO = new MailDTO(subject, login, body);

        mailSender.sendMail(mailDTO);
    }
}
