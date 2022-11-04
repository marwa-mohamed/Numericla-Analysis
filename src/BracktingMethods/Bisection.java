package BracktingMethods;
import static Direct.NumericalAnalysis.read;

public class Bisection {
    private  int degree;
    private  double coefficient[];
    private double start,end;
    

    public Bisection(int degree, double []arr, double st, double end) {
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
            double mid = 0;
            int i = 1;
            while ((end - start) >= 0.01)
            {
                mid = (start + end) / 2;

                if(func(mid) == 0)
                    break;

                else if (func(mid) * func(start) < 0)
                    end = mid;
                else
                    start = mid;
            }
            System.out.printf("The root value is : %.9f \n" , mid);
        }
        
    }
}
