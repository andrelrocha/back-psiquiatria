package jr.acens.api.domain.diretriz.useCase;

import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.diretriz.DiretrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetDiretrizesSuggestionUseCase {
    @Autowired
    private DiretrizRepository repository;

    public Page<DiretrizReturnDTO> getDiretrizesSuggestion(Pageable pageable) {
        var diretrizes = repository.findAllDiretrizesNotConfirmed(pageable).map(DiretrizReturnDTO::new);

        return diretrizes;
    }
}
