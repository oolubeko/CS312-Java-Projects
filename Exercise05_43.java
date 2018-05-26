
// Combinations

public class Exercise05_43
{
	public static void main(String[] args)
	{
		int count = 1;
		int total = 0;
		for(int i = 1; i < 8; i++)
		{
			for(int j = 2; j < 8; j++)
			{
				if(i != j && i < j)
				{
					System.out.println(i + " " + j);
					total += 1;
				}
		
			}
		}	
		System.out.println("The total number of all combinations is " + total);
	}	
	
	
}