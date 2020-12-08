package JavaActivity1;

public class Car {
	
	String Color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	public Car() {
		tyres=4;
		doors=4;
	
		
	}

	public void displayCharacteristics() {
		System.out.println("Color of the Car: "+Color);
		System.out.println("Transmission of the Car:" +transmission);
		System.out.println("Make of the Car: " +make);
		System.out.println("Number of tyres on the car: " +tyres);
		System.out.println("Number of doors on the car: " +doors);
		
	}
	
	public void accelarate() {
		System.out.println("Car is moving forward");
		
	}
	
	public void brake() {
		System.out.println("Car has stopped");
		
	}
	
	
}
