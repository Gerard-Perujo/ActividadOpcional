package vacantes.modelo.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vacantes.modelo.dto.VacanteDto;
import vacantes.modelo.entidades.EstatusVacante;
import vacantes.modelo.entidades.Usuario;
import vacantes.modelo.entidades.Vacante;
import vacantes.modelo.repository.VacanteRepository;
import vacantes.modelo.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vacantes")
public class VacanteRestController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private VacanteRepository vrepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@PostMapping("/")
	public ResponseEntity<?> alta(@RequestBody VacanteDto vacanteDto){
		vacanteDto.setEstatus(EstatusVacante.CREADA);
		Vacante vacante = new Vacante();
		modelMapper.map(vacanteDto, vacante);
		if (vrepo.save(vacante) != null) {
			vacanteDto.setIdVacante(vacante.getIdVacante());
			return ResponseEntity.status(201).body(vacanteDto);
		}else {
			String mensaje = "Alta NOOO realizada";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
		}
			
	}
	
	@GetMapping("/saludo/{username}")
	public ResponseEntity<Map<String, Object>> mostrarUsuariosaludo(@PathVariable("username") String username) {
	    
		Map<String, Object> response = new HashMap<>();
	    response.put("mensaje", "Hola pepe");
	    
	    Usuario user = usuarioService.buscarUnUsuario(username);
	    response.put("usuario", user);
	    
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
