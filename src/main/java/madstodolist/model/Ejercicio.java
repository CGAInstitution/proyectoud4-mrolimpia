package madstodolist.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ejercicios")
public class Ejercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false)
    private String nombre;

    @Column (name = "imagen", nullable = false)
    private String imagen;

    



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
