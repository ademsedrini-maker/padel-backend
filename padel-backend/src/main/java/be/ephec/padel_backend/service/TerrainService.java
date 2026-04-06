package be.ephec.padel_backend.service;

import be.ephec.padel_backend.model.Terrain;
import be.ephec.padel_backend.repository.TerrainRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TerrainService {

    private final TerrainRepository terrainRepository;

    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public Terrain getTerrainById(Long id) {
        return terrainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Terrain introuvable"));
    }

    public Terrain createTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);
    }
}
