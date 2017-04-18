(set-env!
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.8.0" :scope "provided"]
                  [ring/ring-core "1.4.0"]
                  [adzerk/bootlaces "0.1.12" :scope "test"]])

(require
  '[adzerk.bootlaces :as deploy]
  '[boot.task.built-in :refer :all])

(def +version+ "1.1.1")

(deploy/bootlaces! +version+)

(task-options!
  pom {:project     'afrey/ring-html5-handler
       :version     +version+
       :description "Ring handler to server HTML5 single page application"
       :url         "https://github.com/adamfrey/ring-html5-handler"
       :scm         {:url "https://github.com/adamfrey/ring-html5-handler"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask dev []
  (comp
    (watch)
    (deploy/build-jar)))

(deftask push-release
  []
  (comp
    (deploy/build-jar)
    (#'deploy/collect-clojars-credentials)
    (push
      :tag            true
      :gpg-sign       false
      :ensure-release true
      :repo           "deploy-clojars")))
