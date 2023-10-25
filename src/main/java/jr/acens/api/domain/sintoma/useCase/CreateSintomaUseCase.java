package jr.acens.api.domain.sintoma.useCase;

import jr.acens.api.domain.sintoma.DTO.SintomaDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.domain.sintoma.Sintoma;
import jr.acens.api.domain.sintoma.SintomaRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateSintomaUseCase {
    @Autowired
    private SintomaRepository repository;

    public SintomaReturnDTO createSintoma(SintomaDTO dto) {
        var sintomaExists = repository.existsByDescricaoAndDoenca(dto.descricao(), dto.doenca());

        if (sintomaExists) {
            throw new ValidationException("Esse sintoma já existe no banco de dados.");
        }

        var sintoma = new Sintoma(dto);

        var sintomaOnDb = repository.save(sintoma);

        return new SintomaReturnDTO(sintomaOnDb);
    }

}
