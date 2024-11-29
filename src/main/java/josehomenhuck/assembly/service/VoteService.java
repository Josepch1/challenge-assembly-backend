package josehomenhuck.assembly.service;

import josehomenhuck.assembly.domain.Session;
import josehomenhuck.assembly.domain.Vote;
import josehomenhuck.assembly.repository.SessionRepository;
import josehomenhuck.assembly.repository.VoteRepository;
import josehomenhuck.assembly.web.dto.VoteDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final SessionRepository sessionRepository;

    public VoteService(VoteRepository voteRepository, SessionRepository sessionRepository) {
        this.voteRepository = voteRepository;
        this.sessionRepository = sessionRepository;
    }

    public Vote createVote(VoteDTO voteDTO) {
        Session session = sessionRepository.findById(voteDTO.getSessionId())
                .orElseThrow(() -> new IllegalArgumentException("Session not found with id: " + voteDTO.getSessionId()));

        LocalDateTime isClosed = session.getStart().plusMinutes(session.getDuration());

        if (LocalDateTime.now().isAfter(isClosed)) {
            throw new IllegalArgumentException("Session is closed");
        }

        boolean alreadyVoted = voteRepository.existsByAssociateAndSession(voteDTO.getAssociate(), session);
        if (alreadyVoted) {
            throw new IllegalArgumentException("This associate has already voted in this session");
        }

        Vote newVote = Vote.builder()
                .associate(voteDTO.getAssociate())
                .session(session)
                .voteType(voteDTO.getVoteType())
                .build();

        return voteRepository.save(newVote);
    }

    public Vote getVoteById(Long id) {
        return voteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Vote not found"));
    }

    public List<Vote> getAllBySessionId(Long sessionId) {
        return voteRepository.findAllBySessionId(sessionId);
    }
}
