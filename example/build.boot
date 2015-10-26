(set-env!
 :resource-paths #{"resources"}

 :dependencies
 '[[pandeiro/boot-http "0.6.1" :scope "test"]
   [afrey/ring-html5-handler "0.0.1" :scope "test"]])

(require '[pandeiro.boot-http :refer [serve]])

(deftask dev []
  (comp
   (serve :handler 'afrey.ring-html5-handler/handler :reload true :port 8001)
   (watch)))
