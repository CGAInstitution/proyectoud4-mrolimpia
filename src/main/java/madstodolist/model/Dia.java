package madstodolist.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dias")
public class Dia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false)
    private String nombre;

}
