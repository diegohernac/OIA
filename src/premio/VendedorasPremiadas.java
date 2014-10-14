package premio;

import java.util.ArrayList;

public class VendedorasPremiadas{
	private ArrayList<Vendedora> vendedoras;
	private Integer cantidadDeVendedoras;
	private Integer ventasConsecutivas;
	private static Boolean empate=false;
	
	public VendedorasPremiadas(String nombre){
		LeerArchivo archivoIn = new LeerArchivo(nombre);
		vendedoras = new ArrayList<Vendedora>();
		try{
			cantidadDeVendedoras=Integer.parseInt(archivoIn.readLine());
			for(int i=0; i<cantidadDeVendedoras; i++){
				Vendedora vendedora = new Vendedora();
				Integer cantidadDeVentas=Integer.parseInt(archivoIn.readLine());
				for(int j=0; j<cantidadDeVentas; j++){
					vendedora.agregarVenta(Integer.parseInt(archivoIn.readLine()));
				}
				vendedoras.add(vendedora);
			}
			ventasConsecutivas = Integer.parseInt(archivoIn.readLine());
			archivoIn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public VendedorasPremiadas(Integer cantidadDeVendedoras, Integer ventasConsecutivas){
		vendedoras = new ArrayList<Vendedora>();
		this.cantidadDeVendedoras=cantidadDeVendedoras;
		this.ventasConsecutivas=ventasConsecutivas;
	}
	
	public void agregarVendedora(Vendedora vendedora){
		vendedoras.add(vendedora);
	}
	
	public void BuscarGanadora(){		
		EscribeArchivo archivoOut = new EscribeArchivo("premio.out");
		for(int i=0; i<vendedoras.size(); i++)
			vendedoras.get(i).mayorMonto(ventasConsecutivas);
		Vendedora.ordenarPorMonto(vendedoras);
		if(vendedoras.get(vendedoras.size()-1).getMontoMejoresVentas()==0 && empate)
			archivoOut.writeLine("No se puede desempatar");
		else if(vendedoras.get(vendedoras.size()-1).getMontoMejoresVentas()==0){
			archivoOut.writeLine("No hay ganadoras");
		}else{
			ArrayList<Vendedora> ganadoras = new ArrayList<Vendedora>();
			Integer i = vendedoras.size()-1;
			Integer mayorMonto = vendedoras.get(i).getMontoMejoresVentas();
			while(i>=0 && mayorMonto==vendedoras.get(i).getMontoMejoresVentas()){
				ganadoras.add(vendedoras.get(i));
				i--;
			}
			if(ganadoras.size()==1){
				archivoOut.writeLine(ganadoras.get(ganadoras.size()-1).getNumeroDeVendedora().toString());
				archivoOut.writeLine(ventasConsecutivas + " " + ganadoras.get(ganadoras.size()-1).getMontoMejoresVentas());
			}
			else{
				VendedorasPremiadas desempate = new VendedorasPremiadas(ganadoras.size(), ventasConsecutivas+1);
				for(Vendedora vendedora: ganadoras)
					desempate.agregarVendedora(vendedora);
				empataron();
				desempate.BuscarGanadora();
			}
		}
		archivoOut.cerrarArchivo();
	}
	
	private static void empataron(){
		empate=true;
	}
	
	public String toString(){
		StringBuilder salida = new StringBuilder();
		for(int i=0; i<vendedoras.size(); i++)
			salida.append(vendedoras.get(i));
		return salida.toString();
	}

	
	public static void main(String[] args) {
		VendedorasPremiadas vendedoras = new VendedorasPremiadas("premio.in");
		vendedoras.BuscarGanadora();
	}

}
