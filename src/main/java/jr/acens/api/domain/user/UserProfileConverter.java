package jr.acens.api.domain.user;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserProfileConverter implements Converter<String, UserProfile> {
    @Override
    public UserProfile convert(String source) {
        try {
            return UserProfile.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("O tipo informado de usuário não existe no banco de dados");
        }
    }
}