/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Direct;
import InDirect.*;
import java.util.Scanner;
public class NumericalAnalysis {
    static int n;
    static double arr[][] , x[];
    public static Scanner read = new Scanner (System.in);
    public static void main(String[] args) {
        System.out.println("Enter the number of equations :");
        n = read.nextInt();
        arr = new double [n][n+1];
        x = new double [n];
        
        System.out.println("Enter the elements of matrix by row:");
        for (int i = 0; i < n ; i++)
            for (int j = 0; j <= n; j++)
                arr[i][j] = read.nextFloat();
        
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
        {
            case 1:
            {
                
                GaussElimination solution = new GaussElimination(n,arr,x);
                solution.Pivotisation();        
                solution.perform_elimination();
                solution.back_substitution();
                solution.print_sol();
                break;
            }
            case 4 :{
                GaussSeidel solution = new GaussSeidel(n, arr);
                solution.Solve();
            }
            case 5 : 
            {
                Jacobi solution = new Jacobi(n, arr);
                solution.Solve();
            }
    }
    }
}



