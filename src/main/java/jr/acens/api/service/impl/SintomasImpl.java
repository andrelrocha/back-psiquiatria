package jr.acens.api.service.impl;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.sintoma.DTO.SintomaDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaUpdateDTO;
import jr.acens.api.domain.sintoma.useCase.CreateSintomaUseCase;
import jr.acens.api.domain.sintoma.useCase.GetSintomasByDoencaUseCase;
import jr.acens.api.domain.sintoma.useCase.UpdateSintomaUseCase;
import jr.acens.api.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SintomasImpl implements SintomaService {

    @Autowired
    private CreateSintomaUseCase createSintomaUseCase;

    @Autowired
    private GetSintomasByDoencaUseCase getSintomasByDoencaUseCase;

    @Autowired
    private UpdateSintomaUseCase updateSintomaUseCase;

    @Override
    public Page<SintomaReturnDTO> getAllSintomasByDoenca(Doencas doenca) {
        return null;
    }

    @Override
    public SintomaReturnDTO createSintoma(SintomaDTO data) {
        var sintoma = createSintomaUseCase.createSintoma(data);
        return sintoma;
    }

    @Override
    public Page<SintomaReturnDTO> getSintomasByDoenca(Pageable pageable, String doenca) {
        var sintomas = getSintomasByDoencaUseCase.getSintomasByDoenca(pageable, doenca);
        return sintomas;
    }

    @Override
    public SintomaReturnDTO updateSintoma(SintomaUpdateDTO data, Long id) {
        var sintomaUpdated = updateSintomaUseCase.updateSintoma(data, id);
        return sintomaUpdated;
    }
}
