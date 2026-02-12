package GabsSync.GabsSync;

public class VehicleComparator {

	public static void compare(VehicleData cc, VehicleData gabs) {

		System.out.println("\n🔍 Comparing stock: " + cc.getStock());

		compareField("Make", cc.getMake(), gabs.getMake());
		compareField("Model", cc.getModel(), gabs.getModel());
		compareField("Grade", cc.getGrade(), gabs.getGrade());
		compareField("Drive", cc.getDrive(), gabs.getDrive());
		compareField("Wheel Drive", cc.getWheelDrive(), gabs.getWheelDrive());
		compareField("Fuel", cc.getFuel(), gabs.getFuel());
		compareField("color", cc.getColur(), gabs.getColur());
		compareField("Mileage", cc.getMileage(), gabs.getMileage());
		compareField("Transmission", cc.getTransmission(), gabs.getTransmission());

		compareField("Register Year", normalizeYear(cc.getRegMonth()), normalizeYear(gabs.getlastYear()));

		compareField("Manufacture Year", normalizeYear(cc.getlastYear()), normalizeYear(gabs.getRegMonth()));

		compareField("Engine CC", normalizeNumber(cc.getEnginC()), normalizeNumber(gabs.getEnginC()));

		compareField("Chassis", cc.getChassis(), gabs.getChassis());
		compareField("Seat", String.valueOf(cc.getSeats()), String.valueOf(gabs.getSeats()));

		if (Math.abs(cc.getVolumeM3() - gabs.getVolumeM3()) <= 0.1) {
			System.out.println("✅ Volume matched");
		} else {
			System.out.println("❌ Volume mismatch | CC: " + cc.getVolumeM3() + " | GABS: " + gabs.getVolumeM3());
		}
	}

	private static void compareField(String field, String ccVal, String gabsVal) {
		if (ccVal.equalsIgnoreCase(gabsVal)) {
			System.out.println("✅ " + field + " matched");
		} else {
			System.out.println("❌ " + field + " mismatch | CC: " + ccVal + " | GABS: " + gabsVal);
		}
	}

	private static String normalizeNumber(String val) {
		return val.replaceAll("[^0-9]", "");
	}

	private static String normalizeYear(String val) {
		return val.replaceAll("[^0-9]", "");
	}

}