package be.ephec.padel_backend.service;

import be.ephec.padel_backend.repository.MembreRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MembreRepository membreRepository;

    public CustomUserDetailsService(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
        var membre = membreRepository.findByMatricule(matricule)
                .orElseThrow(() -> new UsernameNotFoundException("Matricule introuvable : " + matricule));

        String role = switch (membre.getTypeMembre()) {
            case GLOBAL -> "ROLE_GLOBAL";
            case SITE   -> "ROLE_SITE";
            case LIBRE  -> "ROLE_LIBRE";
        };

        return new User(
                membre.getMatricule(),
                "",
                List.of(new SimpleGrantedAuthority(role))
        );
    }
}