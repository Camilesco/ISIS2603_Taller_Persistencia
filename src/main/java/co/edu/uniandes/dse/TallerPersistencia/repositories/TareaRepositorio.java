package co.edu.uniandes.dse.TallerPersistencia.repositories;

import co.edu.uniandes.dse.TallerPersistencia.entities.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositorio extends JpaRepository<TareaEntity,Long>
{
    List<TareaEntity> findByEstado(String Estado);
}
