package vacantes.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vacantes.modelo.entidades.Perfil;
import vacantes.modelo.repository.PerfilRepository;

@Service
public class PerfilServiceImplMy8 implements PerfilService{

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Override
	public Perfil buscarUnPerfil(int idPerfil) {

		return perfilRepository.findById(idPerfil).orElse(null);
	}

	@Override
	public Perfil insertarUnPerfil(Perfil perfil) {
		try {
			if(buscarUnPerfil(perfil.getIdPerfil()) == null) {
				return perfilRepository.save(perfil);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Perfil modificarUnPerfil(Perfil perfil) {
		try {
			if(buscarUnPerfil(perfil.getIdPerfil()) != null) {
				return perfilRepository.save(perfil);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int eliminarUnPerfil(int idPerfil) {
		Perfil perfil = buscarUnPerfil(idPerfil);
		if(perfil != null) {
			perfilRepository.delete(perfil);
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public List<Perfil> mostrarTodosPerfiles() {
	
		return perfilRepository.findAll();
	}

}
