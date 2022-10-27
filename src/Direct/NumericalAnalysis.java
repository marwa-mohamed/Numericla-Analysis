/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Direct;
import java.util.Scanner;
public class NumericalAnalysis {
    public static void main(String[] args) {
        Scanner read = new Scanner (System.in);
        System.out.println("Enter the number of equations :");
        int n = read.nextInt();
        double arr[][] = new double [n][n+1];
        double x[] = new double [n];
        
        System.out.println("Enter the elements of matrix by row:");
        for (int i = 0; i < n ; i++)
            for (int j = 0; j <= n; j++)
                arr[i][j] = read.nextFloat();
        
        System.out.println("select the way to solve :");
        Program.menu();
        int select = read.nextInt();
        Program.select(select);

    }
}



