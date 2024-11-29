package josehomenhuck.assembly.web;

import josehomenhuck.assembly.domain.Vote;
import josehomenhuck.assembly.service.VoteService;
import josehomenhuck.assembly.web.dto.VoteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/votes")
public class VoteController {
    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody VoteDTO voteDTO) {
        return ResponseEntity.ok(voteService.createVote(voteDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable Long id) {
        return ResponseEntity.ok(voteService.getVoteById(id));
    }
}
