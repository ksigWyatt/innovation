/**
 * @author Wyatt
 * Wyatt Baggett Software Engineering student
 * Innovation Project PSI FINAL
 * 
 * version 5.0
 */

/* This program will be for finding the volume of a sphere, the volume of a
 * cube, etc. Will try to add as many shapes as I can. Maybe even include area
 * too after everything is working.
 * 
 */

 import java.util.Scanner;
 import java.lang.Math;
 
/**
 * class main calls several methods it is primarily used as a switch statement
 * containing method calls. 
 * 
 * @param args - Command line arguments
 *
 */
public class main {
  public static void main(String[] args) {

/*The goal of this method is to be able to call on any other method later in
* the code. Don't think we may need that but I had to use that for the volume 
* of a sphere, couldn't figure out how to keep it as part of the main method.
*  - FIXED
* 
* DEV NOTES:
* 
* 1. I'm going to see if I can't use switches or something to try to create 
* some kind of GUI that a user can choose from to pick a shape to find the 
* volume of. - That worked out nicely, I also moved up the volume of a cube
* into the case statement for case 2. it's just way easier than using a get
* function again. - FIXED
* 
* 2. Can't refer to PI constant variable in case 5 without it asking to create
* a new name for the PI variable, I'll see what I can do to fix it. - FIXED
* 
* 3. Tried making a boolean based if statement about the program running, ended
* with a bunch of syntax errors. I'll have to just leave the majority of it as
* is since I can't figure out the looping or isRunning sequence. - Added 
* gotten good input wile loop - FIXED
* 
* 4. Also - In the getThankYou method I couldn't figure out how to get a simple 
* if / else statement in there without it having lots of errors so I just made
* it a scanner.nextInt since those seem to work the best. I want to eventually 
* get it to where the user enters yes or no to continue but I couldn't find
* any help for that online, perhaps in the next update?? - FIXED (Sorta)
* 
* 4.(5) Above Works only as is currently, will try to add a String input for 
* 'yes' to make it a valid input. - VISIT AGAIN (See below comments in section)
*  
* 5. now that created it into a method for easy recalling using few lines of 
* code. Ok so now that the menu works the looping part of it doesn't quite 
* work as expected and I know why. I will try to fix this in the next update 
* because I'm also not sure how to make it loop, perhaps with a while loop? 
* I'll try it... - FIXED (Sorta)
* 
* 6. How can we add arrays or anything to this? Try it? - VISIT AGAIN
* 
* 7. Final update - having to move the time line up a lot on this project.
*  2 hours left to submit this going to try to see how much I can get done in
*  that time. - UPDATE - may not be able to get it all done. Cone area seems to
*  be quite complicated. I'll see what I can do though. This is also turning
*  into a very large program. was ~400 lines before now it's over 600, final
*  may end up being 700+ lines
* 
*/		

	System.out.println("This program will help you to find the volume or area "
	    + "of different shapes. \nBelow you will enter which shape "
			+ "you wish to calculate.");

/*this is the best I could do for a user interface - 
*/	
	goToMainMenu();
}
  
