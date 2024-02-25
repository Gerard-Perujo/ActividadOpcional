package vacantes.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vacantes.modelo.entidades.Vacante;
import vacantes.modelo.repository.VacanteRepository;

@Service
public class VacanteServiceImplMy8 implements VacanteService{

	@Autowired
	private VacanteRepository vacanteRepository;
	
	@Override
	public Vacante buscarUnaVacante(int idVacante) {
	
		return vacanteRepository.findById(idVacante).orElse(null);
	}

	@Override
	public Vacante insertarUnaVacante(Vacante vacante) {
		try {
			if(buscarUnaVacante(vacante.getIdVacante()) == null) {
				return vacanteRepository.save(vacante);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Vacante modificarUnaVacante(Vacante vacante) {
		try {
			if(buscarUnaVacante(vacante.getIdVacante()) != null) {
				return vacanteRepository.save(vacante);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int eliminarUnaVacante(int idVacante) {
		Vacante vacante = buscarUnaVacante(idVacante);
		if(vacante != null) {
			vacanteRepository.delete(vacante);
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public List<Vacante> mostrarTodasVacantes() {
		
		return vacanteRepository.findAll();
	}

}
