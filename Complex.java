package eecs2030.lab3;

import java.math.MathContext;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A class that represents immutable complex numbers.
 * 
 * @author EECS2030 Fall 2019
 * 
 */
public final class Complex {
	
	private double im;
	
	private double re;
	
	public static final Complex ONE = new Complex(1.0,0.0);
	
	public static final Complex I = new Complex (0.0, 1.0);
	
	/**
	 * Initializes this complex number to <code>0 + 0i</code>.
	 * 
	 */
	public Complex() {
		
	}

	/**
	 * Initializes this complex number so that it has the same real and
	 * imaginary parts as another complex number.
	 * 
	 * @param other
	 *            the complex number to copy.
	 */
	public Complex(Complex other) {
		
		this.im = other.im();
		this.re = other.re();
	}

	/**
	 * Initializes this complex number so that it has the given real
	 * and imaginary components.
	 * 
	 * @param re
	 *            the real part of the complex number.
	 * @param im
	 *            the imaginary part of the complex number.
	 */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/**
	 * A static factory method that returns a new complex number whose real part
	 * is equal to re and whose imaginary part is equal to 0.0
	 * 
	 * @param re
	 *            the desired real part of the complex number
	 * @return a new complex number whose real part is equal to re and whose
	 *         imaginary part is equal to 0.0
	 */
	public static Complex real(double re) {
		return new Complex(re, 0);
	}

	/**
	 * A static factory method that returns a new complex number whose real part
	 * is equal to 0.0 and whose imaginary part is equal to im
	 * 
	 * @param im
	 *            the desired imaginary part of the complex number
	 * @return a new complex number whose real part is equal to 0.0 and whose
	 *         imaginary part is equal to im
	 */
	public static Complex imag(double im) {
		
		return new Complex(0,im);
	}

	/**
	 * Get the real part of the complex number.
	 * 
	 * @return the real part of the complex number.
	 */
	public double re() {
		
		return this.re;
	}

	/**
	 * Get the imaginary part of the complex number.
	 * 
	 * @return the imaginary part of the complex number.
	 */
	public double im() {
		
		return this.im;
	}

	/**
	 * Add this complex number and another complex number to obtain a new
	 * complex number. Neither this complex number nor c is changed by
	 * this method.
	 * 
	 * @param c
	 *            The complex number to add to this complex number.
	 * @return a new Complex number equal to the sum of this complex number and
	 *         c.
	 */
	public Complex add(Complex c) {
		double newReal = this.re + c.re;
		double newIma = this.im + c.im;
		return new Complex(newReal, newIma);
	}

	/**
	 * Multiply this complex number with another complex number to obtain a new
	 * complex number. Neither this complex number nor c is changed by
	 * this method.
	 * 
	 * <p>
	 * This is not an industrial strength implementation of complex number
	 * multiplication. In particular, issues related to the differences between
	 * <code>-0.0</code> and <code>0.0</code> and infinite real or imaginary
	 * parts are not taken into account.
	 * 
	 * @param c
	 *            The complex number to multiply by.
	 * @return a new Complex number equal to this complex number multiplied by
	 *         c.
	 */
	public Complex multiply(Complex c) {
		double re1 = this.re;
		double im1 = this.im;
		double re2 = c.re;
		double im2 = c.im;
		double realAns = (re1*re2) - (im1*im2);
		double imaAns = (im1*re2) + (re1*im2);
		return new Complex(realAns,imaAns);
		
	}

	/**
	 * Compute the magnitude of this complex number.
	 * 
	 * @return the magnitude of this complex number.
	 */
	public double mag() {
		double re = this.re;
		double im = this.im;
		return Math.hypot(re, im);
	}

	/**
	 * Return a hash code for this complex number.
	 * 
	 * <p>
	 * This implementation uses a very crude algorithm to compute
	 * the hash code; the hash code is computed as follows:
	 * 
	 * <ol>
	 * <li>compute the value equal to <code>9999</code> times the real part
	 *     of this complex number
	 * <li>compute the value equal to <code>99</code> times the imaginary part
	 *     of this complex number
	 * <li>compute the sum of the values computed in Steps 1 and 2
	 * <li>casts the value computed in Step 3 to an <code>int</code>
	 * <li>returns the value computed in Step 4
	 * </ol>
	 * 
	 * <p>
	 * In production code, consider implementing hashCode() using
	 * {@link java.util.Objects#hash}
	 * 
	 * @return a hash code value for this complex number.
	 */
	@Override
	public int hashCode() {
		double part1 = this.re * 9999;
		double part2 = this.im * 99;
		double part3 = part1 + part2;
		int part3int = (int) part3;
		return part3int;
	}

