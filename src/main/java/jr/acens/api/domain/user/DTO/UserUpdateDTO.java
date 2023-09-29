package jr.acens.api.domain.user.DTO;

import jr.acens.api.domain.user.UserProfile;

import java.util.Date;

public record UserUpdateDTO(String name, Date birthday, UserProfile profile, String phone) {
}
