
public class main {

	/**
	 * 
	 */
	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//Fourmis.AfficherMatrice(Fourmis.InitDistance());
Fourmis.AfficherTable(Fourmis.InitPheromone());
//Fourmis.MajPheromone(0, 1);
//System.out.println("MAtrice apres maj");
		
System.out.println("*************************");
Fourmis.AfficherMatrice(Fourmis.matriceRepere);
System.out.println("*************************");

Fourmis.ChoixChemin(0);


		
	}

}
