package vacantes.modelo.service;

import java.util.List;

import vacantes.modelo.entidades.Categoria;

public interface CategoriaService {

	Categoria buscarUnaCategoria(int idCategoria);
	Categoria insertarUnaCategoria(Categoria categoria);
	Categoria modificarUnaCategoria(Categoria categoria);
	int eliminarUnaCategoria(int idCategoria);
	List<Categoria> mostrarTodasCategorias();
}
