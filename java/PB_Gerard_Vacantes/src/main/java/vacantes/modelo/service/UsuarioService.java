package vacantes.modelo.service;

import java.util.List;

import vacantes.modelo.entidades.Usuario;

public interface UsuarioService {
	
	Usuario buscarUnUsuario(String username);
	Usuario ingresarUnUsuario(Usuario usuario);
	Usuario modificarUnUsuario(Usuario usuario);
	int eliminarUnUsuario(String username);
	List<Usuario> mostrarTodosUsuarios();

}
