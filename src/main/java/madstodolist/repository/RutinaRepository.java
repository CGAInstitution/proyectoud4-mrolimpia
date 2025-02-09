package madstodolist.repository;

import madstodolist.model.Rutina;
import org.springframework.data.repository.CrudRepository;

public interface RutinaRepository extends CrudRepository<Rutina, Long> {
    // Métodos personalizados si los necesitas
}
