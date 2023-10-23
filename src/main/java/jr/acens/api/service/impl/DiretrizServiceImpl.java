package jr.acens.api.service.impl;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.diretriz.useCase.*;
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

    @Autowired
    private GetDiretrizesByDoencaUseCase getDiretrizesByDoencaUseCase;

    @Autowired
    private SuggestDiretrizUseCase suggestDiretrizUseCase;

    @Autowired
    private ConfirmSuggestionDiretrizUseCase confirmSuggestionDiretrizUseCase;
    @Autowired
    private DenySuggestionDiretrizUseCase denySuggestionDiretrizUseCase;
    @Autowired
    private GetDiretrizesSuggestionUseCase getDiretrizesSuggestionUseCase;

    @Override
    public Page<DiretrizReturnDTO> getAllDiretrizesByDoenca(Pageable pageable, String doenca) {
        var page = getDiretrizesByDoencaUseCase.getDiretrizesByDoenca(pageable, doenca);
        return page;
    }

    @Override
    public DiretrizReturnDTO createDiretriz(DiretrizDTO data) {
        var diretriz = createDiretrizUseCase.createDiretriz(data);
        confirmSuggestionDiretrizUseCase.confirmSuggestion(diretriz.id());
        return diretriz;
    }

    @Override
    public String suggestDiretriz(DiretrizDTO data) {
        suggestDiretrizUseCase.suggestDiretriz(data);
        return "Sugestão criada! aguarde o administrador do sistema";
    }

    @Override
    public String confirmSuggestion(Long id) {
        confirmSuggestionDiretrizUseCase.confirmSuggestion(id);
        return "Pronto! A sugestão foi aprovada e já será exibida quando da devida listagem.";
    }

    @Override
    public void denySuggestion(Long id) {
        denySuggestionDiretrizUseCase.denySuggestion(id);
    }

    @Override
    public Page<DiretrizReturnDTO> getDiretrizesSuggestion(Pageable pageable) {
        var diretrizes = getDiretrizesSuggestionUseCase.getDiretrizesSuggestion(pageable);
        return diretrizes;
    }
}
