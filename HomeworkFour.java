//Ivan Matos
import java.util.Scanner;
public class HomeworkFour {
	
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		
		double[] circles = null;
		
		boolean quit = false;
		
		while (!quit) 
		{
            System.out.println("Please choose an option:");
            
            System.out.println("1. Enter circle data");
            
            System.out.println("2. Sort areas from smallest to largest");
            
            System.out.println("3. Sort areas from largest to smallest");
            
            System.out.println("4. Display unique circle areas");
            
            System.out.println("5. Quit");

            int choice = key.nextInt();

            switch (choice) 
            {
                case 1:
                    // Get circle data from user
                    circles = getCircleData(key);
                    break;
                    
                case 2:
                    // Sort areas in ascending order
                    
                	if (circles != null)               	
                    {
                        sortAscending(circles);
                        printAreas(circles);
                    } 
                    
                    else 
                    {
                        System.out.println("No circles data available.");
                    }
                    break;
                    
                case 3:
                    // Sort areas in descending order
                    if (circles != null) 
                    {
                        sortDescending(circles);
                        printAreas(circles);
                    } 
                    else 
                    {
                        System.out.println("No circles data available.");
                    }
                    break;
                    
                case 4:
                    // Display unique circle areas
                    if (circles != null) 
                    {
                        displayUniqueAreas(circles);
                    } 
                    else {
                        System.out.println("No circles data available.");
                    }
                    break;
                    
                case 5:
                    quit = true;
                    System.out.println("Quitting program.");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        key.close();
    }

    // Method to get the circle data from the user
    public static double[] getCircleData(Scanner scanner) {
    	
        System.out.println("Enter the number of circles:");
        
        int n = scanner.nextInt();
        
        while (n <= 0) 
        {
            System.out.println("Invalid number of circles. Please enter a positive number:");
            n = scanner.nextInt();
        }

        double[] circles = new double[n];
        
        for (int i = 0; i < n; i++) 
        {
            System.out.println("Enter the radius for circle " + (i + 1) + ":");
            double radius = scanner.nextDouble();
            circles[i] = calculateArea(radius);
        }
        
        return circles;
    }

    // Method to calculate area of a circle
    public static double calculateArea(double radius) {
    	
        return 3.14 * radius * radius;
    }

    // Method to sort areas in ascending order
    public static void sortAscending(double[] areas) {
    	
        for (int i = 0; i < areas.length - 1; i++) 
        {
            for (int j = 0; j < areas.length - i - 1; j++) 
            {
                if (areas[j] > areas[j + 1]) 
                {
                    double temp = areas[j];
                    areas[j] = areas[j + 1];
                    areas[j + 1] = temp;
                }
            }
        }
    }

    // Method to sort areas in descending order
    public static void sortDescending(double[] areas) {
    	
        for (int i = 0; i < areas.length - 1; i++) 
        {
            for (int j = 0; j < areas.length - i - 1; j++) 
            {
                if (areas[j] < areas[j + 1]) 
                {
                    double temp = areas[j];
                    areas[j] = areas[j + 1];
                    areas[j + 1] = temp;
                }
            }
        }
    }

    // Method to print circle areas
    public static void printAreas(double[] areas) {
    	
        System.out.println("Circle areas:");
        
        for (double area : areas) 
        {
            System.out.println(area);
        }
    }

    // Method to display unique circle areas
    public static void displayUniqueAreas(double[] areas) {
    	
        System.out.println("Unique circle areas:");
        
        boolean[] isDuplicate = new boolean[areas.length];
        
        for (int i = 0; i < areas.length; i++) 
        {
            if (!isDuplicate[i]) 
            {
                boolean unique = true;
                
                for (int j = i + 1; j < areas.length; j++) 
                {
                    if (areas[i] == areas[j]) 
                    {
                        isDuplicate[j] = true;
                        unique = false;
                    }
                }
                
                if (unique) 
                {
                    System.out.println(areas[i]);
                }
            }
        }
	}
}
