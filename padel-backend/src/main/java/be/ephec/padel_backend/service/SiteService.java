package be.ephec.padel_backend.service;

import be.ephec.padel_backend.model.Site;
import be.ephec.padel_backend.repository.SiteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SiteService {

    private final SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    public Site getSiteById(Long id) {
        return siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Site introuvable"));
    }

    public Site createSite(Site site) {
        return siteRepository.save(site);
    }
}
