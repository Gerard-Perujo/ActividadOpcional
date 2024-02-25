package vacantes.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vacantes.modelo.entidades.Solicitud;
import vacantes.modelo.repository.SolicitudRepository;

@Service
public class SolicitudServiceImplMy8 implements SolicitudService{

	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Override
	public Solicitud buscarUnaSolicitud(int idSolicitud) {
		
		return solicitudRepository.findById(idSolicitud).orElse(null);
	}

	@Override
	public Solicitud insertarUnaSolicitud(Solicitud solicitud) {
		try {
			if(buscarUnaSolicitud(solicitud.getIdSolicitud()) == null) {
				return solicitudRepository.save(solicitud);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Solicitud modificarUnaSolicitud(Solicitud solicitud) {
		try {
			if(buscarUnaSolicitud(solicitud.getIdSolicitud()) != null) {
				return solicitudRepository.save(solicitud);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int eliminarUnaSolicitud(int idSolicitud) {
		Solicitud solicitud = buscarUnaSolicitud(idSolicitud);
		if(solicitud != null) {
			solicitudRepository.delete(solicitud);
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public List<Solicitud> mostrarTodasSolicitud() {
		
		return solicitudRepository.findAll();
	}

}
