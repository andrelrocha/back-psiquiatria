package jr.acens.api.domain.remedio.DTO;

import jr.acens.api.domain.remedio.ClassesRemedio;

public record RemedioDTO(
        ClassesRemedio classesRemedio,
        String nome,
        String meiaVida,
        String doseUsual,
        String doseTerapeutica,
        String colaterais,
        String manejo
) {
}
