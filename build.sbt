name := "TypeClasses"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq("com.github.mpilquist" %% "simulacrum" % "0.16.0")

// For Scala 2.11-2.12
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)