package pruebas.insoftarback.entidades;

public class Respuesta {
	
	private int codigo;
	private String respuesta;
	
	public Respuesta() {
	}
	
	public Respuesta(int codigo, String respuesta) {
		this.codigo = codigo;
		this.respuesta = respuesta;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
