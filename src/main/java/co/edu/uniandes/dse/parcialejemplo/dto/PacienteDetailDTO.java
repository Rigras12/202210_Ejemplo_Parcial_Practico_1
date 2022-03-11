package co.edu.uniandes.dse.parcialejemplo.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDetailDTO extends PacienteDTO{
	private List<MedicoDTO> medicosDtos = new ArrayList<>();
}
