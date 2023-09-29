package jr.acens.api.service;

import jr.acens.api.domain.user.DTO.*;
import jr.acens.api.infra.security.TokenJwtDto;

public interface UserService {
    TokenJwtDto performLogin(UserLoginDTO data);
    UserReturnLoginDTO createUser(UserDTO data);
    String forgotPassword(UserLoginOnlyDTO data);
    String resetPassword(UserResetPassDTO data);
    UserReturnListDTO updateUser(UserUpdateDTO data, Long id);
    UserReturnListDTO listUserById(Long id);
    void deleteUser(Long id);
}
