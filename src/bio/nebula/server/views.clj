(ns bio.nebula.server.views
  (:require [markdown.core :refer [md-to-html-string]]
            [hiccup.page   :refer [html5 include-css include-js]]
            [net.cgrand.enlive-html :as html :refer [defsnippet deftemplate nth-child nth-of-type]]))


(deftemplate index-page "public/index.html" [])

(def card-sel [:#card-index :> :div.ui.container :> :div :> [:div (nth-child 1)]])

(defsnippet card-model "public/c/index.html" card-sel
  [{:keys [name owner image labels url id desc]}]
  [:h3.header] (html/content name)
  [:.owner] (html/content owner)
  [:.content :p] (html/html-content (md-to-html-string desc)))

(deftemplate card-view "public/c/index.html" [cards]
  [:.ui.cards] (html/content (map card-model cards)))

(deftemplate checkout-page "public/checkout/index.html" [])