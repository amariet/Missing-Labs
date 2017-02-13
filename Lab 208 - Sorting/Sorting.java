
/**
 * Implements insertion sort and selection sort for arrays and arraylists
 * 
 * Absent on day assigned
 * 
 * @Kara Herson
 * @2/8/2017
 */
import java.util.ArrayList;
public class Sorting
{
    public static void main()
    {
        Sorting s = new Sorting();
        
        //test insertion sort for arrays
        System.out.print("\n **** Insertion Sort for Arrays ****\n");
        int[] a = s.randomArray(5, 9);
        s.printArray(a);
        s.insertionSortArray(a);
        s.printArray(a);
        
        //test insertion sort for arrayLists
        System.out.print("\n **** Insertion Sort for ArrayLists ****\n");
        ArrayList<Integer> b = s.randomArrayList (5, 9);
        s.printArrayList(b);
        s.insertionSortArrayList(b);
        s.printArrayList(b);
        
        //test selection sort for arrays
        System.out.print("\n **** Selection Sort for Arrays ****\n");
        int[] c = s.randomArray(5, 9);
        s.printArray(c);
        s.selectionSortArray(c);
        s.printArray(c);
        
        //test selection sort for arrayLists
        System.out.print("\n **** Selection Sort for ArrayLists ****\n");
        ArrayList<Integer> d = s.randomArrayList(5, 9);
        s.printArrayList(d);
        s.selectionSortArrayList(d);
        s.printArrayList(d);
    }
    
    public int[] randomArray(int length, int range)
    {
        int[] array = new int [length];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int) (Math.random() * (range+1));
        }
        return array;
    }
    
    public ArrayList<Integer> randomArrayList(int length, int range)
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
        {
            array.add( (int)(Math.random()*(range+1)) );
        }
        return array;
    }
    
    public void printArray (int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length-1] + "\n");
    }
    
    public void printArrayList (ArrayList<Integer> array)
    {
        for (int i = 0; i < array.size() - 1; i++)
        {
            System.out.print(array.get(i) + ", ");
        }
        System.out.print(array.get(array.size()-1) + "\n");
        
    }
    
    //208.a
    public void insertionSortArray (int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            int movingValue = array[i];
            for (int j = i-1; j > -1; j--)
            {
                int leftValue = array[j];
                if (movingValue < leftValue)
                {
                    array[j] = movingValue;
                    array[j+1] = leftValue;
                } else {
                    break;
                }
            }
        }
    }
    
    //208.b
    public void insertionSortArrayList (ArrayList<Integer> array)
    {
        for (int i = 1; i < array.size(); i++)
        {
            int movingValue = array.get(i);
            for (int j = i-1; j > -1; j--)
            {
                int leftValue = array.get(j);
                if (movingValue < leftValue)
                {
                    array.set(j, movingValue);
                    array.set(j+1, leftValue);
                } else {
                    break;
                }
            }
        }
    }
    
    //208.c
    public void selectionSortArray (int[] array)
    {
        
        for (int i = 0; i < array.length-1; i++)
        {
            int smallestIndex = i;
            int temp = array[i];
            for (int j = i+1; j < array.length; j++)
            {
                int testValue = array[j];
                int currentValue = array[smallestIndex];
                if (testValue < currentValue)
                {
                    smallestIndex = j;
                }
            }
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
                    
    }
    
    //208.d
    public void selectionSortArrayList (ArrayList<Integer> array)
    {
        for (int i = 0; i < array.size()-1; i++)
        {
            int smallestIndex = i;
            int temp = array.get(i);
            for (int j = i+1; j < array.size(); j++)
            {
                int testValue = array.get(j);
                int currentValue = array.get(smallestIndex);
                if (testValue < currentValue)
                {
                    smallestIndex = j;
                }
            }
            array.set(i, array.get(smallestIndex));
            array.set (smallestIndex, temp);
        }
    }
}
