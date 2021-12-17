public class ConwaysGameOfLife2{ 
    public static void main(String[] args){ 
        int M = 8; 
        int N = 8; 
        //Matrix to input the playing field, input is in beacon form so:  
        int[][] curr = {           
            { 0, 0, 0, 0, 0, 0, 0, 0 },                       
            { 0, 0, 0, 0, 0, 0, 0, 0 },                        
            { 0, 0, 1, 1, 0, 0, 0, 0 },                        
            { 0, 0, 1, 1, 0, 0, 0, 0 },                       
            { 0, 0, 0, 0, 1, 1, 0, 0 },                            
            { 0, 0, 0, 0, 1, 1, 0, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 0 }       
        }; 
  
        System.out.println(); 
        dumpTwo(curr, M, N); 
    } 
  
    static void dumpTwo(int curr[][], int M, int N){ 
        int[][] next = new int[M][N]; 
        int totalCells = 0;
        for(int p = 1; p < 1000; p++){
        
        for(int l = 1; l < M - 1; l++) { 
            for(int m = 1; m < N - 1; m++) { 
                int liveCells = 0; 
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){ 
                        liveCells += curr[l + i][m + j]; 
                    }
                } 
                liveCells -= curr[l][m];  
                    next[l][m] = 0; 
                if((curr[l][m] == 1) && (liveCells < 2)){
                    next[l][m] = 0;
                }
                else if((curr[l][m] == 1) && (liveCells > 3)){
                    next[l][m] = 0; 
                }
                else if((curr[l][m] == 0) && (liveCells == 3)){
                    next[l][m] = 1; 
                }
                else{
                    next[l][m] = curr[l][m]; 
                }
                totalCells = totalCells + liveCells;
               

            } 
        } 
        }
        System.out.println("Live Cells: " + totalCells);
      
        //Print second iteration (Second Dump)
        for (int i = 0; i < M; i++){ 
            for (int j = 0; j < N; j++){ 
                if (next[i][j] == 0){
                    System.out.print("."); 
                }
                else{
                    System.out.print("*");
                } 
            } 
            System.out.println(); 
        } 
      
    } 
} 