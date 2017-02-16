/**
 * Implementation of Merge Sort
 * 
 * @Kara Herson
 * @2/16/2017
 */
public class Merger
{
    public static void main()
    {
        Merger m = new Merger();
        
    }
    
    public int[] mergeSort (int[] array)
    {
        if (array.length == 1)
        {
            return array;
        }
        
        if (array.length == 2)
        {
            int temp = array[0];
            if (array[1] < array[0])
            {
                array[0] = array[1];
                array[1] = temp;
            }
            return array;
        }
        
        
    }
    
    public int[] merge (int[] array1, int[] array2)
    {
        int[] newArray = new int[array1.length + array2.length];
    }
}



