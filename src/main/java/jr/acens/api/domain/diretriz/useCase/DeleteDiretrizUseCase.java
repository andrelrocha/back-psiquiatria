package jr.acens.api.domain.diretriz.useCase;

import jr.acens.api.domain.diretriz.DiretrizRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDiretrizUseCase {
    @Autowired
    private DiretrizRepository repository;

    public void deleteDiretriz(Long id) {
        var diretriz = repository.findDiretrizByIdToHandle(id);

        if (diretriz == null) {
            throw new ValidationException("Não foram encontrados registros de diretriz para o id fornecido.");
        }

        repository.deleteById(id);
    }

}
