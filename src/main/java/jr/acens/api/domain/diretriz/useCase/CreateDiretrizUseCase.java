package jr.acens.api.domain.diretriz.useCase;

import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.diretriz.Diretriz;
import jr.acens.api.domain.diretriz.DiretrizRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateDiretrizUseCase {
    @Autowired
    private DiretrizRepository repository;

    public DiretrizReturnDTO createDiretriz(DiretrizDTO data) {
        var diretrizExists = repository.existsByText(data.text());

        if (diretrizExists) {
            throw new ValidationException("Essa diretriz já existe no banco de dados.");
        }

        var diretriz = new Diretriz(data);

        var diretrizOnDb = repository.save(diretriz);

        return new DiretrizReturnDTO(diretrizOnDb);
    }
}
