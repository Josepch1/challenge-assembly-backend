package josehomenhuck.assembly.repository;

import josehomenhuck.assembly.domain.Session;
import josehomenhuck.assembly.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findAllBySessionId(Long sessionId);

    boolean existsByAssociateAndSession(String associate, Session session);
}
