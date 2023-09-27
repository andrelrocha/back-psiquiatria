package jr.acens.api.domain.user.UseCase;

import jr.acens.api.domain.user.UserRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import jr.acens.api.infra.utils.mail.GenerateMailToken;
import jr.acens.api.infra.utils.mail.MailDTO;
import jr.acens.api.infra.utils.mail.MailSenderMime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jr.acens.api.domain.user.DTO.UserForgotDTO;
import jr.acens.api.domain.user.DTO.UserReturnLoginDTO;

import java.time.LocalDateTime;

@Component
public class ForgotPasswordUseCase {
    @Autowired
    private UserRepository repository;
    @Autowired
    private MailSenderMime mailSender;
    @Autowired
    private GenerateMailToken mailToken;

    public void forgotPassword(UserReturnLoginDTO data) {
        var login = data.login();
        var userExists = repository.existsByLogin(login);

        if (!userExists) {
            throw new ValidationException("No user was found for the provided login");
        }

        var token = mailToken.generateEmailToken();
        var now = LocalDateTime.now().plusHours(1);
        var forgotDTO = new UserForgotDTO(token, now);

        var user = repository.findByLoginToHandle(login);
        user.forgotPassword(forgotDTO);

        var subject = "Forgot Password";

        var mailDTO = new MailDTO(subject, login, token);

        mailSender.sendMail(mailDTO);
    }
}