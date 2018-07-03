
lazy val root = (project in file(".")).
  settings(
    organization := "com.jai.analytics",
    name := "click-stream-analysis",
    scalaVersion := "2.11.2",
    mainClass in Compile := Some("com.jai.analytics.SparkClient")
  )

// Resolver to download the repos
resolvers += "SnowPlow Repo" at "http://maven.snplow.com/releases/"

// Dependency
libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.1.0" % "provided",
  "org.apache.spark" % "spark-sql_2.11" % "2.1.0" % "provided"
)