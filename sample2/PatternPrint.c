#include <jni.h>
#include "PatternPrint.h"
#include <stdlib.h>

JNIEXPORT void JNICALL Java_PatternPrint_pattern
(JNIEnv *env, jobject obj, jint times){
	for(int num = 1 ; num <= times ; num ++){
		for(int time = 1 ; time <= num ; time ++){
			printf("%d ",time);
		}
		printf("\n");
	}
}