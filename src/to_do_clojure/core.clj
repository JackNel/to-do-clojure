(ns to-do-clojure.core
  (:gen-class))

(def to-dos (atom [])) ;create a vector named to-dos

(defn add-to-do [input]
  (reset! to-dos (conj (deref to-dos) input)))

(defn -main [& args]
  (println "Type a to-do and hit enter.")
  (loop []
    (let [input (read-line)]
      (when (not= input "q")
        (add-to-do input)
        (recur))))
  (println (deref to-dos)))
