package formando_equipo;

import java.util.ArrayList;

public class Colaborador {
	private int numero; // Numero de colaborador
	private ArrayList<Character> respuestas; // Respuestas del Formulario
	
	public Colaborador(int numCol, ArrayList<Character> rtas) {
		this.respuestas = new ArrayList<Character>();
		this.numero = numCol;
		this.respuestas = rtas;
	}
	public ArrayList<Character> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<Character> respuestas) {
		this.respuestas = respuestas;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String toString() {
		return "Numero=" + numero + ", respuestas=" + respuestas;
	}
	public void eliminarRespuesta(int cant_preg, int indice) {
		for(int i=0; i<this.respuestas.size(); i++) {
			if(indice==i) {
				this.respuestas.remove(indice);
				break;
			}
		}
	}
}