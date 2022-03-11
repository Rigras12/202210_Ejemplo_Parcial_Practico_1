package co.edu.uniandes.dse.parcialejemplo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialejemplo.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialejemplo.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Transactional
	public List<PacienteEntity> getPacientes(){
		return pacienteRepository.findAll();
	}
	
}
