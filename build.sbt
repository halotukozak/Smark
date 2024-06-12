ThisBuild / version := "0.2.0"
ThisBuild / scalaVersion := "3.4.1"

lazy val root = (project in file("."))
  .settings(
    name := "Smark",
    idePackagePrefix := Some("halotukozak.smark"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test,

    githubOwner := "halotukozak",
    githubRepository := "Smark",
  )
