
name := "monorepo-library"

organization := "org.smop"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

publishTo := Some("Artifactory Realm" at "http://artifactory-oss:8081/artifactory/sbt-dev-local;build.timestamp=" + new java.util.Date().getTime)
credentials += Credentials("Artifactory Realm", "artifactory-oss", "admin", "AP2VYt8EEAGkeApMHyeuj9e28CYLckhBkpTJvvaukFpq6U3f8")
