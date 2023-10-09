package jr.acens.api.domain.diretriz;

import jakarta.persistence.*;
import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "diretrizes")
@Entity(name = "Diretriz")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Diretriz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Doencas doenca;
    private String topico;
    @Lob
    private String text;

    public Diretriz(DiretrizDTO dto) {
        this.doenca = dto.doencas();
        this.topico = dto.topico();
        this.text = dto.text();
    }
}
