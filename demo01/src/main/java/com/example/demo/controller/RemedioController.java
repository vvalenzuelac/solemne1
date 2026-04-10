package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RemedioEntity;
import com.example.demo.interfaces.IRemedioService;

@RestController
@RequestMapping("/api/v1/entities/remedio")
// http://localhost:6789/api/v1/entities/remedio
public class RemedioController {

    @Autowired
    private IRemedioService service;

    @GetMapping("/")
    public ResponseEntity<?> readRemedios() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readRemedioById(@PathVariable Long id) {
        try {
            if (service.findById(id) == null) {
                return ResponseEntity.status(404)
                        .body("Remedio no encontrado. ID: " + id + "\n");
            } else {
                return ResponseEntity.ok(service.findById(id));
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createRemedio(@RequestBody RemedioEntity remedioEntity) {
        try {
            RemedioEntity nuevo = service.save(remedioEntity);
            return ResponseEntity.ok().body(nuevo);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRemedio(@PathVariable Long id, @RequestBody RemedioEntity actualizado) {
        try {
            if (service.findById(id) == null) {
                return ResponseEntity.status(404)
                        .body("No se encontró remedio para actualizar. ID: " + id + "\n");
            } else {
                service.save(
                    RemedioEntity.builder()
                        .id(id)
                        .nombreCientifico(actualizado.getNombreCientifico())
                        .marca(actualizado.getMarca())
                        .gramos(actualizado.getGramos())
                        .anio(actualizado.getAnio())
                        .tipo(actualizado.getTipo())
                        .controlado(actualizado.isControlado())
                        .build()
                );
                return ResponseEntity.ok()
                        .body("Remedio actualizado con éxito. ID: " + id + "\n");
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok()
                    .body("Remedio eliminado con éxito. ID: " + id + "\n");
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("Error al eliminar el remedio ID = " + id + "\n" + e);
        }
    }
}