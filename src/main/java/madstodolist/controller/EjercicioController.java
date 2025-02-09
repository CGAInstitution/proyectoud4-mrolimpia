package madstodolist.controller;

import madstodolist.model.Ejercicio;
import madstodolist.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping
    public List<Ejercicio> obtenerTodos() {
        return ejercicioService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Ejercicio> guardar(@RequestBody Ejercicio ejercicio) {
        Ejercicio ejercicioGuardado = ejercicioService.guardar(ejercicio);
        return new ResponseEntity<>(ejercicioGuardado, HttpStatus.CREATED);
    }

    // Endpoint para insertar los ejercicios desde el JSON
    @PostMapping("/ejercicios")
    public ResponseEntity<String> insertarEjercicios(@RequestBody List<Ejercicio> ejercicios) {
        ejercicioService.insertarEjercicios(ejercicios);
        return new ResponseEntity<>("Ejercicios insertados exitosamente", HttpStatus.CREATED);
    }
}
