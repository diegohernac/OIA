package pedragal;

public class Terreno {
	private Peñasco[][] peñascos;
	private Integer dx,dy;
	
	public Terreno(Integer dx, Integer dy){
		peñascos = new Peñasco[dx][dy];
		this.dx=dx;
		this.dy=dy;
	}
	
	public void agregarPeñasco(Peñasco peñasco) throws Exception{
		if(dx>=peñasco.getDx() && dy>=peñasco.getDy())
			peñascos[peñasco.getDx()-1][peñasco.getDy()-1]=peñasco;
		else{
			throw (new Exception("El peñasco no se localiza en el terreno")); 
		}
	}
	
	public Boolean construirCasa(Casa casa){
		for(int i=0; i<dx; i++)
			for(int j=0; j<dy; j++){
				if(puedoConstruir(casa, i,j)){
					casa.ubicacion(i+1,j+1);
					return true;
				}	
				if(puedoConstruir(casa.rotar(), i,j)){
					casa.ubicacion(i+1, j+1);
					return true;
				}
			}
		return false;
	}
	
	private Boolean puedoConstruir(Casa casa, Integer x, Integer y){
		for(int i=x; i<=casa.getDx(); i++)
			for(int j=y; j<=casa.getDy(); j++)
				if(peñascos[i][j]!=null)
					return false;
		return true;
	}
	
}
