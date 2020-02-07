import java.util.Scanner;

public class PC02
{
	public PC02()
	{}

	public void sawblade(int k)
	{
		for (int i = 0; i < k; i ++)
		{
			for (int x = 0; x <= i; x ++)
			{
				System.out.print("X");
            }
            for (int j = i+1; j < k; j ++)
			{
				System.out.print(" ");
            }
            for (int w = i; w > 0; w--)
            {
                System.out.print("X");
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