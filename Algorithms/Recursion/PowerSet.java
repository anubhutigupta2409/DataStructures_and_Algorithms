import java.util.*;

public class PowerSet
{
	public static void powerSetUtil(String s, int i, String curr)
	{
		if(i==s.length())
		{
			System.out.println(curr);
			return;
		}
		powerSetUtil(s,i+1,curr+s.charAt(i));//adding
		powerSetUtil(s,i+1,curr);//not adding
	}
	public static void powerSet(String s)
	{
		powerSetUtil(s,0,"");
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		powerSet(s);
	}
}