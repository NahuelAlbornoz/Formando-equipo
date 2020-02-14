package formando_equipo;
import java.util.ArrayList;

public class Afinidad {
	private int afinidad_max;
	private ArrayList <Character> patron;
	private int n_consecutivas;
	
	public Afinidad () {
		this.afinidad_max = 0;
		patron = new ArrayList<Character>();
	}
	public int getAfinidad_max() {
		return afinidad_max;
	}
	public void setAfinidad_max(int afinidad_max) {
		this.afinidad_max = afinidad_max;
	}
	public ArrayList<Character> getPatron() {
		return patron;
	}
	public void setPatron(ArrayList<Character> patron) {
		this.patron = patron;
	}
	public int getN_consecutivas() {
		return n_consecutivas;
	}
	public void setN_consecutivas(int n_consecutivas) {
		this.n_consecutivas = n_consecutivas;
	}
	public String toString() {
		return "Afinidad_max=" + afinidad_max + ", Patron=" + patron + ", N_consecutivas=" + n_consecutivas;
	}
	public void calcular(Colaborador [] colaboradores, int cant_colab, int cant_preg) {
		int cant = 0; // Cant colaboradores que coincidieron en responder de igual forma
		boolean band = false; // Se usa para iterar en el ciclo while
		int puntero = 0;
		
		while(band==false) {	
			for(int c=0; c<cant_colab; c++) {	
				cant = 1;
				for(int i=0; i<cant_colab; i++) { 
					if((i!=c)&&(colaboradores[c].getRespuestas().equals(colaboradores[i].getRespuestas()))) {
						cant++;
						band = true;
						this.n_consecutivas = colaboradores[i].getRespuestas().size();
						this.afinidad_max =  cant*(this.n_consecutivas*this.n_consecutivas);
						this.patron = colaboradores[c].getRespuestas();
					}
				}
			}
			if(band==false) {
				puntero++;
				for(int indice=0; indice<cant_colab; indice++) {
					colaboradores[indice].eliminarRespuesta(cant_preg, cant_preg-puntero);
				}	
			}
		}
	}
}