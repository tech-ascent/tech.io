(ns tech.v3.io.url-test
  (:require [clojure.test :refer :all]
            [tech.v3.io.url :as url]))


(deftest invalid-url-test
  ;;feel free to add
  (is (thrown? Throwable (url/url->parts "s3:/a/b/c")))
  (is (not (nil? (url/url->parts "s3://a/b/c"))))
  (is (not (nil? (url/url->parts "makeitup://a/b/c")))))

(deftest windows-paths-are-not-urls
  (let [p "C:\\Users\\joinr\\data\\yellow_tripdata_2016-01.csv"]
    (is (not (boolean (url/url? p))))))
