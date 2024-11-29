package josehomenhuck.assembly.repository;

import josehomenhuck.assembly.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    Optional<Agenda> findAgendaByName(String name);
}
