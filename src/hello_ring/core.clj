(ns hello-ring.core
  (:require
    [hello-ring.pretty :as pretty]
    [hiccup.core :as hiccup]
    [hiccup.page :as hiccup-page]))

(def bootstrap-css
  [:link
   {:rel "stylesheet"
    :href "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    :integrity "sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    :crossorigin "anonymous"}])

(def head
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1, shrink-to-fit=no"}]
   bootstrap-css
   [:title "Hello, Ring!"]])

(defn body [request]
  [:body
   [:header
    [:nav.navbar.navbar-expand-lg.navbar-light.bg-light
     [:div.container.justify-content-center
      [:a.navbar-brand.m-0 {:href "/"} "Hello, Ring!"]]]]
   [:main.mt-4
    [:div.container
     [:h1.mb-4 "Your request map"]
     (pretty/map->hiccup request)]]])

(defn handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (hiccup/html
              (hiccup-page/doctype :html5)
              [:html {:lang "en"} head (body request)])})

(defn -main [request]
  (handler request))