import sbt._
import Keys._

object Vfs2ClientBuild extends Build {

    lazy val root = Project(id = "docear-vfs2-desktop-client", base = file(".")).settings(
      name := "docear-vfs2-desktop-client",
      organization := "org.docear",
      version := "1.0-SNAPSHOT", 
      scalaVersion := "2.9.1",
      javacOptions ++= Seq("-target", "1.6") ++ Seq("-source", "1.6"),
      libraryDependencies += "org.apache.commons" % "commons-vfs2" % "2.0",
      libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.2.1",
      libraryDependencies += "org.apache.httpcomponents" % "httpmime" % "4.2.1",
      libraryDependencies += "commons-lang" % "commons-lang" % "2.6"
    ).settings(com.github.retronym.SbtOneJar.oneJarSettings: _*)
}