package josehomenhuck.assembly.service;

import josehomenhuck.assembly.domain.Agenda;
import josehomenhuck.assembly.repository.AgendaRepository;
import josehomenhuck.assembly.web.dto.AgendaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public Agenda createAgenda(AgendaDTO agendaDTO) {
        Agenda newAgenda = agendaDTO.toModel();

        return agendaRepository.save(newAgenda);
    }

    public Agenda getAgendaById(Long id) {
        return agendaRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Agenda not found")
        );
    }

    public Iterable<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    public Agenda getAgendaByName(String name) {
        return agendaRepository.findAgendaByName(name).orElseThrow(
                () -> new IllegalArgumentException("Agenda not found")
        );
    }
}
