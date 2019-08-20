(ns hello-ring.html-test
  (:require
    [clojure.test :refer :all]
    [hello-ring.html :refer :all]))

(deftest pre-code-test
  (testing "pre-code returns a string wrapped in <pre><code></code></pre> tags"
    (is (= (pre-code "(vector 1 2 3)")
           "<pre><code>(vector 1 2 3)</code></pre>"))))
