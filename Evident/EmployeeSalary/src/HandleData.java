import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HandleData {
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public void ReadIn(String path) throws IOException {
		
		BufferedReader read = null;
		try {
			read = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.out.print("Invalid path! Please try again");
			new Main().Start();
		}
		
		String data = read.readLine();
		
		while (data != null) {
			
			String[] col = data.split(",");
			Employee emp = new Employee(col[0], col[1], col[2], col[3]);
			employees.add(emp);
			data =read.readLine();
		}
		
		
	}

	public void Calculate(String calc) {
		if(calc.toLowerCase().trim().equals("total salaries")) {
			this.TotSal();
		}
		else if(calc.toLowerCase().trim().equals("salaries by role")) {
			this.RoleSal();
		}
		else {
			Scanner scan = new Scanner(System.in);
			System.out.print("Please try again! \n");
			System.out.print("Please enter whether you would like the TOTAL SALARIES or the SALARIES BY ROLE:");
			String again = scan.nextLine();
			Calculate(again);
		}
	}

	private void RoleSal() {
		double part = 0;
		double full = 0;
		double con = 0;
		
		for(int i = 0; i < employees.size(); i++) {
			Employee emp = employees.get(i);
			String role = emp.getRole();
			
			if(role.toLowerCase().equals("full time")) {
				full += emp.getSalary();
			}
			else if(role.toLowerCase().equals("part time")) {
				part += emp.getSalary();
			}
			else {
				con += emp.getSalary();
			}
		}
		
		//Guarantee two decimals
		String p = String.format("%.02f", part);
		String f = String.format("%.02f", full);
		String c = String.format("%.02f", con);	
		
		System.out.print("The salaries of each role are: \n PART TIME : $" + p + "\n FULL TIME: $" + f + "\n CONTRACT : $" + c + "\n");
		
	}

	private void TotSal() {
		double tot = 0;
		for(int i = 0; i < employees.size(); i++) {
			Employee emp = employees.get(i);
			tot += emp.getSalary();
		}
		
		String t = String.format("%.02f", tot);
		System.out.print("The total of all employee salaries is: $" + t + "\n");
	}

}
