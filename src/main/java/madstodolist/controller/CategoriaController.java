package madstodolist.controller;

import madstodolist.model.Categoria;
import madstodolist.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Obtener todas las categorías
    @GetMapping
    public List<Categoria> obtenerTodas() {
        return categoriaService.obtenerTodas();
    }

    // Obtener una categoría por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.obtenerPorId(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria) {
        Categoria categoriaGuardada = categoriaService.guardar(categoria);
        return new ResponseEntity<>(categoriaGuardada, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria categoriaActualizada = categoriaService.actualizar(id, categoria);
        return categoriaActualizada != null ? ResponseEntity.ok(categoriaActualizada) : ResponseEntity.notFound().build();
    }

    // Eliminar una categoría por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    // Endpoint para insertar las categorías desde el JSON
    @PostMapping("/categorias")
    public ResponseEntity<String> insertarCategorias(@RequestBody List<Categoria> categorias) {
        categoriaService.insertarCategorias(categorias);
        return new ResponseEntity<>("Categorías insertadas exitosamente", HttpStatus.CREATED);
    }
}
