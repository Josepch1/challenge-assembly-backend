package josehomenhuck.assembly.web.dto;

import josehomenhuck.assembly.domain.Session;
import josehomenhuck.assembly.domain.Vote;
import josehomenhuck.assembly.domain.enums.VoteType;
import lombok.Data;

@Data
public class VoteDTO {
    private String associate;
    private VoteType voteType;
    private Long sessionId;

    public Vote toModel(Session session) {
        return Vote.builder()
                .associate(associate)
                .voteType(voteType)
                .session(session)
                .build();
    }
}
