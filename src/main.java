
import java.util.LinkedList;

public class main {
	static LinkedList L;

	/**
	 * 
	 */
	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//Fourmis.AfficherMatrice(Fourmis.InitDistance());
//Fourmis.AfficherTable(Fourmis.InitPheromone());
//Fourmis.MajPheromone(0, 1);
//System.out.println("MAtrice apres maj");
		
System.out.println("*************************");
Fourmis.AfficherMatrice(Fourmis.MatriceRepere);
System.out.println("*************************");

Fourmis.Deplacement();
 L=Fourmis.parcours;
 System.out.println("*************************");
 System.out.println("*************************");
 System.out.println("parcours"+L);

		
	}

}
