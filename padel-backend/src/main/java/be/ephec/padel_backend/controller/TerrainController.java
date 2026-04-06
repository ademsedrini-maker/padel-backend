package be.ephec.padel_backend.controller;

import be.ephec.padel_backend.model.Terrain;
import be.ephec.padel_backend.repository.TerrainRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/terrains")
@CrossOrigin(origins = "*")
public class TerrainController {

    private final TerrainRepository terrainRepository;

    public TerrainController(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    @GetMapping
    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Terrain> createTerrain(@RequestBody Terrain terrain) {
        return ResponseEntity.ok(terrainRepository.save(terrain));
    }
}
