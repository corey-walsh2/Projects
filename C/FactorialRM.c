/*
Program By: Corey Walsh
Collaborated with: David
*/
#include <stdio.h>
int factorial(int n);
void DumpS(int n);

int main()  {
   int n, f;
   printf("Enter an integer:");
   scanf("%d",&n);
   DumpS(64);
   f = factorial(n);
   DumpS(64);
   printf("%d! is %d\n",n,f);
  
   //Recursive stack on array of size 7
   int arr[] = {1, 2, 3, 4, 5, 6, 7};
   int loc;
   //enter int to search for
   printf("Enter an integer: ");
   scanf("%d",&loc);
   // recursive method call
   int index = indexOf(arr, 6, loc, 0); 
   //Return -1 if not found
   if(index == -1){          
      printf("Null value"); 
      DumpS(64); 
   }
   else{
      printf("%d is located at: %d", loc, index);
      DumpS(64);
   }

   
}

/* Functional subprogram that returns the index of the first occurrence of the
given target value in the slice of the given array defined by (startingIndex <=
index < length). In the event the target value is not found then -1 is returned.
*/
int indexOf( int *array, int length, int target, int startingIndex){
   if(array[length] == target){ // detect if pointer is at end
      return length;
   }
   else{
      if(length == startingIndex){ // detect if pointer is on starting index
         return -1;
      }
   }
   if(length > startingIndex){ // recursively move pointer
      indexOf(array, length - 1, target, startingIndex);
   }
}