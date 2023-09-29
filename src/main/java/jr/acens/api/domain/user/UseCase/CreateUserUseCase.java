package jr.acens.api.domain.user.UseCase;

import jr.acens.api.domain.user.DTO.UserReturnLoginDTO;
import jr.acens.api.domain.user.User;
import jr.acens.api.domain.user.UserRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import jr.acens.api.domain.user.DTO.UserDTO;

@Component
public class CreateUserUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserReturnLoginDTO createUser(UserDTO data) {
        boolean userExists = userRepository.userExistsByLoginOrCpf(data.login(), data.cpf());

        if (userExists) {
            throw new ValidationException("Email ou CPF informado já existe no banco de dados!\n" +
                    "Impossível concluir o processo de criação de conta.\n");
        }

        User newUser = new User(data);

        String encodedPassword = bCryptPasswordEncoder.encode(data.password());
        newUser.setPassword(encodedPassword);

        var userOnDb = userRepository.save(newUser);

        return new UserReturnLoginDTO(userOnDb);
    }
}
