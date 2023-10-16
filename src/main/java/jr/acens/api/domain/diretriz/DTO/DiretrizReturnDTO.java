package jr.acens.api.domain.diretriz.DTO;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.Diretriz;

public record DiretrizReturnDTO(Long id, String titulo, String text) {
    public DiretrizReturnDTO(Diretriz diretriz) {
        this(diretriz.getId(), diretriz.getTopico(), diretriz.getText());
    }
}