  /**
   * Calls the method and brings up a simple menu this method is only used for
   * the main menu and the calculation of good inputs based on the users input.
   * 
   *  
   * @return goToRunningProgramLoop - returns the user to the desired menu path
   */
	private static void goToRunningProgramLoop() {
		
  Scanner scanner = new Scanner(System.in);
	int userInput = 0;
	boolean gottenGoodInput = false;
	while (gottenGoodInput == false){ 	
 		try {
 			System.out.println("Enter your response here: ");
 			userInput = scanner.nextInt();
 			gottenGoodInput = true;
 		}
 		catch (Exception ex){
 			System.out.println("Incorrect input. Please enter only number 1 "
 					+ "through 5");
 			scanner.next();
 		}
 	}
	
	
/* I couldn't make this int below a char so that the scanner will scan in any
 * typed words that you enter. WILL revisit this later! - FIXED used a while
 * loop to enter only numbers instead of text.
 * 
 */	
	
//*****************************************************************************	
	switch (userInput){
	case 1: //SPHERE
	  goToSphere();
	  
		break;
//*****************************************************************************	
	case 2: //CUBE
	  goToCube();
		
	  break;
//*****************************************************************************		
	case 3: //CONE
		goToCone();
		
		break;
//*****************************************************************************		
	case 4: //PYRAMID
		goToPyramid();
		
		break;
//*****************************************************************************		
	case 5: //CYLINDER
		goToCylinder();
		
		break;
	
	default: // if any number other than 1-5 is entered 
		System.out.println("You did it ACHIEVEMENT UNLOCKED!! \nYou beat the "
				+ "game congradulations!\nNot really... You broke it. Sorry "
				+ "friend :( \n\nYou were supposed to enter a number 1 through"
				+ " 5. Please run the program again. ");
		break;	
		}	
	}

/* In my workings I found it was far easier for me to put the majority of the
 * code into methods and just call certain methods when needed. It cleans up
 * the code, easier for me to find where I need to fix errors and I can easily
 * go back to the main menu by calling that method. 
 * 
 */
/**
 * Calls the method and brings up a simple menu this method is only used for
 * the main menu options.
 * 
 *  
 * @return goToMainMenu - lists the 5 options
 */
	private static void goToMainMenu() {
		System.out.println("\nYour options are: \n");
		System.out.println("Press 1 for a Sphere. \nPress 2 for a Cube. \n"
				+ "Press 3 for a Cone. \nPress 4 for a Pyramid. \nPress 5 for "
				+ "a Cylinder.");
		
		goToRunningProgramLoop();
	}

/**
 * Calls the method and brings up a simple menu this method is only used for
 * the thank you menu options. It only runs after a user has completed a
 * problem specified by the methods in this program.
 * 
 *  
 * @return getThankYou - shows thank you message
 */
	public static void getThankYou() {
		System.out.println("\nThank you for using this program! \n\nIf you'd "
				+ "like to test another shape or have different numbers "
				+ "please enter the number 1. \nOtherwise type anything else to"
				+ " end the program.");
		
    System.out.println("\nEnter your response here: ");
		
		int playAgain = 0;		
		Scanner scanner = new Scanner(System.in);
		
		boolean gottenGoodInput = false;		
		while (gottenGoodInput == false){ 	
	 		try {
	 			playAgain = scanner.nextInt();
	 			gottenGoodInput = true;
	 		}
			catch (Exception ex){
				System.out.println("You did not enter a number silly. \nBut nice try "
				    + "Please enter the number 1. Or just enter any other number");
				scanner.next();
			}
		}

		if (playAgain == 1){
		  goToMainMenu();
		}
		else{
			System.out.println("Thank you for using this program! Goodbye");
		}
			
	}
//*****************************************************************************	
/**
 * Calls the method and brings up a simple menu. one option is area and the 
 * other is volume. Once the user picks an option the calculations can begin.
 * 
 *  
 * @return goToSphere - calculates area and volume for a shape
 */  
	public static void goToSphere() {
    Scanner scanner = new Scanner(System.in);
    int userInput = 0;
    
    System.out.println("\nYou may choose to calculate Volume or Area. "
        + "\nYour options are: \n");
    System.out.println("Press 1 for Volume. \nPress 2 for Area. ");
    
    boolean gottenGoodInput = false;    
    while (gottenGoodInput == false){   
      try {
        System.out.println("Enter your response here: ");
        userInput = scanner.nextInt();
        gottenGoodInput = true;
      }
      catch (Exception ex){
        System.out.println("Incorrect input. Please enter only number "
            + "1 or 2. ");
        scanner.next();
      }
    }  
    
//*********************************** - Volume Sphere    
    switch (userInput){
    case 1: //Volume
      System.out.println("We will calculate the volume of a sphere for you."); 
      
      double radius = 0;
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the radius of the sphere: ");
          radius = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      } 
      
    calculateSphereVolume(radius);
    getThankYou();
 
    break;
//*********************************** - Area Sphere  
    case 2: //Area
      System.out.println("We will calculate the area of a sphere for you. ");
      
      radius = 0;
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the radius of the sphere: ");
          radius = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      } 
      
    calculateSphereArea(radius);
    getThankYou();
    break;
    
    default:
     System.out.println("You were supposed to enter a number 1 or 2."
         + " Please run the program again. ");
     break;
    }    
  }
//*****************************************************************************  
  private static void calculateSphereVolume(double radius) { 
		double sphereVolume = (4/3) * Math.PI * (Math.pow(radius, 3));
		
		System.out.print("The volume of your sphere is: " + (float)
				sphereVolume);
	}
	
	private static void calculateSphereArea(double radius) { 
    double sphereArea = (4) * Math.PI * (Math.pow(radius, 2));
    
    System.out.print("The area of your sphere is: " + (float)
        sphereArea);
  }
