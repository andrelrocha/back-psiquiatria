package jr.acens.api.domain.user.DTO;

import jr.acens.api.domain.user.User;

public record UserReturnLoginDTO(Long id,
                                 String login,
                                 String name) {

    public UserReturnLoginDTO(User user) {
        this(user.getId(), user.getLogin(), user.getName());
    }
}
