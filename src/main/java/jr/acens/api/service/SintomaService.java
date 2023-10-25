package jr.acens.api.service;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.sintoma.DTO.SintomaDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SintomaService {
    Page<SintomaReturnDTO> getAllSintomasByDoenca(Doencas doenca);

    SintomaReturnDTO createSintoma(SintomaDTO data);

    Page<SintomaReturnDTO> getSintomasByDoenca(Pageable pageable, String doenca);

    SintomaReturnDTO updateSintoma(SintomaUpdateDTO data, Long id);

    void deleteSintoma(Long id);
}
