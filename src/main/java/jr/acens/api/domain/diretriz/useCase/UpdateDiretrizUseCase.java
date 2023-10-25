package jr.acens.api.domain.diretriz.useCase;

import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.diretriz.DTO.UpdateDiretrizDTO;
import jr.acens.api.domain.diretriz.DiretrizRepository;
import jr.acens.api.infra.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateDiretrizUseCase {
    @Autowired
    private DiretrizRepository repository;

    public DiretrizReturnDTO updateDiretriz(UpdateDiretrizDTO data, Long id) {
        var diretriz = repository.findDiretrizByIdToHandle(id);

        if (diretriz == null) {
            throw new ValidationException("Não foram encontrados registros de diretriz para o id fornecido.");
        }

        diretriz.updateDiretriz(data);

        repository.save(diretriz);

        return new DiretrizReturnDTO(diretriz);
    }

}
