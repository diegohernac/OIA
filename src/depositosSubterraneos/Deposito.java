package depositosSubterraneos;

public class Deposito {
	private Integer superficie;
	private Integer profundidad;
	private Integer volumen;
	
	public Deposito(){
		this(0,0);
		volumen=0;
	}
	
	public Deposito(Integer superficie, Integer profundidad){
		this.profundidad=profundidad;
		this.superficie=superficie;
		volumen=profundidad*superficie;
	}
	
	public Integer getVolumen(){
		return volumen;
	}
	
	
}
