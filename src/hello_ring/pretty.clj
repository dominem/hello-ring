(ns hello-ring.pretty
  (:require
    [clojure.pprint :as pp]
    [hello-ring.html :as html])
  (:import
    (java.io StringWriter)))

(defn map->str [m]
  (let [out (StringWriter.)]
    (pp/pprint m out)
    (html/pre-code (.toString out))))
