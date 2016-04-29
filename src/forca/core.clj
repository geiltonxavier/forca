(ns forca.core
  (:gen-class))

(def total-lives 6)

(defn lost [] (print "you lost!"))
(defn win [] (print "you win!"))

(defn missing-letters [word hits]
  (remove (fn [letter] (contains? hits(str letter))) word))
)

(defn hit-every-word? [word hits]  
  (empty? (missing-letters word hits))
)


(defn game-play [life word hits]
	(if ( = life 0)
	  (lost)
	    (if (hit-every-word? word hits)
	    	(win)
	    	(print "try again!")
	    )
	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
