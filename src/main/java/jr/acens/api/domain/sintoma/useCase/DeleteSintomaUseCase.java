package jr.acens.api.domain.sintoma.useCase;

import jr.acens.api.domain.sintoma.SintomaRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteSintomaUseCase {
    @Autowired
    private SintomaRepository repository;

    public void deleteSintoma(Long id) {
        var sintoma = repository.findSintomaByIdToHandle(id);

        if (sintoma == null) {
            throw new ValidationException("Não foram encontrados registros de sintomas para o id fornecido.");
        }

        repository.deleteById(id);
    }

}
