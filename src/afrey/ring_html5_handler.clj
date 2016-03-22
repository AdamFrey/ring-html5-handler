(ns afrey.ring-html5-handler
  (:require [ring.util.response :refer [resource-response]]
            [ring.middleware.resource :refer [wrap-resource]]))

(defn- index-handler
  "Route any unhandled requests to index.html"
  [request]
  (-> (resource-response "index.html")
    (assoc-in [:headers "Content-Type"] "text/html;charset=UTF-8")))

(def handler
  (-> index-handler
    (wrap-resource "")))
