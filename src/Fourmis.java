

import java.util.LinkedList;

public class Fourmis  {
	static int  NbNoeud=7;
	static float[][] MatriceRepere= {     //{n1,n2,n3,n4,n5,n6,n7} Positionnnement  Au niveau des colonnes 
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
	static float[] TPheromone= {5,5,5,5,5,5,5};
	static LinkedList<Integer> parcours;
	
	

	static public int DeplacementAvant(int c) 
	{
		parcours= new LinkedList<Integer>();
		float somme=0;
	 	float phero=0;
	 	int l=0;
		 for(int i=0;i<NbNoeud;i++)
		 {	if(MatriceRepere[i][c]==1)
			 {somme+=TPheromone[i];}}
		 for(int i=0;i<NbNoeud;i++)
		 {
			 if(MatriceRepere[i][c]==1 && phero<TPheromone[i]/somme)
				 {
					 phero=TPheromone[i]/somme;
					 l=i;
				 }
			 else 
				 DeplacementArriere(c);
			 }
		 parcours.addLast(l);
		return l;
	}
	static public int DeplacementArriere(int c)
	 {
		parcours.removeLast();
		int t= (int)parcours.getLast();
		EvapPheromone(c);
	return t; 
	 }
 static public void MajPheromone(int c ) 
 {
	 int Cst = 1;
	 TPheromone[c]+=(Cst/parcours.size());
	  }
	static public void EvapPheromone(int c)
	{
		TPheromone[c]*=0.8;
	}
	static public void Deplacement()
	{
		for(int i=0;i<NbNoeud;i++)
		{	
			int x= DeplacementAvant(i);
			parcours.addLast(i);
			System.out.println("deplacement"+x);
			System.out.println("parcours"+parcours);
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
	// Affichage Tables 
	 static public void AfficherTable( float[] tab)
	 {
	     for(int i=0;i<tab.length; i++)
	     {       
	             System.out.print("\t"+ tab [i]);
	     }
	     System.out.print("\n");
	} 
	public Fourmis() {
		
	}
}
