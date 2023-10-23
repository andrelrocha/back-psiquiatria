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
            AND d.confirmed = true
            """)
    Page<Diretriz> findAllDiretrizesConfirmedByDoenca(Pageable pageable, Doencas doenca);

    @Query("""
            SELECT d FROM Diretriz d 
            WHERE d.confirmed = false
            """)
    Page<Diretriz> findAllDiretrizesNotConfirmed(Pageable pageable);

    boolean existsByText(String text);

    boolean existsByTopico(String topico);

    @Query("""
            SELECT d FROM Diretriz d
            WHERE d.id = :id
            """)
    Diretriz findDiretrizByIdToHandle(Long id);

}
