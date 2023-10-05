package jr.acens.api.domain.user.UseCase;

import jr.acens.api.domain.user.DTO.UserReturnListDTO;
import jr.acens.api.domain.user.UserProfile;
import jr.acens.api.domain.user.UserProfileConverter;
import jr.acens.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ListUsersByProfile {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserProfileConverter profileConverter;

    public Page<UserReturnListDTO> listUsersByProfile(Pageable pageable, String profile) {

        var profileEnum = profileConverter.convert(profile);

        return repository.findAllByProfile(pageable, profileEnum).map(UserReturnListDTO::new);
    }
}
