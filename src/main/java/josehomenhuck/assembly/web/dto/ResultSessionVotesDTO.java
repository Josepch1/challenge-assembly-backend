package josehomenhuck.assembly.web.dto;

import josehomenhuck.assembly.domain.Agenda;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultSessionVotesDTO {
    private Long id;
    private Agenda agenda;
    private Long yesVotes;
    private Long noVotes;
}
