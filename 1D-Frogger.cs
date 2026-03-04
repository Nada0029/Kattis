using System;
using System.Collections.Generic;
					
public class Program
{
	public static void Main()
	{
		string[] input = Console.ReadLine().Split();
		int n = int.Parse(input[0]); int s = int.Parse(input[1]) - 1; int m = int.Parse(input[2]);
		int[] board = new int[n];
		input = Console.ReadLine().Split();
		int hops = 0;
		int pos = s;
		List<int> visited = new List<int>();
		
		for(int i = 0; i < n; i++) 
		{
			board[i] = int.Parse(input[i]);
		}
		
		while(pos >= 0 && pos < n) 
		{
			if(!visited.Contains(pos)) 
			{
				if(board[pos] == m)
				{
					Console.WriteLine("magic\n" + hops);
                    Environment.Exit(0);
				} else
				{
					visited.Add(pos);
					pos += board[pos];
					hops++;					
				}
			} else 
			{
				Console.WriteLine("cycle\n" + hops);
				Environment.Exit(0);
			}
		}
		
        Console.WriteLine(pos < 0 ? "left\n" + hops : "right\n" + hops);
	}
}