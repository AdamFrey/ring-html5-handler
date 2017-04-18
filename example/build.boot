(set-env!
  :resource-paths #{"resources"}

  :dependencies
  '[[pandeiro/boot-http "0.7.0" :scope "test"]
    [afrey/ring-html5-handler "1.1.1" :scope "test"]])

(require '[pandeiro.boot-http :refer [serve]])

(deftask dev []
  (comp
    (serve :handler 'afrey.ring-html5-handler/index-handler :port 9000)
    (watch)))
