package jr.acens.api.domain.user.DTO;

import jr.acens.api.domain.user.User;
import jr.acens.api.domain.user.UserProfile;

import java.util.Date;

public record UserReturnListDTO(Long id,
                                String login,
                                String name,
                                Date birthday,
                                String cpf,
                                String professionalId,
                                UserProfile profile,
                                String phone
                                ) {

    public UserReturnListDTO(User user) {
        this(user.getId(), user.getLogin(), user.getName(), user.getBirthday(), user.getCpf(), user.getProfessionalId(), user.getProfile(), user.getPhone());
    }
}
