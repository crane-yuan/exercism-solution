(in-package #:cl-user)
(defpackage #:rna-transcription
  (:use #:cl)
  (:export #:to-rna))
(in-package #:rna-transcription)

(defun to-rna (str)
  (map 'string (lambda (x)
                 (case x
                    (#\G #\C)
                    (#\C #\G)
                    (#\T #\A)
                    (#\A #\U))) str)
)
