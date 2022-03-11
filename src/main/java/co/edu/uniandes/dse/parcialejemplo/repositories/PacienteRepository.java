package co.edu.uniandes.dse.parcialejemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.parcialejemplo.entities.PacienteEntity;

public interface PacienteRepository extends JpaRepository<PacienteEntity,Long>{

}
