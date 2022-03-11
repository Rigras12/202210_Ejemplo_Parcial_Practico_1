package co.edu.uniandes.dse.parcialejemplo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class PacienteEntity extends BaseEntity{
	private String nombre;
	private String apellido;
	
	@PodamExclude
	@ManyToMany
	private List<MedicoEntity> medicos=new ArrayList<>();
	
	
}
