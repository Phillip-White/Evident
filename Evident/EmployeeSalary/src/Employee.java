
public class Employee {
	private String Name;
	private double Rate;
	private double Hours;
	private String Role;
	private double Salary;
	
	public Employee(String name, String rate, String hours, String role) {
		this.setName(name);
		this.setRate(rate);
		this.setHours(hours);
		this.setRole(role);
		this.setSalary(calcSal());
	}

	private void setSalary(double salary) {
		this.Salary = salary;
	}

	private double calcSal() {
		double sal = 0;
		if(this.Role.toLowerCase().equals("contract")) {
			sal += 10000;
		}
		//round to second decimal
		sal += this.Rate * this.Hours;
		sal *= 100;
		sal = Math.round(sal);
		sal /= 100;
		if(this.Role.toLowerCase().equals("full time") && sal > 50000) {
			sal = 50000;
		}
		return sal;
	}

	public String getName() {
		return Name;
	}

	private void setName(String name) {
		this.Name = name;
	}

	public double getRate() {
		return Rate;
	}

	private void setRate(String rate) {
		double r = Double.parseDouble(rate);
		//round to second decimal
		r = (r * 100);
		r = Math.round(r);
		r = r / 100;
		this.Rate = r;
	}

	public double getHours() {
		return Hours;
	}

	private void setHours(String hours) {
		this.Hours = Double.parseDouble(hours);
	}

	public String getRole() {
		return Role;
	}

	private void setRole(String role) {
		this.Role = role;
	}

	public double getSalary() {
		return Salary;
	}

}
