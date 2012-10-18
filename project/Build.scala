import sbt._
import Keys._

object Vfs2ClientBuild extends Build {

    lazy val root = Project(id = "docear-vfs2-desktop-client", base = file(".")).settings(
      name := "docear-vfs2-desktop-client",
      organization := "org.docear",
      version := "1.0-SNAPSHOT", 
      scalaVersion := "2.9.1",
      libraryDependencies += "org.apache.commons" % "commons-vfs2" % "2.0",
      libraryDependencies += "commons-httpclient" % "commons-httpclient" % "3.1"
    )
}