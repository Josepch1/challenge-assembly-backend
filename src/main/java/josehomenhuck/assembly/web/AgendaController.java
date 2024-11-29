package josehomenhuck.assembly.web;

import josehomenhuck.assembly.domain.Agenda;
import josehomenhuck.assembly.service.AgendaService;
import josehomenhuck.assembly.web.dto.AgendaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/agendas")
public class AgendaController {
    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    // Create a new agenda
    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody AgendaDTO agendaDTO) {
        return ResponseEntity.ok(agendaService.createAgenda(agendaDTO));
    }

    // Get an agenda by id
    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgenda(@PathVariable Long id) {
        return ResponseEntity.ok(agendaService.getAgendaById(id));
    }

    // Get all agendas
    @GetMapping
    public ResponseEntity<Iterable<Agenda>> getAllAgendas() {
        return ResponseEntity.ok(agendaService.getAllAgendas());
    }

    // Get agenda by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Agenda> getAgendaByName(@PathVariable String name) {
        return ResponseEntity.ok(agendaService.getAgendaByName(name));
    }
}
