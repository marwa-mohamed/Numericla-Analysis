/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InDirect;
import static Direct.NumericalAnalysis.read;
import java.util.Scanner;

/**
 *
 * @author mokhalid
 */
public class Jacobi {
   private int size;
   private int numberOfIterations;
   private double matrix[][];
   private double right_side[];
   private double initial_values[];
   private double solution[]; 
   private double old_values[];
   
   public Jacobi(int size , double matrix[][]){
       this.size = size;
       this.matrix = matrix;
       right_side = new double[size];
       initial_values = new double[size];
       solution = new double[size];
       old_values = new double[size];
       for(int i=0;i<size;i++) right_side[i] = matrix[i][size];
   }
   
   private void PreSolve(){
       System.out.println("Enter initial values:");
        for(int i = 0;i<size;i++) initial_values[i] = read.nextDouble();
        System.out.println("Enter number of iterations:");
        numberOfIterations = read.nextInt();
   }
   public void Solve(){
         PreSolve();
         while(numberOfIterations > 0){
         for(int i=0;i<size;i++)
         old_values[i] = initial_values[i];
         for (int i = 0; i < size; i++) {
         initial_values[i] = (right_side[i] / matrix[i][i]);
         for (int j = 0; j < size; j++) {
            if (j == i)
               continue;
            initial_values[i] = initial_values[i] - ((matrix[i][j] / matrix[i][i]) * old_values[j]);
         }
            System.out.println("x : " + (i+1) + " = " + (old_values[i]) + " ");
      }
            System.out.println("");
            numberOfIterations--;
        }
   }
   
}
