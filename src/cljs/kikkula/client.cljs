(ns kikkula
  (:require [reagent.core :as reagent :refer [atom]]))

(def counter (atom 0))

(defn do-deed [] (swap! counter inc))

(defn my-component []
  [:div
    [:p {:on-click do-deed} "I am a component and my counter is " @counter]])

(defn ^:export run []
  (reagent/render-component [my-component]
    (.getElementById js/document "app")))
