package jr.acens.api.domain.sintoma.useCase;

import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaUpdateDTO;
import jr.acens.api.domain.sintoma.SintomaRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateSintomaUseCase {
    @Autowired
    private SintomaRepository repository;

    public SintomaReturnDTO updateSintoma(SintomaUpdateDTO data, Long id) {
        var sintoma = repository.findSintomaByIdToHandle(id);

        if (sintoma == null) {
            throw new ValidationException("Não foram encontrados registros de sintomas para o id fornecido.");
        }

        sintoma.updateSintoma(data);

        var sintomaOnDb = repository.save(sintoma);

        return new SintomaReturnDTO(sintomaOnDb);
    }

}
