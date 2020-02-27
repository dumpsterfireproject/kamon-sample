name := "kamon-sample"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.29",
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.29",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "io.kamon" %% "kamon-bundle" % "2.0.6",
  "io.kamon" %% "kamon-prometheus" % "2.0.1",
  "io.kamon" %% "kamon-zipkin" % "2.0.1"
)

fork in run := true
