import sbt._
import Keys._

object build extends Build {
    val sbtAvro = Project(
        id = "sbt-avro",
        base = file("."),
        settings = Defaults.defaultSettings ++ Seq[Project.Setting[_]](
            organization := "com.cavorite",
            version := "0.1",
            sbtPlugin := true,
            libraryDependencies ++= Seq(
                    "org.apache.avro" % "avro" % "1.6.1",
                    "org.apache.avro" % "avro-compiler" % "1.6.1"
            ),
            scalacOptions in Compile ++= Seq("-deprecation"),
            description := "Sbt plugin for compiling Avro sources",
            publishTo := Some(Resolver.file("file",  new File( "/opt/www/files.cavorite.com/maven/" )) ),
            publishMavenStyle := false))
}