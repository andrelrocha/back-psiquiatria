package jr.acens.api.domain.remedio.useCase;

import jr.acens.api.domain.remedio.ClassesConverter;
import jr.acens.api.domain.remedio.DTO.RemedioReturnDTO;
import jr.acens.api.domain.remedio.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetRemediosByClasse {
    @Autowired
    private RemedioRepository repository;

    @Autowired
    private ClassesConverter converter;

    public Page<RemedioReturnDTO> getRemediosByClasse(Pageable pageable, String classe) {
        var classeEnum = converter.convert(classe);

        return repository.findAllRemediosByClasse(pageable, classeEnum).map(RemedioReturnDTO::new);
    }

}
