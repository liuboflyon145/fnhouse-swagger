(defproject guesthouse "0.3.0"
  :description "Example guestbook project for demonstrating fnhouse & swagger"
  :url "https://github.com/Prismatic/fnhouse/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [prismatic/plumbing "0.3.5"]
                 [metosin/fnhouse-swagger "0.5.0"]
                 [metosin/ring-swagger-ui "2.1.0-alpha.6-SNAPSHOT"]
                 [clj-http "1.0.1"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [ring/ring-json "0.3.1"]])
