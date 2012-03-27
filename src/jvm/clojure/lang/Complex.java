/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

/* Andrea Chiavazza Mar 26, 2012 */

package clojure.lang;

public class Complex {
	public final Number real;
	public final Number imaginary;
	
	public Complex(Number real, Number imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public String toString() {
		// the parenthesis make the number able to be just inserted in expressions
		return "(" + real + (Numbers.isPos(imaginary) ? " +" : " ") + imaginary + "i)";
	}

	public int hashCode() {
		return real.hashCode() ^ imaginary.hashCode();
	}

	public boolean equals(Object obj) {
		return (obj instanceof Complex) &&
				(((Complex) obj).real).equals(real) &&
				(((Complex) obj).imaginary).equals(imaginary);
	}
}
