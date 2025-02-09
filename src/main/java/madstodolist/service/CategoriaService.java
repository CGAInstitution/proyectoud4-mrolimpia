package madstodolist.service;

import madstodolist.model.Categoria;
import madstodolist.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<Categoria> obtenerPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Guardar una nueva categoría
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Eliminar una categoría por su ID
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Actualizar una categoría
    public Categoria actualizar(Long id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            categoria.setId(id);
            return categoriaRepository.save(categoria);
        }
        return null; // Retornar null si no existe la categoría
    }

    // Metodo para insertar categorías desde JSON
    public void insertarCategorias(List<Categoria> categorias) {
        categoriaRepository.saveAll(categorias);
    }
}
