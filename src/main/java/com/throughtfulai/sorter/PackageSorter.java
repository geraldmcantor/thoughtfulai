package com.throughtfulai.sorter;

public interface PackageSorter {
	public static final String STANDARD = "STANDARD";
	public static final String SPECIAL = "SPECIAL";
	public static final String REJECTED = "REJECTED";

	/**
	 * Return a package's sorting classification.
	 * <p>
	 * @param width  the width of the package in cm
	 * @param height the height of the package in cm
	 * @param length the length of the package in cm
	 * <p>
	 * @return the sorting classification
	 * @throws IllegalArgumentException if the supplied parameters are less than or equal to 0
	 */
	public String sort(double width, double height, double length, double mass) throws IllegalArgumentException;

	// Note that by defining the additional method signatures for determining
	// if a package is bulky or heavy, implementing classes can choose a different
	// approach.

	/**
	 * Determine if a package is bulky.
	 * <p>
	 * @param width  the width of the package in cm
	 * @param height the height of the package in cm
	 * @param length the length of the package in cm
	 * <p>
	 * @return true if the package is bulky, false otherwise
	 * @throws IllegalArgumentException if the supplied parameters are less than or equal to 0
	 */
	public boolean isBulky(double width, double height, double length) throws IllegalArgumentException;

	/**
	 * Determine if a package is heavy.
	 * <p>
	 * @param mass the mass of the package in kg
	 * <p>
	 * @return true if the package is heavy, false otherwise
	 * @throws IllegalArgumentException if the supplied parameter is less than or equal to 0
	 */
	public boolean isHeavy(double mass) throws IllegalArgumentException;

}
