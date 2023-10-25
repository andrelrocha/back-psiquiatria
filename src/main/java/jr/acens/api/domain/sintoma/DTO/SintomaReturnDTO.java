package jr.acens.api.domain.sintoma.DTO;

import jr.acens.api.domain.sintoma.Sintoma;

public record SintomaReturnDTO(String descricao, Long id) {
    public SintomaReturnDTO(Sintoma sintoma) {
        this(sintoma.getDescricao(), sintoma.getId());
    }
}
