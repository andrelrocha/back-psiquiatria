package jr.acens.api.domain.diretriz.DTO;

import jr.acens.api.domain.Doencas;

public record DiretrizDTO(Doencas doenca, String topico, String text) {
}
