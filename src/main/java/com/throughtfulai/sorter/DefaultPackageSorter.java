package com.throughtfulai.sorter;

public class DefaultPackageSorter implements PackageSorter {

	@Override
	public String sort(double width, double height, double length, double mass) throws IllegalArgumentException {
		// Start optimistically
		String packageClassification = PackageSorter.STANDARD;

		// Is the package bulky
		boolean isBulky = isBulky(width, height, length);

		// Is the package heavy
		boolean isHeavy = isHeavy(mass);

		if (isBulky && isHeavy) {
			packageClassification = PackageSorter.REJECTED;
		} else if (isBulky || isHeavy) {
			packageClassification = PackageSorter.SPECIAL;
		}

		return packageClassification;
	}

	@Override
	public boolean isBulky(double width, double height, double length) throws IllegalArgumentException {
		// Check validity of arguments. LTE zero are invalid.
		if (width <= 0 || height <= 0 || length <= 0) {
			throw new IllegalArgumentException("Invalid argument(s).");
		}

		// Default implementation specifies if package has volume GTE than 1000000 cm3 or
		// one of the dimensions is GTE 150 cm, it is bulky
		double volume = width * height * length;

		return volume >= 1000000 || (width >= 150 || height >= 150 || length >= 150);
	}

	@Override
	public boolean isHeavy(double mass) throws IllegalArgumentException {
		// Check validity of arguments. LTE zero are invalid.
		if (mass <= 0) {
			throw new IllegalArgumentException("Invalid argument(s).");
		}

		// Default implementation specifies if package has mass >= 20, it is heavy
		return mass >= 20;
	}
}
