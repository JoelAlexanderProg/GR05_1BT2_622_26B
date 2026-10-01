package ec.edu.epn.objetos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

/**
 * Objeto encontrado en el campus. Cada instancia se guarda como una fila
 * de la tabla objeto_encontrado.
 */
@Entity
@Table(name = "objeto_encontrado")
public class ObjetoEncontrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String descripcion;

    @Column(nullable = false, length = 40)
    private String categoria;

    @Column(nullable = false, length = 100)
    private String lugar;

    @Column(nullable = false)
    private LocalDate fecha;

    // JPA exige un constructor sin argumentos
    protected ObjetoEncontrado() {
    }

    public ObjetoEncontrado(String descripcion, String categoria, String lugar, LocalDate fecha) {
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getLugar() {
        return lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
