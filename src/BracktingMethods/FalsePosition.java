package BracktingMethods;

/**
 *
 * @author marwa
 */
public class FalsePosition {
    final int MAX_ITER = 1000000;
    private  int degree;
    private  double coefficient[];
    private double start,end;
    

    public FalsePosition(int degree, double []arr, double st, double end) {
        this.degree = degree;
        coefficient = arr;
        this.start = st;
        this.end = end;        
    }
    
    private double func(double x)
    {
        double result = 0;
        for (int i = 0; i < degree; i++)    
            result += coefficient[i] * Math.pow(x, i);
        
        return result;
    }
    
    private boolean check()
    {
        if ( func(start) * func(end)  >= 0)
        {   
            System.out.println("You have not assumed right a and b");
            return false;
        }
        else
            return true;
    }
    
    public void solve ()
    {    
        if (check())
        {
            double root = 0;
             for (int i = 0; i < MAX_ITER; i++)
            {
                root = (start * func(end) - end * func(start))
                     / (func(end) - func(start));

                // Check if the above found point is root
                if (func(root) == 0)
                    break;

                // Decide the side to repeat the steps
                else if (func(root) * func(start) < 0)
                    end = root;
                else
                    start = root;
            }
            System.out.printf("The root value is : %.5f \n" , root);
        }
        
    }
    
    
}
