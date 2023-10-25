package jr.acens.api.domain.sintoma.useCase;

import jr.acens.api.domain.DoencasConverter;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.domain.sintoma.SintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetSintomasByDoencaUseCase {
    @Autowired
    private SintomaRepository repository;

    @Autowired
    private DoencasConverter converter;

    public Page<SintomaReturnDTO> getSintomasByDoenca(Pageable pageable, String doenca) {
        var doencaEnum = converter.convert(doenca);

        return repository.findAllSintomasByDoenca(pageable, doencaEnum).map(SintomaReturnDTO::new);
    }
}
