package vacantes.modelo.service;

import java.util.List;

import vacantes.modelo.entidades.Vacante;

public interface VacanteService {

	Vacante buscarUnaVacante(int idVacante);
	Vacante insertarUnaVacante(Vacante vacante);
	Vacante modificarUnaVacante(Vacante vacante);
	int eliminarUnaVacante(int idVacante);
	List<Vacante> mostrarTodasVacantes();
}
