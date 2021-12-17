import java.util.Random;
public class ConwayGameOfLifeFitness
{
   int bestFitness = 0;
   int[][] bestStarter;
   ConwayGameOfLife bestSolution;
   
   public ConwayGameOfLifeFitness(int playableBoard) 
   {
      super(playableBoard);
      bestSolution = new ConwayGameOfLife(playableBoard);
   }
    
   public int[][] create8x8()
   {
      Random rand = new Random();
      int[][] starter = new int[8][8];
      for (int i = 0; i < 8; i++)
      {
         for (int j = 0; j < 8; j++)
         {
            starter[i][j] = rand.nextInt(2);
         }
      }
      return starter;
   }
    
   public void drop8x8(int[][] starter)
   {
      if(starter[0].length!=8)
      {
         System.out.print("Error: Needs to be 8x8");
      }
      else
      {
         livecount = 0;
         for(int i = 0; i< board.length; i++)
         {
            for(int j = 0; j< board.length; j++)
            {
               if(i<12 || i>19 || j<12 || j>19)
               { 
                  board[i][j] = 0;
               }
               else 
               { 
                  board[i][j] = starter[i-12][j-12];
                  if(starter[i-12][i-12]==1)
                  {
                     livecount++;
                  }
               }
            }
         }
      }
   }
   
   public int getFitness(int[][] starter)
   {
      drop8x8(starter);
      ConwayGameOfLife solution = new ConwayGameOfLife(30);
      solution.mapToBoard(board);
      iterateGens(1000);
      return this.getLivecount();
   }
    
   public void optimizer(int runtimeInMillis)
   {
      long startTime = System.currentTimeMillis();
      int i = 0;
      while(System.currentTimeMillis()-startTime<runtimeInMillis)
      {
         int[][] thisStarter = create8x8();
         int thisFitness = getFitness(thisStarter);
         boolean bestSoFar = thisFitness>bestFitness;
         if (bestSoFar)
         {
            System.out.printf("New best fitness. it: %d is %d\n",i,thisFitness);
            bestFitness=thisFitness;
            bestStarter = thisStarter;
         }
         i++;
      }
      System.out.printf("\nThe best fitness was it: %d and it came from this starter:\n",bestFitness);
      print8x8Starter(bestStarter);
      System.out.println();
      print8x8StarterAsCompact(bestStarter);
   }
   
   public void print8x8Starter(int[][] starter)
   {
      for (int i=0; i<8; i++)
      {
         for (int j=0; j<8; j++)
         {
            System.out.print(starter[i][j]);
         }
         System.out.println();
      }
   }
   
   public void print8x8StarterAsCompact(int[][] starter)
   {
      String toCompact = "";
      for (int i = 0; i < 8; i ++)
      {
         for (int j = 0; j < 8; j ++)
         {
            toCompact = toCompact + starter[i][j];
            if (toCompact.length() == 4)
            {
               int binary = Integer.parseInt(toCompact, 2);
               String hex = Integer.toHexString(binary);
               System.out.print(hex);
               toCompact = "";
            }
         }
         System.out.println();
      }
   
   }
   public static void main(String[] args) throws Exception 
   {
      ConwayGameOfLifeFitness board = new ConwayGameOfLifeFitness(30);
      int[][] designOne =
         {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
         };
      int[][] designTwo =
         {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0},
                {0,1,1,1,0,0,0,0},
                {0,1,0,1,0,0,0,0},
                {0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
         };
   
      System.out.printf("Design One has a fitness of %d\n",board.getFitness(designOne));
      System.out.printf("Design Two has a fitness of %d\n\n",board.getFitness(designTwo));
      board.optimizer(7200000);
      }
        
      public class ConwayGameOfLife
      {
         int board[][];
         int nextBoard[][];
         int boardSize;
         int livecount;
         int playableBoard;
      
         ConwayGameOfLife(int gameBoard)
         {
            playableBoard = gameBoard;
            int livecount = 0;
            boardSize = playableBoard + 2;//handles dead border
            board = new int[boardSize][boardSize];
            nextBoard = new int[boardSize][boardSize];
         }
      
         private boolean aliveCheck(int i, int j)
         {
            return board[i][j] == 1;
         }
      
         private boolean borderCheck(int i, int j)
         {
            return i == boardSize - 1 || i == 0 || j == boardSize - 1 || j == 0;
         }
      //returns num of live neighbors
         private int liveNeighborCheck(int i, int j)
         {
            int liveNeighbors = 0;
            for(int a = i-1; a <= i+1;a++)
            {
               for(int b = j-1; b <= j+1;b++)
               {
                  if(aliveCheck(a,b) && !(i == a && j == b))
                  {
                     liveNeighbors++;
                  }
               }
            }
            return liveNeighbors;
         }
      //checks whether the cell will continue living
         private boolean lifeChecker(int i, int j)
         {
            if(borderCheck(i,j))
            {
               return false;
            }
            else
            {
               int neighbors = liveNeighborCheck(i,j);
               if(aliveCheck(i,j))
               {
                  return (neighbors == 2 || neighbors == 3);
               }
               else
               {
                  return liveNeighborCheck(i,j) == 3;
               }
            }
         }
      
         void mapToBoard(int gameBoard[][])
         {
            for(int i = 1; i < boardSize - 1;i++)
            {
               for(int j = 1; j < boardSize -1; j++)
               {
                  board[i][j] = gameBoard[i-1][j-1];
               }
            }
         }
      
         private void boardMapper(int next[][])
         {
            for(int i = 0; i < boardSize; i++)
            {  
               for(int j = 0;j < boardSize; j++)
               {
                  board[i][j] = next[i][j];
               }
            }
         }
      
         private void iterate()
         {
            livecount =0;
            for(int i = 0; i < boardSize; i++)
            {
               for(int j = 0; j < boardSize;j++)
               {
                  if(lifeChecker(i,j))
                  {
                     nextBoard[i][j] = 1;
                     livecount++;
                  }
                  else
                  {
                     nextBoard[i][j] = 0;
                  }
               }
            }
            boardMapper(nextBoard);
         }
      
         int getLivecount()
         { 
            return livecount; 
         }
      
         void iterateGens(int generations)
         {
            for (int i=0; i < generations; i++)
            {
               iterate();
            }
         }
      
         private void printBoard()
         {
            System.out.println("Printing current board:");
            for(int i = 1; i < boardSize - 1; i++)
            {
               for(int j = 1; j < boardSize -1; j++)
               {
                  if(aliveCheck(i,j))
                  {
                     System.out.print("*");
                  }
                  else
                  {
                     System.out.print(".");
                  }
               }
               System.out.println();
            }
         }
      
         private void printCompactBoard()
         {
            String compactConvert = "";
            for(int i = 0; i < boardSize; i++)
            {
               for(int j = 0; j < boardSize; j++)
               {
                  compactConvert = compactConvert + board[i][j];
                  if(compactConvert.length() == 4)
                  {
                     int binary = Integer.parseInt(compactConvert,2);
                     String hexadecimal = Integer.toHexString(binary);
                     System.out.print(hexadecimal);
                     compactConvert =  "";
                  }
               }
               System.out.println();
            }
         }
         
      }
   
 
   
}