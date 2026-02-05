package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import jakarta.persistence.Entity;


@Entity
public class TareaEntity extends BaseEntity {

    private String titulo;
    private EstadoTarea estado;
    private Integer DuracionEstimada;

    @ManyToOne
    private ProyectoEntity proyecto;

    @ManyToMany
    private DesarrolladorEntity desarrolladores;
}
