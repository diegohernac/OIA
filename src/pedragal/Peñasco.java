package pedragal;

import java.util.ArrayList;
import java.util.Collections;

public class Pe�asco implements Comparable<Pe�asco>{
	private Integer dx, dy;
	
	public Pe�asco(Integer dx, Integer dy){
		this.dx=dx;
		this.dy=dy;
	}
	
	public int compareTo(Pe�asco pe�asco){
		if(dx==pe�asco.dx){
			if(dy<pe�asco.dy)
				return -1;
			if(dy>pe�asco.dy)
				return 1;
		}
		if(dx<pe�asco.dx)
			return -1;
		if(dy>pe�asco.dy)
			return 1;
		return 0;
	}
	
	public static void ordenar(ArrayList<Pe�asco> pe�ascos){
		Collections.sort(pe�ascos);
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
