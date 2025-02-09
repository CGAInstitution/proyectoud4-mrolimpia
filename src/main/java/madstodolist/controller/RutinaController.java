package madstodolist.controller;

import madstodolist.model.Rutina;
import madstodolist.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    // Convierte Iterable a List para la respuesta
    @GetMapping
    public List<Rutina> obtenerTodas() {
        List<Rutina> rutinas = new ArrayList<>();
        rutinaService.obtenerTodas().forEach(rutinas::add); // convierte Iterable a List
        return rutinas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rutina> obtenerPorId(@PathVariable Long id) {
        Optional<Rutina> rutina = rutinaService.obtenerPorId(id);
        return rutina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rutina> guardar(@RequestBody Rutina rutina) {
        Rutina rutinaGuardada = rutinaService.guardar(rutina);
        return new ResponseEntity<>(rutinaGuardada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Rutina> rutina = rutinaService.obtenerPorId(id);  // Verificar si existe
        if (rutina.isPresent()) {
            rutinaService.eliminar(id);
            return ResponseEntity.noContent().build();  // Código 204 cuando se elimina correctamente
        } else {
            return ResponseEntity.notFound().build();  // Código 404 si no se encuentra la rutina
        }
    }
}
