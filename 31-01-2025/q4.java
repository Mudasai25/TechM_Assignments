package intro;

public class q4 {
	public static void main(String args[])
	{
		String str=new String("hey3 there! hello");
		char arr[]=str.toCharArray();
		String ch="";
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==' ' && !Character.isDigit(arr[i-1]))
			{
				 ch=ch+arr[i-1];
			}
		}
		if( !Character.isDigit(arr[arr.length-1]))
		{
		ch=ch+arr[arr.length-1];
		
		}
				
		System.out.println(ch);	
		
	
}
}
