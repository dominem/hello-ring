(ns hello-ring.core)

(defn -main [_]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello, Ring!"})