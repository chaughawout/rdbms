(ns clojure-rdbms.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; The default path to the persisted database collection
(def default_path "The default path to the persisted database collection" ".")

;; The collection of databases in our rdbms
(def database-collection "A collection of databases" (get-persistent-dbs default_path))

;; Retrieve the persistent databases from file storage
(defn get-persistent-dbs
  [path_to_dbs]
  ({})) ; TODO: update this to retrieve the contents from file

;; Creates a database with the given name, table, and columns in the table.
(defn create-database
  [db_name table_name column_specs]
  (assoc database-collection
         (create-table (get database-collection db_name) table_name column_specs)
         db_name
         {})) ; TODO: in memory for now. Will change in the future

;; Creates the table with the provided name and column specifications
(defn create-table
  [database table_name column_specs]
  (assoc (get database table_name)
         table_name
         {:Columns column_specs})) ; TODO: in memory for now. Will change in the future
