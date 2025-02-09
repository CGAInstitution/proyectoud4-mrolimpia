package madstodolist.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estudios")
public class Estudio implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String nombre;

    @Column (name = "enlace", nullable = false)
    private String enlace;

    @Column (name = "likes", nullable = false)
    private int likes;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
