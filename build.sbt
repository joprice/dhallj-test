import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.joprice"
ThisBuild / organizationName := "dhall-test"

val dhallVersion = "0.3.2"

lazy val root = (project in file("."))
  .settings(
    name := "dhallj-test",
    libraryDependencies ++= Seq(
      "org.dhallj" %% "dhall-scala" % "0.3.2",
      "org.dhallj" %% "dhall-imports" % "0.3.2",
      "org.dhallj" % "dhall-yaml" % "0.3.2",
      "org.http4s" %% "http4s-blaze-client" % "0.21.4"
    )
  )
