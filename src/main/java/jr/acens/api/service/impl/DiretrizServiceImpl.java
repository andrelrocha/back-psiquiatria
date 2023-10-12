package jr.acens.api.service.impl;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.diretriz.useCase.CreateDiretrizUseCase;
import jr.acens.api.domain.user.UseCase.CreateUserUseCase;
import jr.acens.api.service.DiretrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiretrizServiceImpl implements DiretrizService {
    @Autowired
    private CreateDiretrizUseCase createDiretrizUseCase;

    @Override
    public Page<DiretrizReturnDTO> getAllDiretrizesByDoenca(Pageable pageable, Doencas doenca) {
        return null;
    }

    @Override
    public DiretrizReturnDTO createDiretriz(DiretrizDTO data) {
        var diretriz = createDiretrizUseCase.createDiretriz(data);
        return diretriz;
    }
}
