name := """WhereIsTheSunNL"""
organization := "scooby"

version := "1.0-SNAPSHOT"

val isUnitTest: String => Boolean = name => !name.startsWith("testresources")

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(testOptions in Test := Seq(Tests.Filter(isUnitTest)))
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  ehcache,
  ws,
  guice,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.6.0",
  "io.kanaka" %% "play-monadic-actions" % "2.1.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test,
  "com.typesafe.akka" %% "akka-testkit" % "2.5.6" % Test,
  "org.mockito" % "mockito-all" % "1.10.17" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "scooby.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "scooby.binders._"
