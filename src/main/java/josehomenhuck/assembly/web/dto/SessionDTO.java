package josehomenhuck.assembly.web.dto;

import josehomenhuck.assembly.domain.Agenda;
import josehomenhuck.assembly.domain.Session;
import lombok.Data;

@Data
public class SessionDTO {
    private Long agendaId;

    private Integer duration;

    public Session toModel(Agenda agenda) {
        return Session.builder()
                .agenda(agenda)
                .duration(duration != null ? duration : 1)
                .build();
    }
}
