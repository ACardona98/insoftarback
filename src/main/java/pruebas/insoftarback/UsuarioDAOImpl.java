package pruebas.insoftarback;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import pruebas.insoftarback.entidades.Respuesta;
import pruebas.insoftarback.entidades.Usuario;
import pruebas.insoftarback.util.CodigosRespuestas;
import pruebas.insoftarback.util.JPAUtils;

public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public List<Usuario> findAll() {
		EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();
		List<Usuario> usuarios = em.createNativeQuery("SELECT * FROM USUARIO", Usuario.class).getResultList();
		return usuarios;
	}

	@Override
	public Usuario findOne(int idUsuario) {
		EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("FROM USUARIO WHERE ID_USUARIO = ?1", Usuario.class);
		q.setParameter(1, idUsuario);
		Usuario usuario = (Usuario) q.getSingleResult();
		return usuario;
	}

	@Override
	public Respuesta save(Usuario usuario) {
		Respuesta r;
		
		EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();
		
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("SP_GUARDAR_USUARIO");
	    // set parameters
	    storedProcedure.registerStoredProcedureParameter("pIdUsuario", Integer.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("pNombres", String.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("pApellidos", String.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("pCedula", String.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("pCorreo", String.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("pTelefono", String.class, ParameterMode.IN);
	    storedProcedure.registerStoredProcedureParameter("respuesta", Integer.class, ParameterMode.OUT);
	    storedProcedure.setParameter("pIdUsuario", usuario.getIdUsuario());
	    storedProcedure.setParameter("pNombres", usuario.getNombres());
	    storedProcedure.setParameter("pApellidos", usuario.getApellidos());
	    storedProcedure.setParameter("pCedula", usuario.getCedula());
	    storedProcedure.setParameter("pCorreo", usuario.getCorreo());
	    storedProcedure.setParameter("pTelefono", usuario.getTelefono());
	    
	    Integer resp;
	    try{
	    	// execute stored procedure        
		    storedProcedure.execute();
	    	resp = (Integer)storedProcedure.getOutputParameterValue("respuesta");
	    
	    }catch(Exception e) {
	    	resp = CodigosRespuestas.ERR;
	    }
		em.close();
		
		switch (resp) {
		case CodigosRespuestas.OK:
			r = new Respuesta(CodigosRespuestas.OK, "Se ha guardado satisfactoriamente");
			break;
		default:
			r = new Respuesta(CodigosRespuestas.ERR, "El Correo o Cédula ya se encuentran registradas");
			break;
		}
		return r;
	}

	@Override
	public Respuesta delete(int idUsuario) {
		EntityManager em = JPAUtils.getEntityManagerFactory().createEntityManager();
		Respuesta r;
		try {
			em.getTransaction().begin();
			em.remove(em.merge(findOne(idUsuario)));
			em.getTransaction().commit();
			r = new Respuesta(CodigosRespuestas.OK, "Se ha eliminado el usuario cod: " + idUsuario);
		}catch(Exception e) {
			e.printStackTrace();
			r = new Respuesta(CodigosRespuestas.ERR, "Ha ocurrido un error"); 
		}
		return r;
	}
	
}
