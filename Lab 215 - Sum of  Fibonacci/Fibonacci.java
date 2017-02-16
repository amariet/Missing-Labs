
/**
 * Calculates the sum of the fibonacci sequence with iteration and with recursion. 
 * 
 * @Kara Herson
 * @2/15/2017
 */
public class Fibonacci
{
    public static void main()
    {
        Fibonacci f = new Fibonacci();
        System.out.print("\nIteration sum of first 4 fibonacci numbers: " + f.fibIteration(4));
        System.out.print("\nRecursion sum of first 4 fibonacci numbers: " + f.fibIteration(4)+ "\n");
        
        System.out.print("\nIteration sum of first 5 fibonacci numbers: " + f.fibIteration(5));
        System.out.print("\nRecursion sum of first 5 fibonacci numbers: " + f.fibIteration(5)+ "\n");
        
        System.out.print("\nIteration sum of first 6 fibonacci numbers: " + f.fibIteration(6));
        System.out.print("\nRecursion sum of first 6 fibonacci numbers: " + f.fibIteration(6));
        
        // 1 1 2 3 5 8 etc. 
        
    }

    public int fibIteration (int n)
    {
        if (n == 0)
        {
            return 1;
        }
        int sum = 0;
        int current = 1;
        int previous = 0;
        int counter = 0; 
        while (counter < n)
        {
            sum += current;
            int temp = current + previous;
            previous = current;
            current = temp;
            counter ++;
        }
        
        return sum;
    }
    
    public int fibRecursion (int n)
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        return fibRecursion (n-1) + fibRecursion(n-2);
    }
}
