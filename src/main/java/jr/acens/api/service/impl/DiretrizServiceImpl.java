package jr.acens.api.service.impl;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.service.DiretrizService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiretrizServiceImpl implements DiretrizService {
    @Override
    public Page<DiretrizReturnDTO> getAllDiretrizesByDoenca(Pageable pageable, Doencas doenca) {
        return null;
    }
}
