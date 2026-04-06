package be.ephec.padel_backend.service;

import be.ephec.padel_backend.enums.StatutMatch;
import be.ephec.padel_backend.enums.TypeMatch;
import be.ephec.padel_backend.model.MatchPadel;
import be.ephec.padel_backend.model.Membre;
import be.ephec.padel_backend.repository.MatchPadelRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchService {

    private final MatchPadelRepository matchRepository;
    private final MembreService membreService;

    public MatchService(MatchPadelRepository matchRepository, MembreService membreService) {
        this.matchRepository = matchRepository;
        this.membreService = membreService;
    }

    public List<MatchPadel> getAllMatchs() {
        return matchRepository.findAll();
    }

    public MatchPadel getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match introuvable"));
    }

    public MatchPadel createMatch(MatchPadel match, Membre organisateur) {
        if (membreService.hasPenalite(organisateur)) {
            throw new RuntimeException("Réservation impossible : pénalité active");
        }
        if (membreService.hasSoldueDu(organisateur)) {
            throw new RuntimeException("Réservation impossible : solde dû");
        }
        match.setOrganisateur(organisateur);
        match.setStatut(StatutMatch.EN_ATTENTE);
        return matchRepository.save(match);
    }

    public MatchPadel rendrePublic(Long matchId) {
        MatchPadel match = getMatchById(matchId);
        match.setTypeMatch(TypeMatch.PUBLIC);
        return matchRepository.save(match);
    }
}
