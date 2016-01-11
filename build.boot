(set-env!
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.7.0" :scope "provided"]
                  [ring/ring-core "1.4.0"]
                  [adzerk/bootlaces "0.1.12" :scope "test"]])

(require
 '[adzerk.bootlaces :refer :all]) ;; tasks: build-jar push-snapshot push-release)

(def +version+ "0.0.2")

(bootlaces! +version+)

(task-options!
 pom {:project     'afrey/ring-html5-handler
      :version     +version+
      :description "Ring handler to server HTML5 single page application"
      :url         "https://github.com/adamfrey/ring-html5-handler"
      :scm         {:url "https://github.com/adamfrey/ring-html5-handler"}
      :license     {"MIT" "https://opensource.org/licenses/MIT"}})
