package caosEnLaEnvasadoradeLatas;

public class Envasadora {
	Integer cantidadDeLatas;
	Integer primeraSecuanciaMasLarga;
	Integer segundaSecuanciaMasLarga;
	Integer distanciaEntreAmbas;
	
	public Envasadora(){
		cantidadDeLatas=0;
		primeraSecuanciaMasLarga=0;
		segundaSecuanciaMasLarga=0;
		distanciaEntreAmbas=0;
	}
	
	public void procesarLatas(String nombre){
		LeerArchivo archivoIn = new LeerArchivo(nombre);
		try{
			String [] latas = archivoIn.readLine().split(" ");
			
			
			cantidadDeLatas=latas.length;
			Integer secuencia=0;
			Integer posicion=0, posPrimeraMasLarga=0, posSegundaMasLarga=0;
			for(int i=0; i<cantidadDeLatas; i++){
				if(latas[i].equals("G")){
					if(secuencia==0)
						posicion=i;
					secuencia++;
				}
				else{
					if(secuencia>primeraSecuanciaMasLarga){
						segundaSecuanciaMasLarga=primeraSecuanciaMasLarga;
						posSegundaMasLarga=posPrimeraMasLarga;
						primeraSecuanciaMasLarga=secuencia;
						posPrimeraMasLarga=posicion;
					}
					else if(secuencia>segundaSecuanciaMasLarga){
						segundaSecuanciaMasLarga=secuencia;
						posSegundaMasLarga=posicion;
					}
					secuencia=0;
				}
			}
			if(posPrimeraMasLarga>posSegundaMasLarga)
				distanciaEntreAmbas=posPrimeraMasLarga-posSegundaMasLarga-segundaSecuanciaMasLarga;
			if(posPrimeraMasLarga<posSegundaMasLarga)
				distanciaEntreAmbas=posSegundaMasLarga-posPrimeraMasLarga-primeraSecuanciaMasLarga;
			EscribeArchivo archivoOut = new EscribeArchivo("latas.out");
			archivoOut.writeLine(cantidadDeLatas.toString());
			archivoOut.writeLine(primeraSecuanciaMasLarga.toString());
			archivoOut.writeLine(segundaSecuanciaMasLarga.toString());
			archivoOut.writeLine(distanciaEntreAmbas.toString());
			archivoOut.cerrarArchivo();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(archivoIn!=null){
				try{
					archivoIn.close();
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Envasadora envasadora = new Envasadora();
		envasadora.procesarLatas("latas.in");
	}
}
