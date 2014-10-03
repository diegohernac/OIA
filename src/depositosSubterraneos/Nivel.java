package depositosSubterraneos;

import java.util.ArrayList;

public class Nivel {
	private ArrayList<Deposito> depositos; 
	private Integer profundidadInicio;
	private Integer profundidadFin;
	private Integer volumen;
	
	public Nivel(Integer profundidadInicio, Integer profundidadFin){
		this.profundidadInicio=profundidadInicio;
		this.profundidadFin=profundidadFin;
		depositos = new ArrayList<Deposito>();
		volumen=0;
	}

	public void agregarDeposito(Integer superficie){
		Deposito deposito = new Deposito(profundidadFin-profundidadInicio,superficie);
		depositos.add(deposito);
		volumen+=deposito.getVolumen();
	}
	
	public Integer getProfundidadFin() {
		return profundidadFin;
	}

	public Integer getVolumen() {
		return volumen;
	}
	
	public Integer size(){
		return depositos.size();
	}

	public ArrayList<Deposito> getDetositos() {
		return depositos;
	}

	
}