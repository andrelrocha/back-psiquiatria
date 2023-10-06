package jr.acens.api.domain.diretriz.DTO;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.Diretriz;

public record DiretrizReturnDTO(String titulo, String text) {
    public DiretrizReturnDTO(Diretriz diretriz) {
        this(diretriz.getTopico(), diretriz.getText());
    }
}