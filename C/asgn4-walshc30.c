#include <stdio.h>  
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <string.h>

/*

author: Corey R Walsh.


*/

struct JOB {
   char command[5][25]; // domain = { [a-zA-Z][a-zA-Z0-9_\.]* }
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
//void append(Header *headerPtr, Job *jobPtr);
Job *delete(Header *headerPtr);
void print(Header *headerPtr);
Job *findByProgName(Header *headerPtr, char *progName);
void insert(Header *headerPtr, Job *jobPtr);
  
int main(){
   Header header;
   header.firstJob = NULL;
   header.numOfJobs = 0;
   header.progStartTime = time(NULL);
   Header *headerPtr = headerPtr->firstJob   

   Job *next = NULL;
   Job *newJob = NULL;

   char cmd[2];
   char plus[2] = "+";
   char min[2] = "-";
   char exc[2] = "!";
   char ques[2] = "?";
   char *path = NULL;
   char *argr[2];   


   //input
   printf("program started at:%d\n", header.progStartTime);
   scanf("%s", cmd);
   //loop to run until '!' is entered.
   while(cmd[0] != '!'){
      scanf("%s", cmd);
      scanf("%s%d%d",&headerPtr->command, &headerPtr->startTime, &headerPtr->submissionTime);
      //if cmd = '+' 
      if(strcmp(cmd,plus) == 0){
         newJob = (Job*) malloc(sizeof(Job));
         //read the input into the new node here. 
         scanf("%s%d", newJob->command,&(newJob->startTime));
         newJob->next = NULL;
         //append(&(header), newJob);
         insert(&(header), newJob);
      }
      else{
         //else if cmd = '-'
         if(strcmp(cmd,min) == 0){
            if(header.firstJob != NULL){
               delete(&(header.firstJob));
               printf("Job deleted:\n");
            }else{
               printf("list is empty!\n");
            }
         }
         else{
            //if '?' entered, call findbyprogname();
            if(strcmp(cmd, ques) == 0){
               Job *jobToFind = (Job*) malloc(sizeof(Job));
               scanf("%s", jobToFind);
               findByProgName(&(header),jobToFind);   
            }else{
               if(strcmp(cmd, exc) == 0){
                  int currentSysTime = time(NULL);
                  Job *nextJob = NULL;
                  while((int)headerPtr != 0){
                     nextJob = nextJob->firstJob;
                     int key; 
                     int status;
                     int cpid = fork();
                     if(cpid == 0 && currentSysTime >= nextJob->submissionTime + nextJob->startTime){
                        printf("child:%d\n", (int)getpid());
                        path = nextJob->command[0];
                        key = 0;
                        while(nextJob->command[key][0] != '\0'){
                           argr[key] = nextJob->command[key];
                           key++;
                        }
                        argr[key] = NULL;
                        //print the currentSysTime
                        printf("current system time:%d\n", currentSysTime);
                        //delete the first job and print the details
                        delete(headerPtr);
                        //start the job as new process
                        execvp(path, argr);
                        // wait for the job to complete
                        fflush(stderr);
                        printf("Something went wrong!\n");
                        exit(1);
                     }else{
                        printf("parent:%d\n", (int)getpid());
                        //delay(1 second)
                        sleep(1);
                        waitpid(cpid, &status, 0);
                     } 
                  }
                  print(&(header));
                  exit(0);
               }
            }   
         }
      }
   }
}

Job *findByProgName(Header *headerPtr, char *progName){
   Job *ptr = headerPtr->firstJob;
   while(ptr != progName){
      ptr = ptr->next;
   }
   if(strcmp(ptr,&(progName))){
      return ptr;   
   }else{
      printf("Not found!\n");
      return NULL;
   } 
}

void insert(Header *headerPtr, Job *jobPtr){
   Header header;
   Job job;
   Job *newJob = (Job*) malloc(sizeof(Job));
   newJob = jobPtr;
   headerPtr = newJob;
   
}

/*
void append(Header *headerPtr, Job *jobPtr){
   if(headerPtr->firstJob == NULL){
      headerPtr->firstJob = jobPtr;
   }
   else{
      Job *tmp = headerPtr->firstJob;
      while(tmp->next != NULL){
         tmp = tmp->next;
      }
      tmp->next = firstJob;
      headerPtr->numOfJobs++;
   }
}
*/

Job *delete(Header *headerPtr){
   Header header;
   Job job;

   if(header.firstJob != NULL){
      Job *tmp = headerPtr->firstJob;
      headerPtr->firstJob = header.firstJob->next;

      //output the info of the job that was deleted
      printf("Job Deleted:\n");
      printf("program name:%s\n",tmp->command);
      printf("start time:%d\n",tmp->startTime);
      printf("submission time:%d\n",tmp->submissionTime);
      
      free(tmp);
      header.numOfJobs--;
      return tmp;
   }else{
      printf("List is empty");
   }
}


void print(Header *headerPtr){
   Header header;
   Job job;

   printf("# of jobs:%d\n", header.numOfJobs);
   if(headerPtr->numOfJobs != 0) {
      // list is not empty, print it
      Job *ptr = headerPtr->firstJob;
      for (int i = 0; i < headerPtr->numOfJobs; i++){
         printf("Job:%d\n", i);
         printf("command:%s", ptr->command);
         printf("start time:%s\n", ptr->startTime);
         printf("submission time:%d\n", ptr->submissionTime);
         ptr = ptr->next;
      }
   }else{
      printf("the list is empty.");
   }
}

