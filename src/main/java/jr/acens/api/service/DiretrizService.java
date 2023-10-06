package jr.acens.api.service;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiretrizService {
    public Page<DiretrizReturnDTO> getAllDiretrizesByDoenca(Pageable pageable, Doencas doenca);
}
