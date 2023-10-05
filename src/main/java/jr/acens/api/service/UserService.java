package jr.acens.api.service;

import jr.acens.api.domain.user.DTO.*;
import jr.acens.api.infra.security.TokenJwtDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    //SISTEMA DE LOGIN
    TokenJwtDto performLogin(UserLoginDTO data);
    String forgotPassword(UserLoginOnlyDTO data);
    String resetPassword(UserResetPassDTO data);

    //CRUD
    UserReturnLoginDTO createUser(UserDTO data);
    void deleteUser(Long id);
    Page<UserReturnListDTO> listAllUser(Pageable pageable);
    UserReturnListDTO listUserById(Long id);
    UserReturnListDTO updateUser(UserUpdateDTO data, Long id);

    //admin
    UserReturnLoginDTO createAdmin(UserDTO data);
}
