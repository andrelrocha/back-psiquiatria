package jr.acens.api.domain.diretriz.useCase;

import jr.acens.api.domain.diretriz.DiretrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmSuggestionDiretrizUseCase {
    @Autowired
    private DiretrizRepository repository;

    public void confirmSuggestion(Long id) {
        var diretriz = repository.findDiretrizByIdToHandle(id);

        diretriz.setConfirmed();

        repository.save(diretriz);
    }
}
