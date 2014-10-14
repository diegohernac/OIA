package pedragal;

import java.util.ArrayList;
import java.util.Collections;

public class Peñasco implements Comparable<Peñasco>{
	private Integer dx, dy;
	
	public Peñasco(Integer dx, Integer dy){
		this.dx=dx;
		this.dy=dy;
	}
	
	public int compareTo(Peñasco peñasco){
		if(dx==peñasco.dx){
			if(dy<peñasco.dy)
				return -1;
			if(dy>peñasco.dy)
				return 1;
		}
		if(dx<peñasco.dx)
			return -1;
		if(dy>peñasco.dy)
			return 1;
		return 0;
	}
	
	public static void ordenar(ArrayList<Peñasco> peñascos){
		Collections.sort(peñascos);
	}

	public Integer getDx() {
		return dx;
	}

	public Integer getDy() {
		return dy;
	}
	
	public String toString(){
		return "(" + dx + ", " + dy + ")";
	}
}
