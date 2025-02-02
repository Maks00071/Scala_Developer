ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.5.0"

val sparkVersion = "3.2.1"

lazy val circeDependencies = Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % "0.11.2")

//lazy val sparkDependencies = Seq(
//  "org.apache.spark"         %% "spark-sql"            % sparkVersion,
//  "org.apache.spark"         %% "spark-streaming"      % sparkVersion,
//  "org.apache.spark"         %% "spark-sql-kafka-0-10" % "3.2.1",
//  "org.apache.logging.log4j" % "log4j-core"            % "2.23.1",
//  "io.netty"          % "netty-all"                   % "5.0.0.Alpha2"
//)

lazy val root = (project in file("."))
  .settings(
    name := "Scala_Developer",
    //libraryDependencies ++= sparkDependencies ++ circeDependencies,
    javacOptions ++= Seq("-source", "16"),
    javaOptions ++= Seq( // Spark-specific JVM options
      "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
    ),
    compileOrder := CompileOrder.JavaThenScala
  )