package jr.acens.api.domain.remedio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    @Query("SELECT r FROM Remedio r WHERE r.classesRemedio = :classesRemedio")
    Page<Remedio> findAllRemediosByClasse(Pageable pageable, ClassesRemedio classesRemedio);

    boolean existsByNome(String nome);
}
