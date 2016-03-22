(defproject ring-html5-handler/example "1.0.0"
  :resource-paths ["resources"]
  :dependencies [[afrey/ring-html5-handler "1.0.0" :scope "test"]]
  :plugins [[lein-ring "0.9.7"]]

  :ring {:handler afrey.ring-html5-handler/handler})