//***************************************************************************** 
/**
 * Calls the method and brings up a simple menu. one option is area and the 
 * other is volume. Once the user picks an option the calculations can begin.
 * 
 *  
 * @return goToCube - calculates area and volume for a shape
 */ 
	public static void goToCube() {
    Scanner scanner = new Scanner(System.in);
    int userInput = 0;
    
    System.out.println("\nYou may choose to calculate Volume or Area. "
        + "\nYour options are: \n");
    System.out.println("Press 1 for Volume. \nPress 2 for Area. ");
    
    boolean gottenGoodInput = false;    
    while (gottenGoodInput == false){    
      try {
        System.out.println("Enter your response here: ");
        userInput = scanner.nextInt();
        gottenGoodInput = true;
      }
      catch (Exception ex){
        System.out.println("Incorrect input. Please enter only number "
            + "1 or 2. ");
        scanner.next();
      }
    }
    
    
//*********************************** - Volume Cube  
    switch (userInput){
    case 1: //Volume
      System.out.println("We will calculate the volume of a cube for you.\n"
          + "Enter each of the sides of the cube \n");
        
      double length = 0;
      double width = 0;
      double height = 0;
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the length: ");
          length = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      }
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the width: ");
          width = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("That's not right. Please enter a number.");
          scanner.next();
        }
      }
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the height: ");
          height = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      }
      calculateCubeVolume(length, width, height);
      getThankYou();
 
    break;
//************************ - Area Cube  
    case 2: //Area
      System.out.println("We will calculate the area of a cube for you. "
          + "Enter the length of one side. ");
      
      double side = 0;
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the length of one side: ");
          side = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      } 
      
    calculateCubeArea(side);
    getThankYou();
    break;
    
    default:
     System.out.println("You were supposed to enter a number 1 or 2."
         + " Please run the program again. ");
     break;
    }
  }

//*****************************************************************************	
	private static void calculateCubeVolume(double length, double width, 
			double height) {				
		double cubeVolume = length * width * height;
		
		System.out.println("The volume of your cube is " + cubeVolume);
			                
	}
	
	private static void calculateCubeArea(double side) { 
    double CubeArea = (6) * (Math.pow(side, 2));
    
    System.out.print("The area of your cube is: " + (float)
        CubeArea);
  }
//*****************************************************************************
/**
 * Calls the method and brings up a simple menu. one option is area and the 
 * other is volume. Once the user picks an option the calculations can begin.
 * 
 *  
 * @return goToCone - calculates area and volume for a shape
 */
	public static void goToCone() {
    Scanner scanner = new Scanner(System.in);
    int userInput = 0;
    
    System.out.println("\nYou may choose to calculate Volume or Area. "
        + "\nYour options are: \n");
    System.out.println("Press 1 for Volume. \nPress 2 for Area. ");
    
    boolean gottenGoodInput = false;    
    while (gottenGoodInput == false){    
      try {
        System.out.println("Enter your response here: ");
        userInput = scanner.nextInt();
        gottenGoodInput = true;
      }
      catch (Exception ex){
        System.out.println("Incorrect input. Please enter only number "
            + "1 or 2. ");
        scanner.next();
      }
    }
    
    
//*********************************** - Volume Cone
    switch (userInput){
    case 1: //Volume
      System.out.println("We will calculate the volume of a cone for you.\n"
          + "Enter each of the sides of the cone \n");   
      
      double radius = 0;
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the radius of the cone: ");
          radius = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      } 
      
      double height = 0;
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the height: ");
          height = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Nice try slick. Please enter a number.");
          scanner.next();
        }
      }
        
      calculateConeVolume(radius, height);
      getThankYou();
      
    break;
//************************ - Area Cone 
    case 2: //Area
      System.out.println("The area of a cone is too complicated to calculate"
          + " ths way... my apologies. "); 
    getThankYou();
    break;
    
    default:
     System.out.println("You were supposed to enter a number 1 or 2."
         + " Please run the program again. ");
     break;
    }
  }
	
//*****************************************************************************

	private static void calculateConeVolume(double radius, double height) {
		double coneVolume = Math.PI * (Math.pow(radius, 2)) * (height/3);
		
		System.out.println("The volume of your cone is " + (float)coneVolume);
	}
