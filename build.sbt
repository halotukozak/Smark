ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.1"

lazy val root = (project in file("."))
  .settings(
    name := "Smark",
    idePackagePrefix := Some("halotukozak.smark"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test,
  )
