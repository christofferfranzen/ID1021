//---------------------------------------------
// Filnamn: HPC45.c
// Syfte:
//
// Indata: En sträng med Reverse Polish notation
// Utdata: Uträkningen
//
// Programmerare: Christoffer Franzén
// Datum: 230829
// Version: 1.0
//---------------------------------------------

#include <stdio.h>
#include <stdlib.h>

#define SIZE 10

enum ItemType { ADD, SUB, MUL, DIV, VALUE };

int ip = -1;
void push();
void pop(); 

int main(int argc, char *argv[]) {


  printf("%d", atoi(argv[1]));
  return 0;
} 

void push(){

}

void pop(){

}