name := "watson-sentiment-analysis"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "com.typesafe" % "config" % "1.3.2"
libraryDependencies += "org.apache.spark" %% "spark-core" %"2.3.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" %"2.3.0"
libraryDependencies += "com.ibm.watson.developer_cloud" % "natural-language-understanding" % "6.6.0"
