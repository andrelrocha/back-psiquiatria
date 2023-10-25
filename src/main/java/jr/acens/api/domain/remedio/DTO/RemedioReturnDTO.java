package jr.acens.api.domain.remedio.DTO;

import jr.acens.api.domain.remedio.ClassesRemedio;
import jr.acens.api.domain.remedio.Remedio;

public record RemedioReturnDTO(
        ClassesRemedio classesRemedio,
        String nome,
        String meiaVida,
        String doseUsual,
        String doseTerapeutica,
        String colaterais,
        String manejo
) {
    public RemedioReturnDTO(Remedio remedio) {
        this(
                remedio.getClassesRemedio(),
                remedio.getNome(),
                remedio.getMeiaVida(),
                remedio.getDoseUsual(),
                remedio.getDoseTerapeutica(),
                remedio.getColaterais(),
                remedio.getManejo()
        );
    }
}