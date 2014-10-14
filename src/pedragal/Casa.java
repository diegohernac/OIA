package pedragal;

public class Casa {
	private Integer dx,dy;
	private Integer ux, uy;
	
	public Casa(Integer dx, Integer dy){
		this.dx=dx;
		this.dy=dy;
	}

	public Integer getDx() {
		return dx;
	}

	public Integer getDy() {
		return dy;
	}

	public Casa rotar() {
		return new Casa(this.dy, this.dx);
	}
	
	public void ubicacion(Integer x, Integer y){
		this.ux=x;
		this.uy=y;
	}

	public Integer getUx() {
		return ux;
	}

	public Integer getUy() {
		return uy;
	}	
}
