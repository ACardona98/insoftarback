package pruebas.insoftarback;

import java.util.List;

import pruebas.insoftarback.entidades.Respuesta;
import pruebas.insoftarback.entidades.Usuario;

public interface UsuarioDAO {
	List<Usuario> findAll();
	Usuario findOne(int idUsuario);
	Respuesta save(Usuario usuario);
	Respuesta delete(int idUsuario);
}
