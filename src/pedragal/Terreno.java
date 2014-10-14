package pedragal;

public class Terreno {
	private Pe�asco[][] pe�ascos;
	private Integer dx,dy;
	
	public Terreno(Integer dx, Integer dy){
		pe�ascos = new Pe�asco[dx][dy];
		this.dx=dx;
		this.dy=dy;
	}
	
	public void agregarPe�asco(Pe�asco pe�asco) throws Exception{
		if(dx>=pe�asco.getDx() && dy>=pe�asco.getDy())
			pe�ascos[pe�asco.getDx()-1][pe�asco.getDy()-1]=pe�asco;
		else{
			throw (new Exception("El pe�asco no se localiza en el terreno")); 
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
				if(pe�ascos[i][j]!=null)
					return false;
		return true;
	}
	
}
