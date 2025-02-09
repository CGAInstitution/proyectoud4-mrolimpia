package madstodolist.service;

import madstodolist.model.Rutina;
import madstodolist.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    public Iterable<Rutina> obtenerTodas() {
        return rutinaRepository.findAll();
    }

    public Optional<Rutina> obtenerPorId(Long id) {
        return rutinaRepository.findById(id);
    }

    public Rutina guardar(Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    public void eliminar(Long id) {
        rutinaRepository.deleteById(id);
    }
}
