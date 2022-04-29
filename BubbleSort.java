package library;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		
		int temp=0;
		int arr[]= {95,67,32,3,89,221,17};
		int len=arr.length;
		
		//Before Sort
		System.out.println("Array before bubble sort");
		Arrays.stream(arr).forEach(ar ->System.out.print(ar+" "));
		System.out.println();
		
		//Bubble Sort
		for(int i=0;i<len;i++) {
			for(int j=1;j<len-i;j++) {
				if(arr[j-1]>arr[j]) {
					//Swap
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		//After Sort
		System.out.println("Array after bubble sort");
		Arrays.stream(arr).forEach(ar -> System.out.print(ar+" "));
		System.out.println();
	}
}
