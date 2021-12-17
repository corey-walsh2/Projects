import java.util.Random;

public class MonteCarlo{
   public static void main(String[] args){
      int i;								   
      int totalPoints = 0;						   
      int inCircle = 0;						    								     
      double x;
      double y;							   
     								     
      for (i = 1; i < 1100 ; i++){								   
         x = Math.random();      			   
         y = Math.random();						   						     
         totalPoints++;							   						     
         if ( x*x + y*y <= 1 ){		   
     	    inCircle++;		
         }
         if(i % 100 == 0){
            System.out.println("Points: " + totalPoints + ", in circle: " + inCircle + 
                                     ", area: " + ((double)inCircle/(double)totalPoints) * 4);
         }				   
      }								   
   }
}
