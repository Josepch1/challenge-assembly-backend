package josehomenhuck.assembly.web.dto;


import josehomenhuck.assembly.domain.Agenda;
import lombok.Data;

@Data
public class AgendaDTO {
    private String name;

    public Agenda toModel() {
        return Agenda.builder()
                .name(name)
                .build();
    }
}
