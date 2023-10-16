package jr.acens.api.domain.diretriz.useCase;

import jr.acens.api.domain.diretriz.DiretrizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DenySuggestionDiretrizUseCase {
    @Autowired
    private DiretrizRepository repository;

    public void denySuggestion(Long id) {
        repository.deleteById(id);
    }
}
