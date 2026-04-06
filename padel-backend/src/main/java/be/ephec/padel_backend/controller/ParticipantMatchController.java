package be.ephec.padel_backend.controller;

import be.ephec.padel_backend.model.ParticipantMatch;
import be.ephec.padel_backend.repository.ParticipantMatchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/participants")
@CrossOrigin(origins = "*")
public class ParticipantMatchController {

    private final ParticipantMatchRepository participantRepository;

    public ParticipantMatchController(ParticipantMatchRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @GetMapping
    public List<ParticipantMatch> getAll() {
        return participantRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ParticipantMatch> create(@RequestBody ParticipantMatch participant) {
        return ResponseEntity.ok(participantRepository.save(participant));
    }
}
