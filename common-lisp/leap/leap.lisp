(defpackage #:leap
  (:use #:common-lisp)
  (:export #:leap-year-p))
(in-package #:leap)

(defun leap-year-p (year)
  (cond 
    ((/= (rem year 4) 0) nil)
    ((/= (rem year 100) 0) t)
    ((= (rem year 400) 0) t)))
