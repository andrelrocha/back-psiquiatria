package jr.acens.api.service;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import org.springframework.data.domain.Page;

public interface SintomaService {
    public Page<SintomaReturnDTO> getAllSintomasByDoenca(Doencas doenca);
}
