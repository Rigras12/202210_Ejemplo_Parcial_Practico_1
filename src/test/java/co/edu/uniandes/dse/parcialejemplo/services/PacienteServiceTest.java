package co.edu.uniandes.dse.parcialejemplo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import co.edu.uniandes.dse.parcialejemplo.entities.PacienteEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(PacienteService.class)
public class PacienteServiceTest {
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private PodamFactory factory = new PodamFactoryImpl();
	private List<PacienteEntity> pacienteList = new ArrayList<>();
	
	void setUp() {
		clearData();
		insertData();
		
	}
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from PacienteEntity").executeUpdate();
	}
	private void insertData() {
		for(int i=0;i<3;i++){
			PacienteEntity pacienteEntity = factory.manufacturePojo(PacienteEntity.class);
			entityManager.persist(pacienteEntity);
			pacienteList.add(pacienteEntity);
		
		}
	}
	
	@Test
	void testGetPacientes() {
		List<PacienteEntity> list = pacienteService.getPacientes();

		assertEquals(pacienteList.size(), list.size());

		for (PacienteEntity entity : list) {
			boolean found = false;
			for (PacienteEntity storedEntity : pacienteList) {
				if (entity.getId().equals(storedEntity.getId())) {
					found = true;
				}
			}
			assertTrue(found);
			}
	}

}
