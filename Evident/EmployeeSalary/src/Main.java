import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().Start();
	}
	public void Start() throws IOException {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the path to the CSV:");
		String path = scan.nextLine().trim();
		
		HandleData handle = new HandleData();
		handle.ReadIn(path);
		
		while(true) {
			System.out.print("Please enter whether you would like the TOTAL SALARIES or the SALARIES BY ROLE or enter DONE to end:");
			String calc = scan.nextLine();
			if(calc.toLowerCase().equals("done")) {
				break;
			}
			handle.Calculate(calc);
		}
	}
	
	

}
