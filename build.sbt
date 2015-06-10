organization := "net.thecoda"

name := "FruitCheckout"

description := "A Checkout app, for fruit"

scalaVersion := "2.11.6"

libraryDependencies ++= {
  object V {
    val scalatest = "2.2.0"
    val logback = "1.1.2"
    val slf4j = "1.7.10"
  }
  Seq(
    "ch.qos.logback"         %  "logback-core"            % V.logback,
    "ch.qos.logback"         %  "logback-classic"         % V.logback,
    "org.slf4j"              %  "slf4j-api"               % V.slf4j,    
    "org.scalatest"          %% "scalatest"               % V.scalatest    % "test"
  )
}

javacOptions ++= Seq("-Xmx512m", "-Xms128m", "-Xss10m")

javaOptions ++= Seq("-Xmx512m", "-Djava.awt.headless=true")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint")

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))


