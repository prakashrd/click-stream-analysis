
lazy val root = (project in file(".")).
  settings(
    organization := "com.jai.analytics",
    name := "click-stream-analysis",
    scalaVersion := "2.11.2",
    mainClass in Compile := Some("com.jai.analytics.SparkClient")
  )

// Resolver to download the repos
resolvers += "SnowPlow Repo" at "http://maven.snplow.com/releases/"
// one might be enough just added for safer side
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

// Dependency
libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.1.0" % "provided",
  "org.apache.spark" % "spark-sql_2.11" % "2.1.0" % "provided",
  "org.rogach" %% "scallop" % "3.1.2"
)