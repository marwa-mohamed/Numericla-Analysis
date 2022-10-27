/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Direct;
public class GaussElimination {
   public int size = 0;
   public double a[][];
   public double solution[]; 
   
   GaussElimination(int n, double arr[][], double x[])
    {
        size = n;
        a = arr;
        solution = x;
    }
   
   public void Pivotisation()
   {
      for (int i = 0; i < size; i++)                    
        for (int k = i+1; k < size; k++)
            if (Math.abs(a[i][i]) < Math.abs(a[k][i]))
                for (int j = 0;j <= size; j++)
                {
                    double temp=a[i][j];
                    a[i][j]=a[k][j];
                    a[k][j]= temp;
                }
   }
   
   public void perform_elimination()
   {
    for (int i = 0;i < size - 1; i++)            //loop to perform the gauss elimination
        for (int k = i+1 ;k < size; k++)
            {
                double t = a[k][i] / a[i][i];
                for (int j = 0 ; j <= size;j++)
                    a[k][j] = a[k][j]- t * a[i][j];    //make the elements below the pivot elements equal to zero or elimnate the variables
            }
   }
   
   public void back_substitution()
   {
       for (int i = size-1; i >= 0; i--)                //back-substitution
       {                        //x is an array whose values correspond to the values of x,y,z..
        solution[i] = a[i][size];                //make the variable to be calculated equal to the rhs of the last equation
        for (int j = i+1; j < size; j++)
            if (j!=i)            //then subtract all the lhs values except the coefficient of the variable whose value                                   is being calculated
                solution[i] = solution[i] - a[i][j] * solution[j];
        solution[i] = solution[i] / a[i][i];            //now finally divide the rhs by the coefficient of the variable to be calculated
       }
   }
   
   public void print()
   {
        for (int i = 0; i < size; i++)            //print the new matrix
        {
            for (int j = 0; j <= size; j++)
            System.out.printf("%16.4f \t" , a[i][j]);
         System.out.println();
        }    
        
   }
   
   public void print_sol()
   {
        for (int i = 0; i < size; i++)            //print the final solution
           System.out.printf("%16.4f \n" , solution[i]);
 
   }
}