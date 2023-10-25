package jr.acens.api.service;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.sintoma.DTO.SintomaDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SintomaService {
    public Page<SintomaReturnDTO> getAllSintomasByDoenca(Doencas doenca);

    public SintomaReturnDTO createSintoma(SintomaDTO data);

    public Page<SintomaReturnDTO> getSintomasByDoenca(Pageable pageable, String doenca);
}
