name := """play-a"""
organization := "org.smop"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
    guice,
    "org.smop" %% "monorepo-library" % "0.1-SNAPSHOT",
    "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test
)

resolvers += 
"Artifactory" at "http://artifactory-oss:8081/artifactory/sbt-dev-local/"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "org.smop.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "org.smop.binders._"
