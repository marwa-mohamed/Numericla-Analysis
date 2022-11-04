/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InDirect;
import static Direct.NumericalAnalysis.read;

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
   
   public Jacobi(int size , double matrix[][]){
       this.size = size;
       this.matrix = matrix;
       right_side = new double[size];
       initial_values = new double[size];
       solution = new double[size];
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
         for (int i = 0; i < size; i++) {
         solution[i] = (right_side[i] / matrix[i][i]);
         for (int j = 0; j < size; j++) {
            if (j == i)
               continue;
            solution[i] = solution[i] - ((matrix[i][j] / matrix[i][i]) * initial_values[j]);
            initial_values[i] = solution[i];
         }
            System.out.println("x : " + (i+1) + " = " + (solution[i]) + " ");
      }
            System.out.println("");
        }
   }
   
}
