package jr.acens.api.domain.diretriz.useCase;

import jr.acens.api.domain.DoencasConverter;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.diretriz.DiretrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public class GetDiretrizesByDoencaUseCase {
    @Autowired
    private DiretrizRepository repository;
    @Autowired
    private DoencasConverter converter;

    public Page<DiretrizReturnDTO> getDiretrizesByDoenca(Pageable pageable, String doenca) {
        var doencaEnum = converter.convert(doenca);

        return repository.findAllDiretrizesConfirmedByDoenca(pageable, doencaEnum).map(DiretrizReturnDTO::new);
    }
}
