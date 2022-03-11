package co.edu.uniandes.dse.parcialejemplo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter 
@Setter
@Entity
public class MedicoEntity extends BaseEntity{
	
	private String name;
	private String apellido;
	private String registroMedico;
	private String especialidad;
	
	@PodamExclude
	@ManyToMany(mappedBy="medicos")
	private List<PacienteEntity> pacientes= new ArrayList<>();

}
