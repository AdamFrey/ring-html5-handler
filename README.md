# ring-html5-handler

[![Clojars Project](https://clojars.org/afrey/ring-html5-handler/latest-version.svg)](https://clojars.org/afrey/ring-html5-handler)

A simple ring handler for serving a site using HTML5 History
routes. The handler serves assets from the `target` directory and
serves `index.html` for any unmatched route, to be handled by the
JS/CLJS router.

## Usage

With [boot-http](https://github.com/pandeiro/boot-http):

```
(require '[pandeiro.boot-http :refer [serve]])

(serve :handler 'afrey.ring-html5-handler/handler)
```

With [lein-ring](https://github.com/weavejester/lein-ring):

```
:ring {:handler afrey.ring-html5-handler/handler}
```

Or use it with any other `ring` compatible server.

## TODO

- [ ] Configurable root directory path
- [ ] Configurable root HTML file
