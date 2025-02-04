package intro;
import java.lang.System;
public class task1 {
	public static void main(String args[])
	{
		int arr1[]= {1,2,3,4,5,6,7,8};
		int arr2[]= {10,20,30,40,50,60,70,80};
		for(int i=0;i<arr1.length;i=i+2)
		{
		System.arraycopy(arr1, i, arr2, i,1);
		}
		for(int j=0;j<arr2.length;j++)
		{
			System.out.println(arr2[j]);
		}
		
	}

}
