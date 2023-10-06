package jr.acens.api.service.impl;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.service.SintomaService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SintomasImpl implements SintomaService {

    @Override
    public Page<SintomaReturnDTO> getAllSintomasByDoenca(Doencas doenca) {
        return null;
    }
}
