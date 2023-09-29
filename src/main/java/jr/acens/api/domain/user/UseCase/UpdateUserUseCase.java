package jr.acens.api.domain.user.UseCase;

import jr.acens.api.domain.user.DTO.UserReturnDTO;
import jr.acens.api.domain.user.DTO.UserUpdateDTO;
import jr.acens.api.domain.user.UserRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUseCase {
    @Autowired
    private UserRepository repository;

    public UserReturnDTO updateUser(UserUpdateDTO data, Long id) {
        var user = repository.findByIdToHandle(id);

        if (user == null) {
            throw new ValidationException("Não foram encontrados registros de usuário para o id fornecido.");
        }

        user.updateUser(data);

        return new UserReturnDTO(user);
    }
}
