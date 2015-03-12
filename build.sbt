name := """kafka-producer-test"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.apache.logging.log4j"  % "log4j-api"         % "2.2",
  "org.apache.logging.log4j"  % "log4j-core"        % "2.2",
  "org.apache.logging.log4j"  % "log4j-slf4j-impl"  % "2.2",
  "org.apache.kafka"          % "kafka-clients"     % "0.8.2.1"
)
