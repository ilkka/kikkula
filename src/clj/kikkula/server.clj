(ns kikkula.server
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as response])
  (:use [hiccup.core]
        [compojure.core])
  (:gen-class))

(defn layout [& content]
  (html
    [:head
      [:meta {:http-equiv "Content-Type" :content "text/html; charset=utf-8"}]
      [:title "Kikkula"]]
    [:body content]))

(defn render-app []
  (layout
    [:h2 "Kikkula"]
    [:div {:id "app"}]
    [:script {:src "http://fb.me/react-0.11.1.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"}]
    [:script {:src "js/cljs.js"}]
    [:script "kikkula.run();"]))

(defroutes main-routes
  (GET "/" []
    (render-app))
  (route/resources "/"))

(def app
  (handler/site main-routes))
