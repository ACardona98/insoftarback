package pruebas.insoftarback.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "USUARIO")
@Table(name = "USUARIO")
public class Usuario {
	@Id
	@Column(name = "ID_USUARIO")
	private Integer idUsuario;
	
	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "APELLIDOS")
	private String apellidos;
	
	@Column(name = "CEDULA")
	private String cedula;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "TELEFONO")
	private String telefono;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
