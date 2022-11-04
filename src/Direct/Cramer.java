package Direct;

public class Cramer {
   private int size;
   private double matrix[][];
   private double right_side[];
   private double solution[]; 

    Cramer(int size, double arr[][]) {
        this.size = size;
        matrix = arr;
        right_side = new double[size];
        solution = new double[size];
        for(int i = 0; i < size; i++)    
            right_side[i] = matrix[i][size];
    }
    
    private double determinant(double[][] a) {
            if ( a.length == 1 )
                return a[0][0];
                
            if ( a.length == 2) 
                return ((a[0][0] * a[1][1]) - (a[0][1] * a[1][0]));
            
            double sum = 0;
            double sign = 1;
            
            for ( int i = 0 ; i < size ; i++ ) {
                sum += sign * a[0][i] * determinant(coFactor(0, i));
                sign *= -1;
            }
            
            return sum; 
    }
    
    private double [][] coFactor(int row, int col) {
        int tempi , tempj;
            double mat[][] = new double[size - 1][size - 1];
            
            for (int i = 0 ; i < size ; i++ ) {
                if ( i == row )
                    continue;
                
                
                for (int j = 0 ; j < size ; j++ )
                {
                   if (j == col)
                       continue;
                   
                   if (i == size - 1)
                       tempi = i -1;
                   else tempi = i;
                   
                   if (j == size - 1)
                       tempj = j -1;
                   else tempj = j;
                   
                   mat[tempi][tempj] = matrix[i][j];
                }
            }
            return mat;
        }
    
    private double [][] replaceColumn(double b[], int column) {
            double mat[][] = new double[size][size - 1];
            for ( int row = 0 ; row < size ; row++ ) {
                mat[row][column] = right_side[row];
            }
                
            return mat;
        }
            
   public void Solve()
   {
       double denominator = determinant(matrix);    
        for (int i = 0; i < right_side.length; i++)            //print the final solution
        {
            solution[i] = determinant(replaceColumn(right_side, i)) / denominator;
            System.out.printf("%16.4f \n" , solution[i]);
        }
   }
    
    
}