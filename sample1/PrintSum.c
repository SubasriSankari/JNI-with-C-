#include <jni.h>
#include "PrintSum.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_PrintSum_sumOfTwoNum
(JNIEnv *env, jobject obj, jint num1, jint num2){
	jint sum = num1 + num2;
	printf("Sum of Two number is %d", sum);
}