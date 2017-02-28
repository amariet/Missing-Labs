/**
 * StudentList
 * 
 * @11/21/16
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class StudentList
{
    private ArrayList<Student> students;
    private Scanner scr;

    public StudentList()
    {
        students = new ArrayList<Student>();
        scr = new Scanner (System.in);
    }
    
    public void addStudentToList()
    {
        if (students.size() >0)
        {
            String clearScanner = scr.nextLine();
        }
                           
        String name;
        int number;
        double GPA;
        System.out.print("\nStudent name: ");
        name = scr.nextLine();
        System.out.print("Student number: ");
        number = scr.nextInt();
        System.out.print("Student GPA: ");
        GPA = scr.nextDouble();
        Student student = new Student(name, number, GPA);
        students.add(student);
    }
    
    public void printStudentList()
    {
        for (int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);
            System.out.println ("Name: " + s.getStudentFullName() + "  Student Number: " + s.getStudentNumber() + "  GPA: " + s.getStudentGPA());
        }
        System.out.println();
    }
    
    public void deleteStudent(String input)
    {
        boolean notFound = true;
        for (int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);
            if (s.getStudentLastName().equals(input) || s.getStudentNumberString().equals(input))
            {
                System.out.println ("\n" + s.getStudentFullName()+ " has been deleted.");
                students.remove(i);
                notFound = false;
                break;
            }
        }
        
        if (notFound) 
        {
            System.out.print("\nStudent not found.");
        }
        
    }
    
    /*Prints student info to the console*/
     public void findStudent(String input)
    {
        boolean notFound = true;
        for (int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);
            if (s.getStudentLastName().equals(input) || s.getStudentNumberString().equals(input))
            {
                System.out.println ("\nName: " + s.getStudentFullName() + "  Student Number: " + s.getStudentNumber() + "  GPA: " + s.getStudentGPA());
                notFound = false;
            }
        }
        
        if (notFound) 
        {
            System.out.print("\nStudent not found.");
        }
        
    }
    
    public boolean doesStudentExist(String input)
    {
        for (int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);
            if (s.getStudentLastName().equals(input) || s.getStudentNumberString().equals(input))
            {
                return true;
            }
        }
        return false;
    }
    
    /*Just returns the student*/
     public Student getStudent(String input)
    {
        boolean notFound = true;
        for (int i = 0; i < students.size(); i++)
        {
            Student s = students.get(i);
            if (s.getStudentLastName().equals(input) || s.getStudentNumberString().equals(input))
            {
                return s;
            }
        }
        
        return null;
        
    }
    
    public void clearList()
    {
        students.clear();
        System.out.println ("List Cleared. All Students Deleted.");
    }
    
    public void editStudent(String x)
    {
            if (!doesStudentExist(x))
            {
                System.out.print ("\nStudent Does Not Exist");
            }
            else {
                
            Student s = getStudent(x);
            findStudent(x); // prints student to screen so user can see existing details
            int control = 0;
            
            //prompts user to enter what they would like to edit
            String [] menu = new String[3];
            menu[0] = "Student Name";
            menu[1] = "Student Number";
            menu[2] = "Student GPA";
            System.out.println ("\nWhat would you like to edit?");
            for (int i = 0; i < menu.length; i++)
            {
                System.out.println(i+1 + "  " + menu[i]);
            }
            System.out.print("\nSelect an item number: ");
            boolean notValid = true; //true while the user hasn't entered anything or while the user enteres an invalid input
            while (notValid)
            {
                if (scr.hasNextInt()){
                    int input = scr.nextInt();
                    if (input > 0 && input <= menu.length)
                    {
                        control = input;
                        notValid = false;
                    }else{
                        System.out.println ("Invalid Input. Select an option from the menu above: ");
                    }
                }else{
                    System.out.println ("Invalid Input. Select an option from the menu above: ");
                    String clearScanner = scr.nextLine();
                }
            }
            
            String clearScanner = scr.nextLine();
            
            //allows user to edit specified field
            
            if (control == 1) //name
            {
                System.out.print("\nNew student name: ");
                s.setStudentFullName(scr.nextLine());
            }
                
            if (control == 2) //number
            {
                System.out.print("\nNew Student Number: ");
                s.setStudentNumber(scr.nextInt());
            }
            
            if (control == 3) //GPA
            {
               System.out.print("\nNew Student GPA: ");
                s.setStudentGPA(scr.nextInt());
            }
            
            System.out.println ("\nName: " + s.getStudentFullName() + "  Student Number: " + s.getStudentNumber() + "  GPA: " + s.getStudentGPA());
            
        }
        
       
    }
    
    public void filterSearchStudentList()
    {
        String [] menu = new String[4];
        menu[0] = "Minimum student number";
        menu[1] = "Maximum student number";
        menu[2] = "Minimum student GPA";
        menu[3] = "Maximum student GPA";
        System.out.println ("\nWhat would you like to filter your student search by?");
        for (int i = 0; i < menu.length; i++)
        {
            System.out.println(i+1 + "  " + menu[i]);
        }
        System.out.print("\nSelect an item number: ");
        boolean notValid = true; //true while the user hasn't entered anything or while the user enteres an invalid input
        int control = 0;
        while (notValid)
        {
            if (scr.hasNextInt()){
                int input = scr.nextInt();
                if (input > 0 && input <= menu.length)
                {
                    control = input;
                    notValid = false;
                }else{
                    System.out.println ("Invalid Input. Select an option from the menu above: ");
                }
            }else{
                System.out.println ("Invalid Input. Select an option from the menu above: ");
                String clearScanner = scr.nextLine();
            }
        }
        
        String clearScanner = scr.nextLine();
        boolean studentExists = false;
        if (control == 1) //min ID
        {
            System.out.print("\nEnter minimum student number: ");
            int min = scr.nextInt();
            for (int i = 0; i < students.size(); i++)
            {
                Student s = students.get(i);
                if (s.getStudentNumber() >= min)
                {
                   System.out.print("\nName: " + s.getStudentFullName() + "  Student Number: " + s.getStudentNumber() + "  GPA: " + s.getStudentGPA());
                   studentExists = true;
                }
            }
        }
                
        if (control == 2) //max ID
        {
            System.out.print("\nEnter maximum student number: ");
            int max = scr.nextInt();
            for (int i = 0; i < students.size(); i++)
            {
                Student s = students.get(i);
                if (s.getStudentNumber() <= max)
                {
                    System.out.print("\nName: " + s.getStudentFullName() + "  Student Number: " + s.getStudentNumber() + "  GPA: " + s.getStudentGPA());
                    studentExists = true;
                }
                
            }

        }
            
        if (control == 3) //min gpa
        {
            System.out.print("\nEnter miminum GPA: ");
            int min = scr.nextInt();
            for (int i = 0; i < students.size(); i++)
            {
                Student s = students.get(i);
                if (s.getStudentGPA() >= min)
                {
                   System.out.print("\nName: " + s.getStudentFullName() + "  Student Number: " + s.getStudentNumber() + "  GPA: " + s.getStudentGPA());
                   studentExists = true;
                }
            }
        }
        
        if (control == 4) //max gpa
        {
            System.out.print("\nEnter maximum GPA: ");
            int max = scr.nextInt();
            for (int i = 0; i < students.size(); i++)
            {
                Student s = students.get(i);
                if (s.getStudentGPA() <= max)
                {
                    System.out.print("\nName: " + s.getStudentFullName() + "  Student Number: " + s.getStudentNumber() + "  GPA: " + s.getStudentGPA());
                    studentExists = true;
                }
                
            }
        }
        
        if (!studentExists)
        {
            System.out.print("\nNo such student exists");
        }
    }
    
    public void sortByNumber()
    {
        String [] menu = new String[3];
        menu[0] = "Java's built in sorting algorithm";
        menu[1] = "Insertion Sort";
        menu[2] = "Selection Sort";
        System.out.println ("\nWhat algorithm would you like to use to sort your students?");
        for (int i = 0; i < menu.length; i++)
        {
            System.out.println(i+1 + "  " + menu[i]);
        }
        System.out.print("\nSelect an item number: ");
        boolean notValid = true; //true while the user hasn't entered anything or while the user enteres an invalid input
        int control = 0;
        while (notValid)
        {
            if (scr.hasNextInt()){
                int input = scr.nextInt();
                if (input > 0 && input <= menu.length)
                {
                    control = input;
                    notValid = false;
                }else{
                    System.out.println ("Invalid Input. Select an option from the menu above: ");
                }
            }else{
                System.out.println ("Invalid Input. Select an option from the menu above: ");
                String clearScanner = scr.nextLine();
            }
        }
        
        String clearScanner = scr.nextLine();
        System.out.print("\nOriginal List:\n");
        printStudentList();
        if (control == 1)
        {
            javaSort();
        }
        if (control ==2)
        {
            insertionSort();
        }
        if (control == 3)
        {
            selectionSort();
        }
        
        System.out.print("\nSorted List:\n");
        printStudentList();

    }
    
    public void javaSort()
    {
        Student[] s = new Student [students.size()];
        for (int i = 0; i < students.size(); i++)
        {
            s[i] = students.get(i);
        }
        Arrays.sort(s);
        for (int i = 0; i < students.size(); i++)
        {
            students.set (i, s[i]);
        }
    }
    
    public void insertionSort()
    {
        for (int i = 1; i < students.size(); i++)
        {
            int movingValue = students.get(i).getStudentNumber();
            Student s = students.get(i);
            for (int j = i-1; j > -1; j--)
            {
                int leftValue = students.get(j).getStudentNumber();
                Student r = students.get(j);
                if (movingValue < leftValue)
                {
                    students.set(j, s);
                    students.set(j+1, r);
                } else {
                    break;
                }
            }
        }
    }
    
    public void selectionSort()
    {
        for (int i = 0; i < students.size()-1; i++)
        {
            int smallestIndex = i;
            Student temp = students.get(i);
            for (int j = i+1; j < students.size(); j++)
            {
                int testValue = students.get(j).getStudentNumber();
                int currentValue = students.get(smallestIndex).getStudentNumber();
                if (testValue < currentValue)
                {
                    smallestIndex = j;
                }
            }
            students.set(i, students.get(smallestIndex));
            students.set (smallestIndex, temp);
        }
    }
    
    public void generateRandomList()
    {
        for (int i = 0; i < 5; i++)
        { 
            int randomNumber = (int)(Math.random() * 10);
            String name = ("" + randomNumber + " " + randomNumber);
            int number = randomNumber;
            double GPA = randomNumber;
            Student student = new Student(name, number, GPA);
            students.add(student);
        }
        
        printStudentList();
    }
        
}
