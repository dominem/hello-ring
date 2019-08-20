(ns hello-ring.pretty-test
  (:require
    [clojure.test :refer :all]
    [hello-ring.pretty :refer :all]))

(deftest map->str-test
  (testing "map->str returns pretty string-ed map wrapped by pre-code html"
    (is (= (map->str {:url "https://www.this-is-a-very-long-url-that-should-not-be-used-by-a-professional-company.com"
                      :uri "/about-us"})
           "<pre><code>{:url\r\n \"https://www.this-is-a-very-long-url-that-should-not-be-used-by-a-professional-company.com\",\r\n :uri \"/about-us\"}\r\n</code></pre>"))))
