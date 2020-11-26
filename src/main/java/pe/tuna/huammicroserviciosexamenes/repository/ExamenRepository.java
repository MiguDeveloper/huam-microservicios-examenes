package pe.tuna.huammicroserviciosexamenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.tuna.huammicroserviciosexamenes.models.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
}
