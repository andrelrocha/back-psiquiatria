package jr.acens.api.service;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.diretriz.DTO.UpdateDiretrizDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiretrizService {
    public Page<DiretrizReturnDTO> getAllDiretrizesByDoenca(Pageable pageable, String doenca);

    public DiretrizReturnDTO createDiretriz(DiretrizDTO data);
    public DiretrizReturnDTO updateDiretriz(UpdateDiretrizDTO data, Long id);
    public void deleteDiretriz(Long id);



    public String suggestDiretriz(DiretrizDTO data);
    public String confirmSuggestion(Long id);
    public void denySuggestion(Long id);
    public Page<DiretrizReturnDTO> getDiretrizesSuggestion(Pageable pageable);
}
