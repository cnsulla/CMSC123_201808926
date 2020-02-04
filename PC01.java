import java.util.Scanner;

public class PC01
{
	public PC01()
	{}

	public void triangle(int k	)
	{
		for (int i = 0; i < k; i ++)
		{
			System.out.print("\n");
			for (int j = i+1; j < k; j ++)
			{
				System.out.print(" ");
			}
			for (int x = 0; x <= i; x ++)
			{
				System.out.print("X ");
			}
		}
	}

	public static void main(String[] args)
	{
		PC01 x = new PC01();
		Scanner scan = new Scanner(System.in);
		System.out.print("Input triangle size: ");
		int in = scan.nextInt();
		x.triangle(in);
	}	
}