package Direct;
import InDirect.*;
import BracktingMethods.*;

import java.util.Scanner;
public class NumericalAnalysis {
    static int n;
    static double arr[][] , x[];
    public static Scanner read = new Scanner (System.in);
  
    public static void main(String[] args) {
        System.out.println("Choose the system you want to solve :");
        System.out.println("[1] Linear equaitons");
        System.out.println("[2] Non-linear equations");
        int choice = read.nextInt();
        switch (choice) {
            case 1:
            {
                menu1();  
                break;
            }
            case 2:
            {
                menu2();
                break;
            }
            default:
                throw new AssertionError("Invalid choice");
        }
    }
    
    private static void menu1(){
        
        System.out.println("[1] Gauess Elimination");
        System.out.println("[2] Cramer");
        System.out.println("[4] GaussSeidel");
        System.out.println("[5] Jacobi");
        System.out.println("select the way to solve :");
        int select = read.nextInt();
        method1(select);
    }
    
    private static void menu2()
    {
        System.out.println("[1] Bisection");
        int select = read.nextInt();
        method2(select);
   
    }
    
    private static void method1(int select){
        System.out.println("Enter the number of equations :");
        n = read.nextInt();
        arr = new double [n][n+1];
        x = new double [n];
        
        System.out.println("Enter the elements of matrix by row:");
        for (int i = 0; i < n ; i++)
            for (int j = 0; j <= n; j++)
<<<<<<< HEAD
                arr[i][j] = read.nextDouble();
        
        System.out.println("select the way to solve :");
        menu();
        int select = read.nextInt();
        method(select);
    }
    
    public static void menu(){
        
        System.out.println("[1] gauess elimination");
        System.out.println("[2] cramer");
        System.out.println("[4] GaussSeidel");
        System.out.println("[5] Jacobi");
    }
    public static void method(int select){
         switch(select)
=======
                arr[i][j] = read.nextFloat();
        switch(select)
>>>>>>> 464fa8a04ecdafd1ae286bf353f81f9c5fbe307f
        {
            case 1:
            {
                GaussElimination solution = new GaussElimination(n,arr,x);
                solution.Solve();
                break;
            }
            case 2:
            {
                Cramer solution = new Cramer(n,arr);
                solution.Solve();
                break;
            }
            case 4 :{
                GaussSeidel solution = new GaussSeidel(n, arr);
                solution.Solve();
                break;
            }
            case 5 : 
            {
                Jacobi solution = new Jacobi(n, arr);
                solution.Solve();
                break;
            }

    }
    }
    
    private static void method2(int select)
    {
        System.out.println("Enter the heighst degree in equation: ");
        int degree = read.nextInt();
        degree++;
        double[] coefficient = new double[degree];
        System.out.println("Enter the coefficients from the lowest power"
                + "to the heighst :");
                
        for (int i = 0; i < degree; i++) 
            coefficient[i] = read.nextDouble();
        
        switch(select)
        {
            case 1:
            {          
            System.out.println("Enter the period that you search for the root in :");
            System.out.print("The starting value : ");
            double start = read.nextDouble();
            System.out.print("The Ending value : ");
            double end = read.nextDouble();
                Bisection solution = new Bisection(degree,coefficient,start,end);
                solution.solve();
                break;
            }
        }
    }
    
    
    
}



