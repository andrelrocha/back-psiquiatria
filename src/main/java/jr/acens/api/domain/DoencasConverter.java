package jr.acens.api.domain;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoencasConverter implements Converter<String, Doencas> {
    @Override
    public Doencas convert(String source) {
        try {
            return Doencas.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("A doença informada não existe como diretriz no banco de dados");
        }
    }
}
