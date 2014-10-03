package secuenciasMaximas;

public class Valores {
	private int valor;
	
	public Valores(Integer valor){
		this.valor=valor;
	}
	
	public Boolean esValido(){
		return (valor%5!=0 && valor%3!=0 && valor%2!=0);
	}
}
