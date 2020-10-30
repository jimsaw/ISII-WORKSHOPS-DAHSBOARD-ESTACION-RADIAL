package ec.edu.espol.workshops.second;

import javax.swing.JOptionPane;

public class CarInsurance {
	
	private int edad;
	private String sexo;
	private boolean isMarried; //True: isMarried, False: is not married
	private String ci;
	
	
	public CarInsurance(String edad, String sexo, String isMarried, String ci) {
		this.edad = Integer.parseInt(edad);
		this.sexo = sexo;
		if(isMarried.equals("y")) {
			this.isMarried = true;	
		}else {
			this.isMarried = false;
		}
		this.ci = ci;
		
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
	
	public boolean validDrivingLicense(){
		
		if(this.ci.length() == 10) {
			try {
				Integer.parseInt(this.ci);
				return true;
			} catch (NumberFormatException nfe){
				return false;
			}
		}
		
		return false;
	}
	
	public int calculatePremium() {
		int base = 500;
		if(this.edad > 80) {
			JOptionPane.showMessageDialog(null, "Edad no es permitida para otorgarle un seguro");
			return -1;
		}
		if(!this.validDrivingLicense()) {
			JOptionPane.showMessageDialog(null, "Licencia no válida");
			return -1;
		}
		if(this.sexo == "M" && !this.isMarried && this.edad<25) {
			base += 1500;
		}
		if(this.sexo == "F" || this.isMarried) {
			base-=200;
		}
		if(this.edad>=45 && this.edad<65) {
			base-=100;
		}
		return base;
	}
	
	public static void main(String[] args) {
		
		String edad, sexo, isMarried, ci;
		
		edad = JOptionPane.showInputDialog("Ingrese su edad: ");
		sexo = JOptionPane.showInputDialog("Ingrese su sexo(F/M): ");
		isMarried = JOptionPane.showInputDialog("Se encuentra casado(a) (y/n): ");
		ci = JOptionPane.showInputDialog("Ingrese su número de cédula: ");	
		
		CarInsurance cInsurance = new CarInsurance(edad, sexo, isMarried, ci);
		
		int valor = cInsurance.calculatePremium();
		String mensaje = "";
		if(valor != -1) {
			mensaje = "Su prima es de "+ valor;
		}else {
			mensaje = "Seguro no otorgado ";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
}

