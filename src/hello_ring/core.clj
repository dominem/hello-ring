(ns hello-ring.core
  (:require
    [hello-ring.pretty :as pretty]))

(defn handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (pretty/map->str request)})

(defn -main [request]
  (handler request))