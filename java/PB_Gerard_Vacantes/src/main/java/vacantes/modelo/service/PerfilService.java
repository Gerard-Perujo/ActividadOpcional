package vacantes.modelo.service;

import java.util.List;

import vacantes.modelo.entidades.Perfil;

public interface PerfilService {

	Perfil buscarUnPerfil(int idPerfil);
	Perfil insertarUnPerfil(Perfil perfil);
	Perfil modificarUnPerfil(Perfil perfil);
	int eliminarUnPerfil(int idPerfil);
	List<Perfil> mostrarTodosPerfiles();
}
