package intro;
import java.lang.String;
import java.lang.System;
public class task2 {
	public static void main(String args[])
	{
		String str="anurag";
		char arr[]=str.toCharArray();
		for(int i=0;i<arr.length;i=i+2)
		{
			arr[i]=Character.toUpperCase(arr[i]);
		}
		System.out.print(arr);
	}

}
