package ExceptionHandling;

import java.util.Scanner;

public class DriverLicense {
	
	public static void main(String [] args) {
		DriverLicense dl = new DriverLicense();
		dl.startProcess();
	}
	
	private void startProcess() {
		for(int i =0;i<3;i++) {
			System.out.println("Welcome to the driving center, please enter age for eligibily.");
			Scanner sc =  new Scanner(System.in);
			Integer age = sc.nextInt();
			DriverManager manager = new DriverManager();
			boolean eligible = false;
			try {
				eligible = manager.findAge(age);
				System.out.println("You are eligible for the license :)");
				break;
			}catch(UnderAgeException under){
				
				//Another way to express exception
				//System.err.println(under);
				
				System.out.println(under.getMessage());
				System.out.println();
				
			}catch(OverAgeException over) {
				//System.err.println(over);
				
				System.out.println(over.getMessage());
				System.out.println();
				
			}finally {
				if(i==2 && eligible==false) {
					System.out.println("Please try again another day.Thank you!");
					break;
				}
			}
			
		}
	}
	
}

class DriverManager {
	
	public boolean findAge(Integer age) throws UnderAgeException, OverAgeException {
		if(age>=18 && age<=60) {
			return true;
		}else if(age<18){
			throw new UnderAgeException();
		}else {
			throw new OverAgeException();
		}
	}
}

class UnderAgeException extends Exception{
	public String getMessage() {
		return "You are under the age limit.";
	}
}

class OverAgeException extends Exception{
	public String getMessage() {
		return "You are over the age limit.";
	}
}
