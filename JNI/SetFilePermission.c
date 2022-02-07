#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <jni.h>
#include "SetFilePermission.h"

void setting_permissions(mode_t m)
{
	putchar( m & S_IRUSR ? 'r' : '-' );
    	putchar( m & S_IWUSR ? 'w' : '-' );
    	putchar( m & S_IXUSR ? 'x' : '-' );
    	putchar( m & S_IRGRP ? 'r' : '-' );
    	putchar( m & S_IWGRP ? 'w' : '-' );
    	putchar( m & S_IXGRP ? 'x' : '-' );
    	putchar( m & S_IROTH ? 'r' : '-' );
    	putchar( m & S_IWOTH ? 'w' : '-' );
    	putchar( m & S_IXOTH ? 'x' : '-' );
    	putchar('\n');
}

JNIEXPORT jstring JNICALL Java_SetFilePermission_cFileCall
(JNIEnv *env, jobject obj,jstring file){
	
	const char *filename =(*env)->GetStringUTFChars(env,file,NULL);
	//const char *filename = "";

	struct stat fs;
	mode_t mode;
	int r;
	printf("File %s Permission mode:\n",filename);
	r = stat(filename, &fs);
	if(r==-1){
		fprintf(stderr,"File error\n");
		exit(1);
	}	
	puts("Current permissions:");
    	setting_permissions(fs.st_mode);
	


	/*printf("Owner permissions: ");
    	if( fs.st_mode & S_IRUSR )
        	printf("read ");
    	if( fs.st_mode & S_IWUSR )
    	    	printf("write ");
    	if( fs.st_mode & S_IXUSR )
        	printf("execute");
    	putchar('\n');

    	printf("Group permissions: ");
    	if( fs.st_mode & S_IRGRP )
        	printf("read ");
    	if( fs.st_mode & S_IWGRP )
        	printf("write ");
    	if( fs.st_mode & S_IXGRP )
        	printf("execute");
    	putchar('\n');

    	printf("Others permissions: ");
    	if( fs.st_mode & S_IROTH )
        	printf("read ");
    	if( fs.st_mode & S_IWOTH )
        	printf("write ");
    	if( fs.st_mode & S_IXOTH )
        	printf("execute");
    	putchar('\n');*/
	
	return 0;
}