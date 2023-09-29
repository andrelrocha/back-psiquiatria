package jr.acens.api.domain.user.admin.useCase;

import jr.acens.api.domain.user.DTO.UserDTO;
import jr.acens.api.domain.user.DTO.UserReturnLoginDTO;
import jr.acens.api.domain.user.UseCase.CreateUserUseCase;
import jr.acens.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAdminUseCase {
    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private UserRepository repository;

    public UserReturnLoginDTO createAdmin(UserDTO data) {
        var newUser = createUserUseCase.createUser(data);

        var admin = repository.findByIdToHandle(newUser.id());

        admin.setAdmin();

        return new UserReturnLoginDTO(admin);
    }
}
