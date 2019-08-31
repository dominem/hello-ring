(ns hello-ring.core
  (:require
    [hello-ring.pretty :as pretty]
    [hiccup.core :as hiccup]
    [hiccup.page :as hiccup-page]
    [ring.adapter.jetty :refer [run-jetty]]))

(def bootstrap-css
  [:link
   {:rel         "stylesheet"
    :href        "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    :integrity   "sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    :crossorigin "anonymous"}])

(def head
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name    "viewport"
           :content "width=device-width, initial-scale=1, shrink-to-fit=no"}]
   bootstrap-css
   [:title "Hello, Ring!"]])

(defn body-header-nav-item [uri href text]
  [(if (= uri href)
     :li.nav-item.active
     :li.nav-item)
   [:a.nav-link {:href href} text]])

(defn body-header-nav [uri]
  [:ul.navbar-nav
   (body-header-nav-item uri "/" "Home")
   (body-header-nav-item uri "/about" "About")])

(defn body-header [request]
  [:header
   [:nav.navbar.navbar-expand-lg.navbar-light.bg-light
    [:div.container.justify-content-between
     [:a.navbar-brand.m-0 {:href "/"} "Hello, Ring!"]
     (body-header-nav (:uri request))]]])

(defn body-main [content]
  [:main.mt-4 [:div.container content]])

(defn body [request & content]
  [:body
   (body-header request)
   (body-main content)])

(defn home-page [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (hiccup/html
              (hiccup-page/doctype :html5)
              [:html {:lang "en"} head
               (body request
                     [:h1.mb-4 "Your request map"]
                     (pretty/map->hiccup request))])})

(defn about-page [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (hiccup/html
              (hiccup-page/doctype :html5)
              [:html {:lang "en"} head
               (body request
                     [:h1.mb-4 "About"]
                     [:p.lead (str "This is just my ring sandbox. "
                                   "I learn ring here.")])])})

(defn route [request]
  (case (:uri request)
    "/" (home-page request)
    "/about" (about-page request)
    {:status 404}))

(defn main-handler [request]
  (route request))

(defn get-port []
  (Integer/valueOf (or (System/getenv "PORT") "3000")))

(defn -main [& args]
  (run-jetty main-handler {:port (get-port)}))