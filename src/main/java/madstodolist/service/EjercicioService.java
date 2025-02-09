package madstodolist.service;

import madstodolist.model.Categoria;
import madstodolist.model.Ejercicio;
import madstodolist.repository.CategoriaRepository;
import madstodolist.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Ejercicio> obtenerTodos() {
        return (List<Ejercicio>) ejercicioRepository.findAll();
    }

    public Ejercicio guardar(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }
    // Método para insertar ejercicios desde JSON
    public void insertarEjercicios(List<Ejercicio> ejercicios) {
        for (Ejercicio ejercicio : ejercicios) {
            // Obtener la categoría de la base de datos
            Categoria categoria = categoriaRepository.findById(ejercicio.getCategoria().getId()).orElse(null);
            if (categoria != null) {
                ejercicio.setCategoria(categoria); // Asignar la categoría al ejercicio
                ejercicioRepository.save(ejercicio); // Guardar el ejercicio
            }
        }
    }
}
