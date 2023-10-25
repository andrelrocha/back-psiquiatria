package jr.acens.api.service.impl;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.sintoma.DTO.SintomaDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.domain.sintoma.useCase.CreateSintomaUseCase;
import jr.acens.api.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SintomasImpl implements SintomaService {

    @Autowired
    private CreateSintomaUseCase createSintomaUseCase;

    @Override
    public Page<SintomaReturnDTO> getAllSintomasByDoenca(Doencas doenca) {
        return null;
    }

    @Override
    public SintomaReturnDTO createSintoma(SintomaDTO data) {
        var sintoma = createSintomaUseCase.createSintoma(data);
        return sintoma;
    }
}
