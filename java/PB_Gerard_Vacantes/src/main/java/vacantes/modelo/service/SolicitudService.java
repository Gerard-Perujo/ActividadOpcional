package vacantes.modelo.service;

import java.util.List;

import vacantes.modelo.entidades.Solicitud;

public interface SolicitudService {

	Solicitud buscarUnaSolicitud(int idSolicitud);
	Solicitud insertarUnaSolicitud(Solicitud solicitud);
	Solicitud modificarUnaSolicitud(Solicitud solicitud);
	int eliminarUnaSolicitud(int idSolicitud);
	List<Solicitud> mostrarTodasSolicitud();
}
