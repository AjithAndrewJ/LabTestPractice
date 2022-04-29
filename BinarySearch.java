package library;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		
		int arr[]= {80,60,20,10,70,40};
		
		Arrays.sort(arr);//{10,20,40,60,70,80}=>(0-5)Index
		
		//key to search is 70
		int key=70;
		
		//Binary Search
		int first=0;
		int last=arr.length-1;
		int mid=(first+last)/2;  
		while(first<=last){  
			if(arr[mid]<key){  
				first=mid+1;     
			}else if(arr[mid]==key){  
				System.out.printf("The element %d is found at position %d",key,(mid+1)); 
				System.out.println();
		        break;  
			}else{  
		         last=mid-1;  
			}  
			mid=(first + last)/2;  
		}  
		if (first>last){  
			System.out.println("The element is not found");  
		}  
			
	}
}
