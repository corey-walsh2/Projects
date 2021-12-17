/* 	Program: 	Hello World
   	Author: 	Corey W.
   	date: 		august 20, 2020
	file name: 	asgn1-walshc30.c
   	Compile: 	cc -o helloworld asgn1-walshc30.c
	Run:		./helloworld

	This C program accepts user's first name and a positive 
	interger N; it then prints a personal greeting N times. 
*/

#include <stdio.h>

int main(){
	char name[20];		// String of chars <= 19 chars
	int times;
	int i = 0;

	printf("Please enter your firstname and a number: \n");
	scanf("%s%d",name, &times);

	//print greetings
	for(i = 0; i < times; i++){
		printf("Hello %s, your first program works!\n", name);
	}
}
