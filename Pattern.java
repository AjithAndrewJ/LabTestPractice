package library;

public class Pattern {
	
	public static void main(String[] args) {
		
		for(int i=1;i<=10;i++){
			for(int j=1;j<=i;j++){
				int num=1;
				num=j*i;
				System.out.print(num);
			}
			System.out.println();
	    }
	
		System.out.println();
		
		 int i,j;
		  for(i=4;i>=1;i--)
		  {
		    for(j=1;j<=4;j++)
		    {
		      if(j<=i)
		        System.out.print(j);
		      else
		        System.out.print(" ");
		    }
		    for(j=4;j>=1;j--)
		    {
		      if(j<=i)
		        System.out.print(j);
		      else
		        System.out.print(" ");
		    }
		    System.out.println();
		  }
	}
}
