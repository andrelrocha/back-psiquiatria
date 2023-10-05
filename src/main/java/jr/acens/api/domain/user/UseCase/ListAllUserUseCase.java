package jr.acens.api.domain.user.UseCase;

import jr.acens.api.domain.user.DTO.UserReturnListDTO;
import jr.acens.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ListAllUserUseCase {
    @Autowired
    private UserRepository repository;

    public Page<UserReturnListDTO> listAllUsers(Pageable pageable) {
        return repository.findAll(pageable).map(UserReturnListDTO::new);
    }
}
