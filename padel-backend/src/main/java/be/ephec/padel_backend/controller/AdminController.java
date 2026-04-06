package be.ephec.padel_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @GetMapping("/test")
    public ResponseEntity<String> testAdminAccess() {
        return ResponseEntity.ok("Accès admin autorisé");
    }
}