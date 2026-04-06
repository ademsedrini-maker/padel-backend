package be.ephec.padel_backend.service;

import be.ephec.padel_backend.model.ParticipantMatch;
import be.ephec.padel_backend.repository.ParticipantMatchRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParticipantMatchService {

    private final ParticipantMatchRepository participantRepository;

    public ParticipantMatchService(ParticipantMatchRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<ParticipantMatch> getAll() {
        return participantRepository.findAll();
    }

    public ParticipantMatch create(ParticipantMatch participant) {
        return participantRepository.save(participant);
    }
}
