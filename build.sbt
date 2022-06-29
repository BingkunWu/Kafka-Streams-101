// build.sbt
name := "guide_streams"
run / fork := true
version := "0.0.1"
organization := "com.zendesk"
scalaVersion := "2.13.8"

lazy val versions = new {
  val kafka           = "3.1.0"
}

val apacheKafkaDependencies = Seq(
  "org.apache.kafka" % "kafka-streams" % versions.kafka,
  "org.apache.kafka" %% "kafka-streams-scala"     % versions.kafka,
  "ch.qos.logback"       % "logback-classic"          % "1.2.11",
  "net.logstash.logback" % "logstash-logback-encoder" % "7.0.1",
  "org.rocksdb" % "rocksdbjni" % "7.3.1"
)

libraryDependencies ++= apacheKafkaDependencies

resolvers ++= Seq(
  "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/",
  "Typesafe repository mwn" at "https://repo.typesafe.com/typesafe/maven-releases/",
  ("Bintary JCenter" at "https://jcenter.bintray.com").withAllowInsecureProtocol(true),
  "Zendesk Artifactory" at "https://zdrepo.jfrog.io/zdrepo/zen-libs-m2"
)

credentials += Credentials(
  "Artifactory Realm",
  "zdrepo.jfrog.io",
  System.getenv("ARTIFACTORY_USERNAME"),
  System.getenv("ARTIFACTORY_API_KEY")
)
