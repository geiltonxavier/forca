(ns forca.core
  (:gen-class))

(def total-lives 6)
(def secret-word "MELANCIA")

(defn lost [] (print "Você Perdeu!"))
(defn win [] (print "Você Venceu!"))

(defn missing-letters [word hits]
  (remove (fn [letter] (contains? hits(str letter))) word))
)

(defn hit-every-word? [word hits]  
  (empty? (missing-letters word hits))
)

(defn read-leter! [] (read-line))

(defn hit? [kick word] (.contains word kick))

(defn printing-forca [life word hits]
    (println : "Vidas " life)
    (doseq [letter (seq word)]
        (if (contains? hit (str letter))
            (print letter " ") (print "_" " ")))
    (println))

(defn starting-game [] (game-play total-lives secret-word #{}))

(defn game-play [life word hits]
	(printing-forca life word hits)
	(cond
	    ( = life 0) (lost)
	    (hit-every-word? word hits)(win)
	    :else
	     (let [kick (read-leter!)]
	          (if (hit? kick word)
	          	(do 
	          		(println "Acertou a letra")
	          		(recur life word (conj hits kick)))
		     	 (do
		     	 	(println "Errou a letra! Perdeu vida!")
		            (recur (dec life) word hits))))))

(defn -main [& args
(starting-game) )
