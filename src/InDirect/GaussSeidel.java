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
public class GaussSeidel {
   private int size;
   private double tmp;
   private double flag;
   private double accuracy;
   private double matrix[][];
   private double right_side[];
   private double initial_values[];
   private double solution[]; 
   
   public GaussSeidel(int size , double matrix[][] ){
       this.size = size;
       this.matrix = matrix;
       right_side = new double[size];
       initial_values = new double[size];
       solution = new double[size];
       for(int i=0;i<size;i++) right_side[i] = matrix[i][size];
   }
   
    private void Pivotisation()
   {
      for (int i = 0; i < size; i++)                    
        for (int k = i+1; k < size; k++)
            if (Math.abs(matrix[i][i]) < Math.abs(matrix[k][i]))
                for (int j = 0;j <= size; j++)
                {
                    double temp=matrix[i][j];
                    matrix[i][j]=matrix[k][j];
                    matrix[k][j]= temp;
                }
   }
    private void PreSolve(){
       System.out.println("Enter initial values:");
        for(int i = 0;i<size;i++) initial_values[i] = read.nextDouble();
        System.out.println("Enter accuracy of solution:");
        accuracy = read.nextDouble();
   }
    public void Solve(){
        PreSolve();
     Pivotisation();
        
        do                          
    {
        for (int i=0;i<size;i++)               
        {
            tmp=solution[i];
            solution[i]=matrix[i][size];
            for (int j=0;j<size;j++)
            {
                if (j!=i)
                solution[i]=solution[i]-matrix[i][j]*solution[j];
            }
            solution[i]=solution[i]/matrix[i][i];
            if (Math.abs(solution[i]-tmp)<=accuracy)      
                flag++;
            System.out.println(solution[i] + "   ");
        }
        System.out.println("   ");
       // count++;   
    }while(flag<size); 
    }
   
}
