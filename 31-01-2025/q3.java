package intro;

public class q3 {
	public static void main(String args[])
	{
		String str=new String("hey there!");
		char arr[]=str.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			if(i%2!=0)
			{
				System.out.print(arr[i]);
			}
		}
	}

}
