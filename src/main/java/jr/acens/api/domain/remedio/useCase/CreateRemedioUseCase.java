package jr.acens.api.domain.remedio.useCase;

import jr.acens.api.domain.remedio.DTO.RemedioDTO;
import jr.acens.api.domain.remedio.DTO.RemedioReturnDTO;
import jr.acens.api.domain.remedio.Remedio;
import jr.acens.api.domain.remedio.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateRemedioUseCase {
    @Autowired
    private RemedioRepository repository;

    public RemedioReturnDTO createRemedio(RemedioDTO dto) {
        var remedioExists = repository.existsByNome(dto.nome());

        if (remedioExists) {
            throw new RuntimeException("JÁ EXISTE REMÉDIO CADASTRADO COM ESTE NOME");
        }

        var remedio = new Remedio(dto);

        repository.save(remedio);

        return new RemedioReturnDTO(remedio);
    }
}
