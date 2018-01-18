import java.util.*;
import java.util.Vector;
public class Fourmis {

static float[] TPheromone ;
	//  static float[] tphero ={2,1,3,2,3,1,0};
	static float Cst = 1;
	static int NombrePheromones;
	static int NbNoeud=7;
	static int DistanceNb;
	  static int nbFourmis;		
	  static LinkedList historique;
	  static Vector<Integer> NodeNonVisted = new Vector<Integer>();

	  static float[][] matriceRepere= {     //{n1,n2,n3,n4,n5,n6,n7} Positionnnement  Au niveau des colonnes 
								/*n1*/{0, -1,1, 0, 0, 0, 0},
	  							/*n2*/{1, 0, 1, 0, 0, 0, 0},
	  							/*n3*/{1, 0, 0, 1, 1, 0, 0},
	  							/*n4*/{0, 0, 1, 0, 0,-1, 0},
	  							/*n5*/{0, 0, 1, 0, 0,-1, 0},
	  							/*n6*/{0, 0, 0, 1, 1, 0,-1},
	  							/*n7*/{0, 0, 0, 0, 0, 1, 0}};
	  static float[][] matriceDistances= {     //{n1,n2,n3,n4,n5,n6,n7} Positionnnement  Au niveau des colonnes
		/*n1*/{0, 1,1, 2, 2, 3, 4},
		/*n2*/{1, 0, 1, 0, 0, 0, 0},
		/*n3*/{1, 0, 0, 1, 1, 0, 0},
		/*n4*/{2, 0, 1, 0, 0,-1, 0},
		/*n5*/{2, 0, 1, 0, 0,-1, 0},
		/*n6*/{3, 0, 0, 1, 1, 0,-1},
		/*n7*/{4, 0, 0, 0, 0, 1, 0}};
  
	  static public float[][] InitDistance() {
	
	for(int i=0;i<NbNoeud;i++) {
		for(int j=0;j<NbNoeud;j++) {
	if(i!=j)
			matriceDistances[i][j]=DistanceNb;
	else 
		matriceDistances[i][j]=0;
		}
	}
  return matriceDistances;
  }
	  static public void InputNbNoeud()
  {
      Scanner sc = new Scanner(System.in);
      System.out.println("Veuillez saisir le nombre de Noeud : ");
      NbNoeud = sc.nextInt();
  }
	  static public void InputDistance()
  {
      Scanner sc = new Scanner(System.in);
      System.out.println("Veuillez saisir la distance souhaite : ");
	      DistanceNb = sc.nextInt();
	  }
//****************
	  static public void MajPheromone(int c)
	  {
		for(int j=0;j<NbNoeud;j++)
			if(matriceRepere[j][c]==1)
				TPheromone[c]+=(Cst/matriceDistances[j][c]);
	  }
	static public void EvapPheromone(int c)
	{
		TPheromone[c]*=0.8;
	}
//****************
	public static float[] InitPheromone() 
	{

		TPheromone=new float[NbNoeud];
	      Scanner pheromones = new Scanner(System.in);
	      System.out.println("Veuillez saisir le nombre de Pheromones Initiale:");
	      NombrePheromones = pheromones.nextInt();
	      for(int i=0; i<NbNoeud; i++)
 
          {
              TPheromone[i] = NombrePheromones;
          
          }
	      return TPheromone;
	}
	static public void InputNbFourmis()
	{
      Scanner sc = new Scanner(System.in);
      System.out.println("Veuillez saisir le nombre de Fourmis :");
      nbFourmis = sc.nextInt();
	}
 //************************************************************
//************************************************************
	static public int deplacementavant(int c)
	{
	float somme=0;
 	float phero=0;
 	int n,l=0;

	 for(int i=0;i<NbNoeud;i++)
	 {
		 if(matriceRepere[i][c]==1)
		 {
			 somme+=TPheromone[i];
		 }
	 }
	 for(int i=0;i<NbNoeud;i++)
	 {
		 if(matriceRepere[i][c]==1) {
			 if(phero<TPheromone[i]/somme)
			 {
				 phero=TPheromone[i]/somme;
				 l=i;
			 }	
		 }
	 }
	 historique.addLast(l);
	 if(somme==0 && phero==0)
	 {
		 c=deplacementarriere(c);
		 n=deplacementavant(c);
	 }
	 
	 System.out.println("l ==="+l);

	 return l;	  
	}
 static public int deplacementarriere(int c)
	 {
		c= (int)historique.getLast();
		
	return c;	  
	 }
//************************************************************
//************************************************************
 static public void  CreateNodeNonVisited() {
	 NodeNonVisted.clear();
	 	for(int i=0;i<NbNoeud;i++) {
	 		NodeNonVisted.add(i);
	 	}

 }
 //Affichage  Matrices 
 static public void AfficherMatrice( float[][] matrice)
  {
      for(int i=0;i<matrice.length; i++)
      {
          for(int j=0;j<matrice[i].length;j++)
          {
              System.out.print("\t"+ matrice [i][j]);
      }
      System.out.print("\n");
	      }
	  }
 static public void AfficherTable( float[] tab)
 {
     for(int i=0;i<tab.length; i++)
     {
         
         
             System.out.print("\t"+ tab [i]);
     }
     System.out.print("\n");
	      }
	  
	public Fourmis() 
	{}
	public void matriceDistances()
	{}

}
