;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns ^{:doc "Math operations."
      :author "Andrea Chiavazza"}
  clojure.math)

(defn abs
  "Absolute value in the complex domain."
  {:added "1.4"}
  [x]
  (if (complex? x)
    (Math/hypot (real x) (imaginary x))
    (Math/abs x)))

(defn arg
  "Argument of a complex number."
  {:added "1.4"}
  [x]
  (Math/atan2 (imaginary x) (real x)))

(defn complex-polar
  "Complex number defined by its modulus and its argument."
  {:added "1.4"}
  [modulus argument]
  (complex (* modulus (Math/cos modulus)) (* modulus (Math/sin argument))))

(defn sqrt
  "Square root in the complex domain."
  {:added "1.4"}
  [x]
  (if (complex? x)
    (let [r (real x)
          i (imaginary x)
          det (Math/hypot r i)]
      (complex
        (Math/sqrt (/ (+ det r) 2))
        (let [t (Math/sqrt (/ (- det r) 2))]
          (if (neg? i)
            (- t)
            t))))
    (if (neg? x)
      (complex 0 (Math/sqrt (- x)))
      (Math/sqrt x))))
