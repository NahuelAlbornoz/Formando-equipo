package formando_equipo;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = null;
		PrintWriter pr = null;
		try {
			double tiempo_inic = System.currentTimeMillis();
			sc = new Scanner(new File("equipo4.in"));
			
			int cantPreg = sc.nextInt();
			int cantColab = sc.nextInt();
			
			Colaborador [] colaboradores = new Colaborador[cantColab];
			Formulario [] formularios = new Formulario [cantColab];
			
			if((cantPreg>=1)&&(cantPreg<=500)&&(cantColab>=2)&&(cantColab<=5000)) {
				
				for(int c=0; c<cantColab; c++) {
					String rta = sc.next();
					formularios[c] = new Formulario(cantPreg);
					colaboradores[c] = new Colaborador(c+1, formularios[c].llenar(rta));
				}
				
				Afinidad a1 = new Afinidad();
				a1.calcular(colaboradores, cantColab, cantPreg);
				pr = new PrintWriter(new File("equipo.out"));
				if(a1.getN_consecutivas()>=2) {
					pr.println(a1.getAfinidad_max());
					for(int i=0; i<a1.getN_consecutivas(); i++) {
						pr.print(a1.getPatron().get(i));
					}
				}
				else 
					pr.println(0);
				double tiempo_final = System.currentTimeMillis();
				double tiempo_rta = tiempo_final - tiempo_inic;
				System.out.println("Tiempo de respuesta ="+tiempo_rta+"ms");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			sc.close();
			pr.close();
		}
	}
}