package jr.acens.api.domain.remedio;

import jr.acens.api.domain.Doencas;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClassesConverter implements Converter<String, ClassesRemedio> {
    @Override
    public ClassesRemedio convert(String source) {
        try {
            return ClassesRemedio.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("A classe informada não existe como classe de remédio no banco de dados");
        }
    }
}
