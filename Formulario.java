package formando_equipo;

import java.util.ArrayList;

public class Formulario {
	private int cantpreg;
	private ArrayList<Character> respuestas;
	
	Formulario (int cantPreg) {
		this.cantpreg = cantPreg;
		this.respuestas = new ArrayList<Character> ();
	}
	public int getCantpreg() {
		return cantpreg;
	}
	public void setCantpreg(int cantpreg) {
		this.cantpreg = cantpreg;
	}
	public ArrayList<Character>getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<Character> respuestas) {
		this.respuestas = respuestas;
	}
	public String toString() {
		return "Cant_preguntas=" + cantpreg + ", respuestas="+ respuestas;
	}
	public ArrayList<Character> llenar(String rta) {
		for(int r=0; r<this.cantpreg; r++) {
			this.respuestas.add(r,rta.charAt(r));
		}
		return respuestas;
	}
}