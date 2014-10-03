package depositosSubterraneos;

import java.util.ArrayList;


public class DepositosSubterraneos {
	private Integer cantDepositos;
	private ArrayList<Deposito> depositosSubterraneos;
	private ArrayList<Nivel> niveles;
	private Integer sumVolumenDepositos;
	private Integer volumenFluido;
	private Integer profundidadDesdeElSuelo;
	private Integer cantidadDeDepositosUtilizados;
	
	public DepositosSubterraneos(String nombre){
		LeerArchivo archivoIn = new LeerArchivo(nombre);
		sumVolumenDepositos=0;
		cantDepositos=0;
		try{
			Integer cantDepositos = Integer.parseInt(archivoIn.readLine());
			depositosSubterraneos = new ArrayList<Deposito>();
			for(int i=0; i<cantDepositos; i++){
				String [] datos = archivoIn.readLine().split(" ");
				agregarDeposito(new Deposito(Integer.parseInt(datos[0]) , Integer.parseInt(datos[1])));
			}
			
			volumenFluido=Integer.parseInt(archivoIn.readLine());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(archivoIn!=null)
				try {
					archivoIn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	
	public void agregarDeposito(Deposito deposito){
		depositosSubterraneos.add(deposito);
		cantDepositos++;
		sumVolumenDepositos+=deposito.getVolumen();
		calcularNiveles();
	}
	
	
	private void calcularNiveles() {
		niveles = new ArrayList<Nivel>();
		for(int i=depositosSubterraneos.size()-1; i>=0; i--){
			if(i==depositosSubterraneos.size()-1){
				Nivel nivel = new Nivel(0,depositosSubterraneos.get(i).getProfundidad());
				for(int j=i; j>=0; j--)
					nivel.agregarDeposito(depositosSubterraneos.get(j).getSupeficie());
				niveles.add(nivel);
			}
			else{
				Nivel nivel = new Nivel(depositosSubterraneos.get(i+1).getProfundidad(),depositosSubterraneos.get(i).getProfundidad());
				for(int j=i; j>=0; j--)
					nivel.agregarDeposito(depositosSubterraneos.get(j).getSupeficie());
				niveles.add(nivel);
			}
		}
	}
	
	public void llenarDepositos(){
		EscribeArchivo archivoOut = new EscribeArchivo("deposito.out");
		if(volumenFluido>sumVolumenDepositos)
			archivoOut.writeLine("Rebasan: " + (volumenFluido-sumVolumenDepositos));
		else{
			for(int i=niveles.size()-1; i>=0 && volumenFluido>0; i--){
				if(volumenFluido > niveles.get(i).getVolumen())
					volumenFluido-=niveles.get(i).getVolumen();
				else{
					Integer alturaDentroDelNivel = repartirFluido(niveles.get(i), volumenFluido);
					profundidadDesdeElSuelo=niveles.get(i).getProfundidadFin()-alturaDentroDelNivel;
					cantidadDeDepositosUtilizados=niveles.get(i).size();
					volumenFluido=0;
				}
			}
			
			archivoOut.writeLine(cantidadDeDepositosUtilizados.toString());
			archivoOut.writeLine(profundidadDesdeElSuelo.toString());
		}
		archivoOut.cerrarArchivo();
	}

	private Integer repartirFluido(Nivel nivel, Integer volumenFluido) {
		Integer altura=0; 
		while(volumenFluido>0){
			altura++;
			for(int i=0; i<nivel.size(); i++)
				volumenFluido-=nivel.getDetositos().get(i).getSupeficie();
		}
		
		return altura;
	}


	public static void main(String[] args) {
		DepositosSubterraneos depositosSubterraneos = new DepositosSubterraneos("depositos.in");
		depositosSubterraneos.llenarDepositos();
	}

}
