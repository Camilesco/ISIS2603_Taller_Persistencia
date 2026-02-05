package co.edu.uniandes.dse.TallerPersistencia.entities;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

@Entity
public class ProyectoEntity extends BaseEntity{
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "proyecto",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<TareaEntity> tareas;


}
