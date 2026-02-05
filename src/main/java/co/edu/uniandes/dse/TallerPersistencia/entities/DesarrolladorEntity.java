package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

import java.util.List;

import jakarta.persistence.Entity;

public class DesarrolladorEntity extends BaseEntity{
    private String nombre;
    private String correo;
    @ManyToMany(mappedBy = "desarrolladores")
    private List <TareaEntity> tareas;
}
