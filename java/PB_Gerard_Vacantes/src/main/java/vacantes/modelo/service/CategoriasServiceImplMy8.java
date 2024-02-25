package vacantes.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vacantes.modelo.entidades.Categoria;
import vacantes.modelo.repository.CategoriaRepository;

@Service
public class CategoriasServiceImplMy8 implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria buscarUnaCategoria(int idCategoria) {
	
		return categoriaRepository.findById(idCategoria).orElse(null);
	}

	@Override
	public Categoria insertarUnaCategoria(Categoria categoria) {
		try {
			if(buscarUnaCategoria(categoria.getIdCategoria()) == null) {
				return categoriaRepository.save(categoria);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Categoria modificarUnaCategoria(Categoria categoria) {
		try {
			if(buscarUnaCategoria(categoria.getIdCategoria()) != null) {
				return categoriaRepository.save(categoria);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int eliminarUnaCategoria(int idCategoria) {
		Categoria categoria = buscarUnaCategoria(idCategoria);
		if(categoria != null) {
			categoriaRepository.delete(categoria);
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public List<Categoria> mostrarTodasCategorias() {
		
		return categoriaRepository.findAll();
		}

}
