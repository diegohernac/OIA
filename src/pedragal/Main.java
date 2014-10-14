package pedragal;

public class Main {

	public static void main(String[] args) {
		LeerArchivo archivoIn = new LeerArchivo("pedregal.in");
		try{
			String [] linea = archivoIn.readLine().split(" ");
			Terreno terreno = new Terreno(Integer.parseInt(linea[0]), Integer.parseInt(linea[1]));
			linea = archivoIn.readLine().split(" ");
			Casa casa = new Casa(Integer.parseInt(linea[0]), Integer.parseInt(linea[1]));
			Integer numeroDePeñascos = Integer.parseInt(archivoIn.readLine());
			for(int i=0; i<numeroDePeñascos; i++){
				linea = archivoIn.readLine().split(" ");
				Peñasco peñasco = new Peñasco(Integer.parseInt(linea[0]), Integer.parseInt(linea[1]));
				terreno.agregarPeñasco(peñasco);
			}
			EscribeArchivo archivoOut = new EscribeArchivo("pedregal.out");
			if(terreno.construirCasa(casa)){
				archivoOut.writeLine("SI");
				archivoOut.writeLine(casa.getUx() + " " + casa.getUy());
			}
			else{
				archivoOut.writeLine("NO");
			}
			archivoOut.cerrarArchivo();	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				archivoIn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
