(ns fnhouse.swagger-test
  (:require [fnhouse.swagger :refer :all]
            [midje.sweet :refer :all]
            [fnhouse.makkara :as m]
            [plumbing.core :refer [defnk]]
            [fnhouse.handlers :as handlers]
            [ring.swagger.spec2 :as swagger]
            [schema.core :as s]))

;;
;; Swagger 2.0
;;

(fact "collect-routes"
  (let [prefix->ns-sym {"makkarat" 'fnhouse.makkara
                        "" 'fnhouse.swagger}
        proto-handlers (handlers/nss->proto-handlers prefix->ns-sym)
        swagger (collect-routes proto-handlers prefix->ns-sym {:info {:title   "Makkara API"
                                                                      :version "1.0"}})]

    (fact "produces valid Swagger-data"
      (swagger/validate swagger) => nil)

    (fact "is mapped correctly"

      swagger =>

      {:info {:title "Makkara API"
              :version "1.0"}
       :paths {"/makkarat/" {:post {:description "Adds a Makkara"
                                    :parameters {:body m/NewMakkara
                                                 :query {s/Keyword s/Str}}
                                    :responses {200 {:description ""
                                                     :schema m/Makkara}}
                                    :summary "Adds a Makkara"
                                    :tags ["makkarat"]}}
               "/makkarat/:makkara-id" {:get {:description "Adds a Makkara"
                                              :parameters {:path {:makkara-id Long}
                                                           :query {s/Keyword s/Str}}
                                              :responses {200 {:description ""
                                                               :schema m/Makkara}}
                                              :summary "Adds a Makkara"
                                              :tags ["makkarat"]}}}}))

  (fact "swagger-ui (requires swagger-ui dependency)"
    (let [{:keys [status body]} ((wrap-swagger-ui identity)
                                  {:uri "/index.html"})]
      status => 200
      (slurp body) => (contains "swagger"))))
