package ec.edu.espol.workshops.second;

import javax.swing.JOptionPane;

public class CarInsurance {
	
	private int edad;
	private String sexo;
	private boolean isMarried; //True: isMarried, False: is not married
	private final String ci;
	
	
	public CarInsurance(String edad, String sexo, String isMarried, String ci) { //Class of a Car Insurance
		int validator = validateage(edad);
		
		if(validator == 1) {
		
			this.edad = Integer.parseInt(edad);
			this.sexo = sexo;
	
			if(isMarried.equals("y") || isMarried.equals("yes") || isMarried.equals("YES")  || isMarried.equals("Yes")) {
	
				this.isMarried = true;	
			} else {
				this.isMarried = false;
			}
			this.ci = ci;
		}else {
			this.edad = 0;
			this.sexo = "";
			this.isMarried = false;
			this.ci = "";
		}
		
	}
	
	public int validateage(String age) {
		try {
		    Integer.parseInt(age);
		} catch (NumberFormatException e) {
		    return -1;
		}
		return 1;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public boolean getEstadoCivil() {
		return isMarried;
	}
	
	public void setEstadoCivil(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	public boolean validDrivingLicense() { //method to validate if the driving license
		
		if(this.ci.length() == 10) {
			try {
				Integer.parseInt(this.ci);
				return true;
			} catch (NumberFormatException nfe) {
				return false;
			}
		}
		
		return false;
	}
	
	public int calculatePremium() { //Method to calculate the premium value
		int base = 500;//first business rule
		if (!(this.sexo.equals("F")) && !(this.sexo.equals("M"))) {
			JOptionPane.showMessageDialog(null, "Sexo ingresado no es valido");
			return -1;
		}
		if (this.edad == 0) {
			JOptionPane.showMessageDialog(null, "Edad ingresada no es valida, utilice un numero");
			return -1;
		}
		if (this.edad > 80) {
			JOptionPane.showMessageDialog(null, "Edad no es permitida para otorgarle un seguro");
			return -1;
		}
		if(!this.validDrivingLicense()) {
			JOptionPane.showMessageDialog(null, "Licencia no v�lida");
			return -1;
		}
		if( "M".equals(this.sexo) && !this.isMarried && this.edad<25) { //second business rule
			base += 1500;
		}
		if("F".equals(this.sexo) || this.isMarried) { //third business rule
			base-=200;
		}
		if(this.edad>=45 && this.edad<65) { //fourth business rule
			base-=100;
		}
		if("M".equals(this.sexo) && this.edad>25 && this.edad<45) {//New business rule required #1
			base-=100;
		}
		return base;
	}
	
	public static void main(String[] args) {
		
		String edad, sexo, isMarried, ci;
		
		edad = JOptionPane.showInputDialog("Ingrese su edad: ");
		sexo = JOptionPane.showInputDialog("Ingrese su sexo(F/M): ");
		isMarried = JOptionPane.showInputDialog("Se encuentra casado(a) (y/n): ");
		ci = JOptionPane.showInputDialog("Ingrese su n�mero de c�dula: ");	
		
		String errmsg;
		if(!isMarried.equals("y") && !isMarried.equals("n")) {
			errmsg = "Estado civil ingresado no valido";
			JOptionPane.showMessageDialog(null, errmsg);
			System.exit(0);  
		}
		
		CarInsurance cInsurance = new CarInsurance(edad, sexo, isMarried, ci);
		
		int valor = cInsurance.calculatePremium();
		String mensaje;
		if(valor != -1) {
			mensaje = "Su prima es de "+ valor;
		}else {
			mensaje = "Seguro no otorgado ";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
}

