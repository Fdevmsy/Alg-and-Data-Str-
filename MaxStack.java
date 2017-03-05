import java.io.*;


public class MaxStack
{   
//	public static void main(String[] args) 
//    {
//		for (int i=0; i<10; i++) 
//		{
//			int ans = push(i);
//			System.out.println(ans);
//		}
//		
//		System.out.println(pop());
//		System.out.println(pop());
//		System.out.println(max());
//	}
	public static int[] stack = new int[100];
	public static int[] maxs = new int[100]; // create another stack to store the max number.
	public static int top = 0;
	public static int mtop = 0;
	
	public static int push(int el)
	{
		if (el >= maxs[mtop]) 
		{
			maxs[++mtop] = el;
		}
		stack[++top] = el;
		return el;
	}
	public static int pop()
	{
		if (top<=0)
		{
			return -1;
		}
		if (stack[top]==maxs[mtop])
		{
			mtop--;
		}
		return stack[top--];
	}
	public static int max()
	{
		return maxs[mtop];
	}
	
}