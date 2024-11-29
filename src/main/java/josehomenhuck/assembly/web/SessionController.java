package josehomenhuck.assembly.web;

import josehomenhuck.assembly.domain.Session;
import josehomenhuck.assembly.service.SessionService;
import josehomenhuck.assembly.web.dto.ResultSessionVotesDTO;
import josehomenhuck.assembly.web.dto.SessionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody SessionDTO sessionDTO) {
        return ResponseEntity.ok(sessionService.createSession(sessionDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {
        return ResponseEntity.ok(sessionService.getSessionById(id));
    }


    @GetMapping
    public ResponseEntity<Iterable<Session>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }

    @GetMapping("/{id}/result")
    public ResponseEntity<ResultSessionVotesDTO> getResultSessionVotes(@PathVariable Long id) {
        return ResponseEntity.ok(sessionService.getResultSessionVotes(id));
    }
}
