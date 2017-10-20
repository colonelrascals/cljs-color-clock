(ns io.patrickhildreth.cljs-color-clock.core
  (:require
    [cljsjs.moment]))

(defn- now
  "TODO: what does this function do?"
  []
  (.format (js/moment)))

(js/alert (now))
