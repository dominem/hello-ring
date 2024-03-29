(defproject hello-ring "0.1.0-SNAPSHOT"
  :description "It is just my ring sandbox."
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring/ring-devel "1.7.1"]
                 [hiccup "1.0.5"]]
  :ring {:handler hello-ring.core/main-handler}
  :plugins [[lein-ring "0.12.5"]]
  :uberjar-name "hello-ring-standalone.jar")
