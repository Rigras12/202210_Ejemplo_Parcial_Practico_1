package co.edu.uniandes.dse.parcialejemplo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uniandes.dse.parcialejemplo.dto.PacienteDetailDTO;
import co.edu.uniandes.dse.parcialejemplo.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialejemplo.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<PacienteDetailDTO> findAll() {
            List<PacienteEntity> pacientes= pacienteService.getPacientes();
            return modelMapper.map(pacientes, new TypeToken<List<PacienteDetailDTO>>() {
            }.getType());
    
	}
}
