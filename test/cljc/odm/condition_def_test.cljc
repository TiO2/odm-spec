(ns odm.condition-def-test
  (:require
    #?@(:clj
        [[clojure.spec :as s]
         [clojure.spec.test :as st]
         [clojure.test :refer :all]
         [odm-spec.test-util :refer [given-problems]]]
        :cljs
        [[cljs.spec :as s]
         [cljs.spec.test :as st]
         [cljs.test :refer-macros [deftest testing is are]]
         [odm-spec.test-util :refer-macros [given-problems]]])
         [odm.condition-def]))

(st/instrument)

(deftest condition-def-test
  (testing "Valid condition definitions"
    (are [x] (s/valid? :odm/condition-def x)
      #:odm.condition-def
          {:oid "C01"
           :name "foo"
           :odm/description
           [{:lang-tag "de" :text "bar"}]}))

  (testing "Generator available"
    (is (doall (s/exercise :odm/condition-def 1)))))
