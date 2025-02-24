package josehomenhuck.assembly.repository;

import josehomenhuck.assembly.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