	/**
	 * Compares this complex number with the specified object. The result is
	 * <code>true</code> if and only if the argument is a <code>Complex</code>
	 * number with the same real and imaginary parts as this complex number.
	 * 
	 * @param obj
	 *            the object to compare this Complex number against.
	 * @return true if the given object is a Complex number equal to this
	 *         complex number, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} 
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Complex other = (Complex) obj;
		return (this.re() == other.re() && this.im() == other.im());
	}

	/**
	 * Returns a string representation of this complex number.
	 * 
	 * <p>
	 * The returned string is the real part of the complex number, followed by a
	 * space, followed by a <code>+</code> or <code>-</code> sign, followed by a
	 * space, followed by the absolute value of the imaginary part of the
	 * complex number, followed by an <code>i</code>. The sign is <code>+</code>
	 * if the imaginary part of the complex number is positive, and
	 * <code>-</code> if the imaginary part of the complex number is negative.
	 * 
	 * For example the complex number with real and imaginary parts equal to
	 * zero has the string representation <code>0.0 + 0.0i</code>. The complex
	 * number with real part equal to zero and imaginary part equal to
	 * <code>-1</code> has the string representation <code>0.0 - 1.0i</code>.
	 * 
	 * @return a string representation of this complex number.
	 * 
	 */
	@Override
	public String toString() {
		String x = Math.abs(this.im()) + "";
		String y = this.re() + "";
		if (this.im() < 0) {
			return (y + " - " + x + "i");
		} else {
			return (y + " + " + x + "i");
		}
	}

	/**
	 * Returns a complex number holding the value represented by the given
	 * string.
	 * 
	 * <p>
	 * <code>valueOf</code> tries to create a complex number from a string
	 * representation of the complex number. Strings that can interpreted as
	 * complex numbers are those strings returned by
	 * <code>Complex.toString</code>.
	 * 
	 * @param s
	 *            a string representation of a complex number.
	 * @return a Complex number equal to the complex number represented by the
	 *         given string.
	 * @throws IllegalArgumentException
	 *             if the string cannot be interpreted as a complex number.
	 * @pre. s has a space before and after the + or - sign separating the
	 *       real and imaginary parts of the complex number
	 */
	public static Complex valueOf(String s) {
		boolean isTrue = false;
		Complex result = null;
		Double d = 0.0;
		String t = s.trim();
		List<String> parts = Arrays.asList(t.split("\\s+"));
		if (parts.size() == 3) {
			try {
				d = Double.parseDouble(parts.get(0));
				isTrue = true;
			} catch (NumberFormatException e) {
				isTrue = false;
				throw new IllegalArgumentException();
			}
			if ((parts.get(1).equals("+") || parts.get(1).equals("-")) && parts.get(2).endsWith("i") && isTrue) {
				String x = parts.get(2).substring(0, parts.get(2).length() - 1);
				Double im = Double.parseDouble(x);
				if (parts.get(1).equals("-")) {
					im = im * -1;
					result = new Complex(d,im);
				} else if (parts.get(1).equals("+")) {
					result = new Complex(d,im);
				}
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
		return result;
	}
}
//split splits the string s by looking for spaces in s.
		// If s is a string that might be interpreted as a complex number
		// then parts will be a list having 3 elements. The first
		// element will be a real number, the second element will be
		// a plus or minus sign, and the third element will be a real
		// number followed immediately by an i.
		//
		// To complete the implementation of this method you need
		// to do the following:
		//
		// -check if parts has 3 elements
		// -check if the second element of parts is "+" or "-"
		// -check if the third element of parts ends with an "i"
		// -if any of the 3 checks are false then s isn't a complex number
		//  and you should throw an exception
		// -if all of the 3 checks are true then s might a complex number
		// -try to convert the first element of parts to a double value
		//  (use Double.valueOf); this might fail in which case s isn't
		//  a complex number
		// -remove the 'i' from the third element of parts and try
		//  to convert the resulting string to a double value
	    //  (use Double.valueOf); this might fail in which case s isn't
		//  a complex number
		// -you now have real and imaginary parts of the complex number
		//  but you still have to account for the "+" or "-" which
		//  is stored as the second element of parts
		// -once you account for the sign, you can return the correct
		//  complex number
