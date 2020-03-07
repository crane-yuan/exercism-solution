(in-package #:cl-user)
(defpackage #:anagram
  (:use #:common-lisp)
  (:export #:anagrams-for))

(in-package #:anagram)

(defun alphabetical-sort (string)
  (sort (string-downcase string) #'char-lessp))

(defun anagramp (a b)
  (and
   (string-not-equal s1 s2)
   (string-equal (string-downcase-sort s1)
                 (string-downcase-sort s2))))

(defun anagrams-for (word candidates) 
  (loop
     for candidate in candidates
     when (anagramp word candidate) collect candidate))
