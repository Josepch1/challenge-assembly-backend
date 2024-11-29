package josehomenhuck.assembly.service;

import josehomenhuck.assembly.domain.Agenda;
import josehomenhuck.assembly.domain.Session;
import josehomenhuck.assembly.domain.Vote;
import josehomenhuck.assembly.domain.enums.VoteType;
import josehomenhuck.assembly.repository.AgendaRepository;
import josehomenhuck.assembly.repository.SessionRepository;
import josehomenhuck.assembly.repository.VoteRepository;
import josehomenhuck.assembly.web.dto.ResultSessionVotesDTO;
import josehomenhuck.assembly.web.dto.SessionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    public final VoteRepository voteRepository;
    private final SessionRepository sessionRepository;
    private final AgendaRepository agendaRepository;


    public SessionService(SessionRepository sessionRepository, AgendaRepository agendaRepository, VoteRepository voteRepository) {
        this.sessionRepository = sessionRepository;
        this.agendaRepository = agendaRepository;
        this.voteRepository = voteRepository;
    }

    public Session createSession(SessionDTO sessionDTO) {
        Agenda agenda = agendaRepository.findById(sessionDTO.getAgendaId())
                .orElseThrow(() -> new IllegalArgumentException("Agenda not found"));

        Session newSession = sessionDTO.toModel(agenda);

        return sessionRepository.save(newSession);
    }

    public Session getSessionById(Long id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Session not found"));
    }

    public ResultSessionVotesDTO getResultSessionVotes(Long sessionId) {
        Session session = getSessionById(sessionId);
        List<Vote> votes = voteRepository.findAllBySessionId(sessionId);

        Long yesVotes = votes.stream()
                .filter(vote -> vote.getVoteType().equals(VoteType.YES))
                .count();

        Long noVotes = votes.stream()
                .filter(vote -> vote.getVoteType().equals(VoteType.NO))
                .count();

        return ResultSessionVotesDTO.builder()
                .id(session.getId())
                .agenda(session.getAgenda())
                .yesVotes(yesVotes)
                .noVotes(noVotes)
                .build();
    }

    public Iterable<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}
