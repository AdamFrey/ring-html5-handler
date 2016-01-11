(ns afrey.ring-html5-handler
  (:require [ring.util.response :refer [file-response]]
            [ring.middleware
             [file :refer [wrap-file]]
             [resource :refer [wrap-resource]]]))

(defonce dir "target/")

(defn- index-handler
  "Route any unhandled requests to index.html"
  [request]
  (assoc-in (file-response (str dir "index.html"))
    [:headers "Content-Type"]
    "text/html;charset=UTF-8"))

(def handler
  (-> index-handler
    (wrap-resource "")
    (wrap-file dir {:index-files? false})))
