#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define LIMITE 20


char* creaNombreFichero(int numStep, int numRow){

	//char msg= malloc()[200];
	char* msg=NULL;
	msg = (char*)malloc(200*sizeof(char));
	size_t msgLen=0;	
	sprintf(msg,"sim_%d.%d.in",numStep,numRow);
	msgLen	= strlen(msg);

	return msg;
}


int main(int argc, char** argv){
	printf("Inicio\n");
	if(argc < 3){
 		printf("El uso del programa eS: matrixMaker <numSteps> <numRows>");
		return 0;
	}

	int numSteps=atoi(argv[1]);
	int numRows=atoi(argv[2]);
	int i,j,k=0;
	srand((unsigned int)time(NULL));
	for(i=0;i<numSteps;i++){
		for(j =0;j<numRows;j++){
			
			int r = LIMITE*((double)rand()/(double)RAND_MAX);
			char *fileName;
			fileName = creaNombreFichero(i,j);
			printf("El fichero es %s\n",fileName);
			FILE* f = fopen(fileName,"w");
			if(f != NULL){
				fprintf(f,"%d ",r);
				for(k=0;k<r;k++){
					double rd = ((double)rand()/(double)RAND_MAX);
					fprintf(f,"%f ",rd);
				}
				fclose(f);
			}

			
		}
	}

		
	printf("Final\n");
	return 0;
}


