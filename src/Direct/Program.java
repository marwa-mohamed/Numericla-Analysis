/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Direct;

public class Program {
    
    
    public static void menu()
    {
        System.out.println("1) gauess elimination");
        System.out.println("2) cramer");
        System.out.println("1) gauess elimination");
    }
    
    public static void select(int x)
    {
        switch(x)
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
                
            case 2:
            {
                Cramer solution = new Cramer();
            }        

        }

    }
    
}
