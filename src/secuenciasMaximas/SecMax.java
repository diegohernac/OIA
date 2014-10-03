package secuenciasMaximas;

public class SecMax {
	private Integer nValores;
	private Integer contValidos=0, consecutivos=0, maxConsecutivos=0;
	public SecMax(String nombre){
		LeerArchivo archivo = new LeerArchivo(nombre);
		try{
			nValores = Integer.parseInt(archivo.readLine());
			
			for(int i=0; i< nValores; i++){
				Valores valor = new Valores(Integer.parseInt(archivo.readLine()));
				if(valor.esValido()){
					contValidos++;
					consecutivos++;
				}
				else{
					if(consecutivos>maxConsecutivos)
						maxConsecutivos=consecutivos;
					consecutivos=0;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			archivo.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void escribirConteo(String nombre){
		EscribeArchivo archivo = new EscribeArchivo(nombre);
		archivo.writeLine(contValidos.toString());
		archivo.writeLine(maxConsecutivos.toString());
		archivo.cerrarArchivo();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecMax secmax = new SecMax("secmax.in");
		secmax.escribirConteo("secmax.out");
	}

}
