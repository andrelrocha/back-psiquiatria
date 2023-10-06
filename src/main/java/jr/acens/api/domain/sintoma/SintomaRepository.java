package jr.acens.api.domain.sintoma;

import jr.acens.api.domain.Doencas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SintomaRepository extends JpaRepository<Sintoma, Long> {
    @Query("""
            SELECT s FROM Sintoma s 
            WHERE s.doenca = :doenca
            """)
    Page<Sintoma> findAllSintomasByDoenca(Pageable pageable, Doencas doenca);
}
