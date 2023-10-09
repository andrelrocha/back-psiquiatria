package jr.acens.api.domain.remedio;

import jakarta.persistence.*;
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
}
