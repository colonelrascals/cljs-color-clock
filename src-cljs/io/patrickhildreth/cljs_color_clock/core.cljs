(ns io.patrickhildreth.cljs-color-clock.core
  (:require
    [cljsjs.moment]

(defn- now
  "TODO: what does this function do?"
  []
  (.format (js/moment)))


(def clock-el (.querySelector js/document ".clock"))
(def *hex? (atom false))


(defn- get-seconds []
  (let [t (js/Date.)]
    (.getSeconds t)))
  ;; more idiomatic to use a threading macro here:
  ;; (-> (js/Date.)
  ;;     (.getSeconds))



;; more threading macro examples:
;; show the "flow" of what is happening to something
; (-> clock-el
;     add-css!
;     add-events!
;     start!)




(defn- get-percent [x]
  (/ (* x 100) 60))


(defn- render!
  "Update the DOM with the current time."
  []
  ;; TODO: write me
  (aset clock-el "textContent" (now)))


(defn- mouseover-clock [_js-evt]
  (reset! *hex? true)
  (render!))


(defn- mouseout-clock [])
  ;; TODO: write me


(defn- add-events! []
  (.addEventListener clock-el "mouseover" mouseover-clock)
  (.addEventListener clock-el "mouseout" mouseout-clock))


(add-events!)

;; start the render loop
(def one-second-ms 1000)
(js/setInterval render! one-second-ms)

;; do the initial render
(render!)
