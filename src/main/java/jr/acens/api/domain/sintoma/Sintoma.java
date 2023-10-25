package jr.acens.api.domain.sintoma;

import jakarta.persistence.*;
import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "sintomas")
@Entity(name = "Sintoma")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sintoma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Doencas doenca;
    @Lob
    private String descricao;

    public Sintoma(SintomaDTO dto) {
        this.doenca = dto.doenca();
        this.descricao = dto.descricao();
    }

    public void updateSintoma(SintomaUpdateDTO data) {
        this.descricao = data.descricao();
    }
}
