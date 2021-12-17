#include <stdio.h>  
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <string.h>

/*

author: Corey R Walsh.
progam status: Works.

*/

struct JOB {
   char programName[25]; // domain = { [a-zA-Z][a-zA-Z0-9_\.]* }
   int startTime;        // domain = { positive integer }
   int submissionTime;    // domain = { positive integer }
   struct JOB *next;
};
typedef struct JOB Job;

struct HEADER {
   long progStartTime;
   int numOfJobs;
   struct JOB *firstJob;
};
typedef struct HEADER Header;

//declare function prototypes.
void append(Header *headerPtr, Job *jobPtr);
Job *delete(Header *headerPtr);
void print(Header *headerPtr);

int main(){
   Header header;
   header.firstJob = NULL;
   header.numOfJobs = 0;
   header.progStartTime = 0;

   Job job;
   job.programName[25];
   job.startTime = 0;
   job.submissionTime =0;
   Job *next = NULL;
   Job *newJob = NULL;

   char cmd[2];
   char plus[2] = "+";
   char min[2] = "-";
   char exc[2] = "!";
  
   //input
   printf("enter start time: ");
   scanf("%d", &header.progStartTime);
   printf("\nprogram start time:%d\n ", header.progStartTime);
   printf("enter a command!(!,+,-)\n");
   scanf("%s", cmd);
   //loop to run until '!' is entered.
   while(cmd[0] != '!'){
      scanf("%s%d%d", job.programName,job.startTime, job.submissionTime);
      scanf("%s", cmd);
      printf("program name:%s\n",job.programName);
      printf("start time:%s\n", job.startTime);
      printf("submision time:%d\n", job.submissionTime);
      //if cmd = '+' 
      if(strcmp(cmd,plus) == 0){
         newJob = (Job*) malloc(sizeof(Job));
         //read the input into the new node here. 
         scanf("%d", newJob);
         newJob->next = NULL;
         append(&(header),newJob);
         printf("Job added:\n");
      }
      else{
         //else if cmd = '-'
         if(strcmp(cmd,min) == 0){
            if(header.firstJob != NULL){
              // delete(&(header.firstJob));
               printf("Job deleted:\n");
            }else{
               printf("list is empty!\n");
            }
         }
         else{
            if(strcmp(cmd, exc) == 0){
               exit(0);
            }
         }
      }
      print(&(header));
   }
}

void append(Header *headerPtr, Job *jobPtr){
   Header header;
   Job job;
   header.firstJob;
   header.numOfJobs;

   if(headerPtr->firstJob == NULL){
      headerPtr->firstJob = jobPtr;
   }
   else{
      Job *tmp = headerPtr->firstJob;
      while(tmp->next != NULL){
         tmp = tmp->next;
      }
      tmp->next = header.firstJob;
      header.numOfJobs++;
   }
}
/*
Job *delete(Header *headerPtr){
   header.numOfJobs;
   //check if list is empty or not, if is print.
   if(headerPtr == NULL){
      printf("list is empty!");
   } 
   Job *tmp = headerPtr;
   if(headPtr == 0){
      headerPtr = tmp->next;
      free(tmp);
   }
   for(int i = 0; tmp != NULL && i < headPtr-1; i++){
      tmp = tmp->next;
   }
   if(tmp == NULL || tmp->next == NULL){
      printf("End of list.");
   }
   Job *next = tmp->next->next;
   free(tmp->next);
   tmp->next = next;
   header.numOfJobs = header.numOfJobs - 1; 
}
*/

void print(Header *headerPtr){
   Header header;
   Job job;
   header.firstJob;
   job.programName;
   job.startTime;

   printf("the list:\n");
   if(headerPtr->numOfJobs != 0) {
      // list is not empty, print it
      Job *ptr = headerPtr->firstJob;
      printf("Job #\t%25s\t\t%6s\n", "ProgramName", "StartTime");
      for (int i = 0; i < headerPtr->numOfJobs; i++) {
         printf("%6d\t%25s\t\t%6d\n", i, ptr->programName, ptr->startTime);
         ptr = ptr->next;
      }
   }
}

