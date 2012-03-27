;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

;; Author: Andrea Chiavazza


(ns clojure.test-clojure.clojure-math
  (:use clojure.test)
  (:require [clojure.math :as math]))

(deftest test-complex-polar
  (are [x y] (= x y)
    (math/complex-polar 3.5 1.65) (complex -3.277598405517787 +3.489027599588716)
    (math/complex-polar 32/5 -2/3) (complex 6.356383480052433 -3.9575667396463174)))

(deftest test-abs
  (are [x y] (= x y)
    (math/abs 143) 143
    (math/abs -643) 643
    (math/abs (complex 143 214)) 257.381040482783
    (math/abs (complex -14.94 21)) 25.772147756832375
    (math/abs (complex 14.94 21.44)) 26.131919179424997))

(deftest test-arg
  (are [x y] (= x y)
    (math/arg (complex -126 72)) 2.6224465393432705
    (math/arg (complex 15.46 -9.65)) -0.5580176833495912
    (math/arg (complex -9.26 -6.72)) -2.513824512294668))

(deftest test-sqrt
  (are [x y] (= x y)
    (math/sqrt 0) 0.0
    (math/sqrt 1) 1.0
    (math/sqrt 144) 12.0
    (math/sqrt -1) (complex 0 1.0)
    (math/sqrt -144) (complex 0 12.0)
    (math/sqrt 2) 1.4142135623730951
    (math/sqrt -2) (complex 0 1.4142135623730951)
    (math/sqrt -48295) (complex 0 219.76123407006978)
    (math/sqrt (complex 645 313)) (complex 26.095342004681033 5.997238893129923)))
