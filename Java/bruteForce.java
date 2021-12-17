import java.util.Random;

public class bruteForce{ 
   Random r;
   Integer cntr = 0;
   
   public static void main(String[] args){ 
      bruteForce conways = new bruteForce();
      conways.runOptimizer(2);
   }
   
   public bruteForce(){
      r = new Random();
   }
   
   public void runOptimizer(double hours){ 
      System.out.println("Runtime: " + hours + " hours");
      long startTime = System.currentTimeMillis();
      conways c = new conways(32,32); 
      c.condense(32,32);
      c.input("00000000,00000000,00000000,00000000,11111111,00000000,00000000,00000000");
      System.out.println("Fitness of first design: " + c.maxFit());
      c.input("00000000,00000000,00100000,01110000,0101000,00100000,00000000,00000000");
      System.out.println("Fitness of second design: " + c.maxFit());
      System.out.println();
      while(false || (System.currentTimeMillis() - startTime) < ((hours) * 3600000)){
         conways current = new conways(32,32);
         String convertedInput = "";
         
         for(int j = 0; j < 8; j++){
            String hex1 = Integer.toHexString(r.nextInt(16));
            String hex2 = Integer.toHexString(r.nextInt(16)); 
            convertedInput = convertedInput + hex1 + hex2 + ",";
         }
         current.condense(8,8);
         current.input(convertedInput);
         if(current.maxFit() > c.maxFit()){
            c = current;
            System.out.println("iteration: " + cntr + ", fitness: " + c.maxFit());
         }
         cntr++;
         System.gc();
      }
      
      System.out.println("Best compact form: " + c.prevInput + " Best user friendly: ");
      String savePattern = c.prevInput; 
      c.reset();
      c.condense(8,8);
      c.input(savePattern);
      System.out.println();
      for(int i = 0; i < 1000; i++){
         c.next();
      }
      c.dumpMatrix();     
   }
   
   public class conways{
      Boolean[][] loc;
      Boolean[][] originalInput;
      String prevInput;
      boolean condensing = false;
      Integer row;
      Integer column;
      double storeFit = -1;
      Integer length; 
      Integer width;
      
      public conways(Integer length, Integer width){ 
         loc = new Boolean[length][width];
         for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
               loc[i][j] = new Boolean(false);
            }
         }
      }
         
      public void reset(){
         if(loc == null){
            loc = new Boolean[length][width];
         }
         for(int y = 0; y < loc.length; y++){
            for(int x = 0; x < loc[y].length; x++){
               loc[x][y] = new Boolean(false);
            }
         }
         storeFit = -1;
      }
         
      public Boolean[][] condense(int newLength, int newWidth){
         condensing = true;
         row = (loc.length / 2) - (newLength / 2);
         column = (loc[0].length / 2) - (newWidth / 2);
         Boolean[][] newArr = new Boolean[newLength][newWidth]; 
         for(int y = 0; y < loc.length; y++){
            for(int x = 0; x < loc[0].length; x++){
               if(column <= x && (column + newWidth) > x && row <= y && (row + newLength) > y){
                  newArr[x - column][y - row] = new Boolean(false);
                  newArr[x - column][y - row] = loc[x][y];
               }
            }
         }
         return newArr;
      }
         
      public double maxFit(){
         storeFit = fitness(originalInput, 1000);
         return Math.round(storeFit);
      }
         
      public double fitness(Boolean[][] fitArray, int numIter){
         double becomeLive = fitCntr(fitArray);
         for(int i = 1; i < numIter; i++){
            next();
         }
         double kill = fitCntr(condense(fitArray.length, fitArray[0].length));
         return (kill / (2 * becomeLive));
      }
         
      public double fitCntr(Boolean[][] cntArr){
         double cntr = 0;
         for(int i = 0; i < cntArr.length; i++){
            for(int j = 0; j < cntArr[0].length; j++){
               if(cntArr[i][j]){
                  cntr++;               
               }
            }
         }
         return cntr;
      }
         
      public void input(String pattern){
         Integer tmp = column;
         prevInput = pattern;
         for(int i = 0; i < pattern.length(); i++){
            Integer input = Character.getNumericValue(pattern.charAt(i));
            if(input == -1 ){
               row++; 
               column = tmp;
            }
            else if(input != 0){
               convInput(input, (i * 4));
            }
         }
         row++;
         originalInput = loc;
      }
         
      public void convInput(Integer input, Integer widthPos){
         Integer currInput = input;
         Integer currX = widthPos;
         if(condensing){
            currX = column;
            column = column + 4;
         }
         if((currInput / 8) > 0){
            loc[row][currX] = true;
            currInput = currInput - 8;
         }
         if((currInput / 4) > 0){
            loc[row][currX + 1] = true;
            currInput = currInput - 4;
         }
         if((currInput / 2) > 0){
            loc[row][currX + 2] = true;
            currInput = currInput - 2;
         }
         if((currInput / 1) > 0){
            loc[row][currX + 3] = true;
         }    
      }
              
      public void dumpMatrix(){
         for(int i = 0; i < loc.length; i++){
            for(int j = 0; j < loc[0].length; j++){
               if(loc[i][j]){
                  System.out.print("*");
               }
               else{
                  System.out.print(".");
               }
            }
            System.out.println();
         }

      }
         
      public boolean checkNeighbors(Boolean currCell, Integer y, Integer x){
         Integer liveCells = 0;
         boolean alive = false;
         if(loc[y + 1][x]) liveCells++;
         if(loc[y + 1][x + 1]) liveCells++;
         if(loc[y][x + 1]) liveCells++;
         if(loc[y - 1][x + 1]) liveCells++;
         if(loc[y - 1][x]) liveCells++;
         if(loc[y - 1][x - 1]) liveCells++;
         if(loc[y][x - 1]) liveCells++;
         if(loc[y + 1][x - 1]) liveCells++;
         if(currCell) {
            if(liveCells > 1 && 4 > liveCells){
               alive = true;
            }
         }
         else{
            if(liveCells == 3){
               alive = true;
            }  
         }
         return alive;      
      }
         
      public void next(){
         Boolean[][] temp = new Boolean[loc.length][loc[0].length];
         for(int i = 0; i < loc.length; i++){
            for(int j = 0; j < loc[0].length; j++){
               temp[i][j] = new Boolean(false);
            }
         }
         for(int y = 1; y < (loc.length - 1); y++){
            for(int x = 1; x < (loc[0].length - 1); x++){
               temp[y][x] = checkNeighbors(loc[y][x], y, x);
            }
         }
         loc = temp;
      }
   }
}