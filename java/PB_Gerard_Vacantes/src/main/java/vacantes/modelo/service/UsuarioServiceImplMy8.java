package vacantes.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vacantes.modelo.entidades.Usuario;
import vacantes.modelo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplMy8 implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario buscarUnUsuario(String username) {
		return usuarioRepository.findById(username).orElse(null);
	}

	@Override
	public Usuario ingresarUnUsuario(Usuario usuario) {
		try {
			if(buscarUnUsuario(usuario.getUsername()) == null) {
				return usuarioRepository.save(usuario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario modificarUnUsuario(Usuario usuario) {
		try {
			if(buscarUnUsuario(usuario.getUsername()) != null) {
				return usuarioRepository.save(usuario);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int eliminarUnUsuario(String username) {
		Usuario user = buscarUnUsuario(username);
		if(user != null) {
			usuarioRepository.delete(user);
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public List<Usuario> mostrarTodosUsuarios() {
		
		return usuarioRepository.findAll();
	}

}
