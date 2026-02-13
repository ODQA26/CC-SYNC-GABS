package GabsSync.GabsSync;

import java.util.List;

public class VehicleData {

	// string fields
	private String stock;
	private String make;
	private String model;
	private String chassis;
	private String regMonth;
	private String lastYear;
	private String enginC;
	private String colur;
	private String mileage;
	private String fuel;
	private String transmission;
	private String grade;
	private String driveCode;
	private String wheelDrive;
	// numeric fields
	private int doors;
	private int seats;
	private int length;
	private int width;
	private int height;
	private double volumeM3;
	private List<String> crfImages;

	// constructors
	public VehicleData(String stock, String make, String model, String chassis, String regMonth, String lastYear,
			String enginC, String colur, String mileage, String fuel, String transmission, String grade,
			String driveCode, String wheelDrive, int doors, int seats, int length, int width, int height,
			double volumeM3, List<String> crfImages

	) {
		this.stock = stock;
		this.make = make;
		this.model = model;
		this.chassis = chassis;
		this.regMonth = regMonth;
		this.lastYear = lastYear;
		this.enginC = enginC;
		this.colur = colur;
		this.mileage = mileage;
		this.fuel = fuel;
		this.transmission = transmission;
		this.grade = grade;
		this.driveCode = driveCode;
		this.wheelDrive = wheelDrive;
		this.doors = doors;
		this.seats = seats;
		this.length = length;
		this.width = width;
		this.height = height;
		this.volumeM3 = volumeM3;
		this.crfImages = crfImages;
	}

	// getters
	public String getStock() {
		return stock;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getChassis() {
		return chassis;
	}

	public String getRegMonth() {
		return regMonth;
	}

	public String getlastYear() {
		return lastYear;
	}

	public String getEnginC() {
		return enginC;
	}

	public String getColur() {
		return colur;
	}

	public String getMileage() {
		return mileage;
	}

	public String getFuel() {
		return fuel;
	}

	public String getTransmission() {
		return transmission;
	}

	public String getGrade() {
		return grade;
	}

	public String getDrive() {
		return driveCode;
	}

	public String getWheelDrive() {
		return wheelDrive;
	}

	public int getDoors() {
		return doors;
	}

	public int getSeats() {
		return seats;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public double getVolumeM3() {
		return volumeM3;
	}

	public List<String> getCrfImages() {
		return crfImages;
	}

	@Override
	public String toString() {
		return "VehicleData {" + "stock='" + stock + '\'' + ", make='" + make + '\'' + ", model='" + model + '\''
				+ ", chassis='" + chassis + '\'' + ", regMonth='" + regMonth + '\'' + ", lastYear='" + lastYear + '\''
				+ ", enginC='" + enginC + '\'' + ", colur='" + colur + '\'' + ", mileage='" + mileage + '\''
				+ ", fuel='" + fuel + '\'' + ", transmission='" + transmission + '\'' + ", grade='" + grade + '\''
				+ ", driveCode='" + driveCode + '\'' + ", wheelDrive='" + wheelDrive + '\'' + ", doors=" + doors
				+ ", seats=" + seats + ", length=" + length + ", width=" + width + ", height=" + height + ", volumeM3="
				+ volumeM3 + '}';
	}
}
