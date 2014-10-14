package premio;

import java.util.ArrayList;
import java.util.Collections;

public class Vendedora implements Comparable<Vendedora>{
	private static Integer cont=0;
	private Integer numeroDeVendedora;
	private Integer cantidadVentas;
	private ArrayList<Integer> ventas;
	private Integer montoMejoresVentas;
	
	public Vendedora(){
		cantidadVentas=0;
		ventas = new ArrayList<Integer>();
		numeroDeVendedora = contarVendedora();
	}
	
	public void agregarVenta(Integer monto){
		ventas.add(monto);
		cantidadVentas++;
	}
	
	public void mayorMonto (Integer ventasConsecutivas){
		Integer [] vConsecutivas = new Integer[ventasConsecutivas];
		montoMejoresVentas=0;
		for(int i=0; i<ventas.size(); i++){
			if(i<ventasConsecutivas-1){
				vConsecutivas[i%ventasConsecutivas]=ventas.get(i);
			}
			else{
				Integer montoParcial=0;
				vConsecutivas[i%ventasConsecutivas]=ventas.get(i);
				for(int j=0; j<vConsecutivas.length; j++){
					montoParcial+=vConsecutivas[j];
				}
				if(montoParcial>montoMejoresVentas)
					montoMejoresVentas=montoParcial;
			}
		}
	}
	
	public int compareTo(Vendedora vendedora){
		if(this.montoMejoresVentas<vendedora.montoMejoresVentas)
			return -1;
		if(this.montoMejoresVentas>vendedora.montoMejoresVentas)
			return 1;
		return 0;
	}
	
	public static void ordenarPorMonto(ArrayList<Vendedora> vendedoras){
		Collections.sort(vendedoras);
	}
	
	public Integer getNumeroDeVendedora() {
		return numeroDeVendedora;
	}
	
	
	public static Integer contarVendedora(){
		return ++cont;
	}

	public Integer getMontoMejoresVentas() {
		return montoMejoresVentas;
	}
	
	public String toString(){
		StringBuilder salida = new StringBuilder();
		salida.append("Vendedora: " + numeroDeVendedora + " ");
		salida.append("Ventas: ");
		for(int i=0; i<ventas.size(); i++){
			salida.append(ventas.get(i) + " ");
		}
		salida.append("Monto: " + montoMejoresVentas);
		return salida.toString();
	}
}