//*****************************************************************************	
/**
 * Calls the method and brings up a simple menu. one option is area and the 
 * other is volume. Once the user picks an option the calculations can begin.
 * 
 *  
 * @return goToPyramid - calculates area and volume for a shape
 */
	public static void goToPyramid() {
    Scanner scanner = new Scanner(System.in);
    int userInput = 0;
    
    System.out.println("\nYour options are: \n");
    System.out.println("Press 1 for Volume. \nPress 2 for Area. ");
    
    boolean gottenGoodInput = false;    
    while (gottenGoodInput == false){    
      try {
        System.out.println("Enter your response here: ");
        userInput = scanner.nextInt();
        gottenGoodInput = true;
      }
      catch (Exception ex){
        System.out.println("Incorrect input. Please enter only number "
            + "1 or 2. ");
        scanner.next();
      }
    }
    
//*********************************** - Pyramid Volume   
    switch (userInput){
    case 1: //Volume
      System.out.println("We will calculate the volume of a pyramid"
          + " for you.\nEnter each of the sides of the pyramid \n");   
      
      double length = 0;
      double width = 0;
      double height = 0;
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the base length: ");
          length = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      }
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the base width: ");
          width = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Nice try there, I see you."
              + " but for real though just enter a number.");
          scanner.next();
        }
      } 
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the height: ");
          height = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Oh I get it you're just trying to be funny"
              + "... \nI'll just keep on reminding you to enter a "
              + "number so we can both get on with our lives. ");
          scanner.next();
        }
      } 
      
      calculatePyramidVolume(length, width, height);
      getThankYou();
      break;
//*********************************** - Pyramid Area   
      case 2: //Area
        System.out.println("The area of a pyramid is too complicated to "
            + "calculate ths way... my apologies. "); 
    getThankYou();
      break;
  
      default:
        System.out.println("You were supposed to enter a number 1 or 2."
          + " Please run the program again. ");
      break;
     }
  }
//*****************************************************************************
	private static void calculatePyramidVolume(double length, double width, 
			double height) {
		double pyramidVolume = (length * width * height)/3;
		
		System.out.println("The volume of your pyramid is " + (float)
				pyramidVolume);	
	}
//*****************************************************************************
	/**
	 * Calls the method and brings up a simple menu. one option is area and the 
	 * other is volume. Once the user picks an option the calculations can begin.
	 * 
	 *  
	 * @return goToCylinder - calculates area and volume for a shape
	 */
	public static void goToCylinder() {
    Scanner scanner = new Scanner(System.in);
    int userInput = 0;
    
    System.out.println("\nYour options are: \n");
    System.out.println("Press 1 for Volume. \nPress 2 for Area. ");
    
    boolean gottenGoodInput = false;    
    while (gottenGoodInput == false){    
      try {
        System.out.println("Enter your response here: ");
        userInput = scanner.nextInt();
        gottenGoodInput = true;
      }
      catch (Exception ex){
        System.out.println("Incorrect input. Please enter only number "
            + "1 or 2. ");
        scanner.next();
      }
    }
    
//*********************************** - Cylinder Volume   
    switch (userInput){
    case 1: //Volume
    
      System.out.println("We will calculate the volume of a cylinder"
          + " for you. \nEnter each of the sides of the cylinder. \n");  
      
      double radius = 0;
      double height = 0;
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the radius of the cylinder: ");
          radius = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      }   
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the height: ");
          height = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("I already told your friend, he finally "
              + "figured it out... I think. \nAll you have to do is "
              + "enter a number. Is that so hard? ");
          scanner.next();
        }
      }   
        
      calculateCylinderVolume(radius, height);    
      getThankYou();
      break;
    
//*********************************** - Cylinder area 
    case 2: // Area
      System.out.println("We will calculate the area of a cylinder"
          + " for you. \nEnter each of the sides of the cylinder. \n");  
      
      radius = 0;
      height = 0;
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the radius of the cylinder: ");
          radius = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Please enter a number.");
          scanner.next();
        }
      }   
      
      gottenGoodInput = false;    
      while (gottenGoodInput == false){   
        try {
          System.out.println("Enter the height: ");
          height = scanner.nextDouble();
          gottenGoodInput = true;
        }
        catch (Exception ex){
          System.out.println("Incorrect input. Enter a number.");
          scanner.next();
        }
      }
    calculateCylinderArea(radius, height);
    getThankYou();
    break;
      
    default:
      System.out.println("You were supposed to enter a number 1 or 2."
        + " Please run the program again. ");
    break;
    }   
  }
//*****************************************************************************	
	private static void calculateCylinderVolume(double radius, double height) {
		double cylinderVolume = Math.PI * (Math.pow(radius, 2)) * height;
		
		System.out.println("The volume of your cylinder is " + 
		(float)cylinderVolume);	
	}
	
	private static void calculateCylinderArea(double radius, double height) {
    double cylinderVolume = ((2 * Math.PI) * (radius * height) ) + 
        ((2 * Math.PI) * (Math.pow(radius, 2)));
    
    System.out.println("The area of your cylinder is " + 
    (float)cylinderVolume); 
  }
	
	
}