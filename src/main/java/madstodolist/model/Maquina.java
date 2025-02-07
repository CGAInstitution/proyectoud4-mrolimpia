package madstodolist.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "maquinas")
public class Maquina implements Serializable {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

}
