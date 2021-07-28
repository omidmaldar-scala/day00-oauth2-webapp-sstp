// https://www.scala-sbt.org/1.x/docs/Scopes.html#Build-level+settings
ThisBuild / organization := "com.dive-into-scala"
ThisBuild / organizationName := "dive-into-scala"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / version      := "0.1.0-day00"

// ThisBuild / libraryDependencySchemes += "org.typelevel" %% "cats-effect" % "early-semver"
dependencyOverrides ++= Seq("org.typelevel" %% "cats-effect" % "3.1.1")

// Add Library Dependencies
// libraryDependencies += groupID % artifactID % revision
// See https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html

lazy val root = (project in file(".")).settings(
    name := "day00-oauth2-webapp",
    libraryDependencies ++= Dependencies.appDependencies
)
