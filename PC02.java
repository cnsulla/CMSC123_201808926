import java.util.Scanner;

public class PC02
{
	public PC02()
	{}

	public void sawblade(int k)
	{
		for (int i = 0; i < k; i ++)
		{
			for (int w = i; w >= 0; w--)
            {	
				for (int x = w; x >= 0; x--)
				{
					System.out.print("*");
				}
				
				for (int j = k-i; j > 1; j--)
				{
					System.out.print(" ");
				}
			}  
            System.out.println();
		}
    }
    
	public static void main(String[] args)
	{
		PC02 x = new PC02();
		Scanner scan = new Scanner(System.in);
		System.out.print("Input sawblade size: ");
		int in = scan.nextInt();
		x.sawblade(in);
	}	
}