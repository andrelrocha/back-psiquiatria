package jr.acens.api.domain.diretriz;

import jr.acens.api.domain.Doencas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiretrizRepository extends JpaRepository<Diretriz, Long> {
    @Query("""
            SELECT d FROM Diretriz d 
            WHERE d.doenca = :doenca
            AND WHERE d.confirmed = true
            """)
    Page<Diretriz> findAllDiretrizesConfirmedByDoenca(Pageable pageable, Doencas doenca);

    boolean existsByText(String text);
}
