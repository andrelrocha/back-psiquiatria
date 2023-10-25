package jr.acens.api.domain.remedio;

import jakarta.persistence.*;
import jr.acens.api.domain.remedio.DTO.RemedioDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "remedios")
@Entity(name = "Remedio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "classe")
    @Enumerated(EnumType.STRING)
    private ClassesRemedio classesRemedio;
    private String nome;
    @Column(name = "meia_vida")
    private String meiaVida;
    @Column(name = "dose_usual")
    private String doseUsual;
    @Column(name = "dose_terapeutica")
    private String doseTerapeutica;
    @Lob
    private String colaterais;
    @Lob
    private String manejo;

    public Remedio(RemedioDTO data) {
        this.classesRemedio = data.classesRemedio();
        this.nome = data.nome();
        this.meiaVida = data.meiaVida();
        this.doseUsual = data.doseUsual();
        this.doseTerapeutica = data.doseTerapeutica();
        this.colaterais = data.colaterais();
        this.manejo = data.manejo();
    }
}
