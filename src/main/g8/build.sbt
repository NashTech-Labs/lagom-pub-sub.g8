organization in ThisBuild := "com.knoldus"

version in ThisBuild := "1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.8"

lazy val `pub-sub` = (project in file("."))
  .aggregate(`pubsub-api`, `pubsub-impl`)

lazy val `pubsub-api` = (project in file("pubsub-api"))
  .settings(common: _*)
  .settings(
    libraryDependencies ++= Seq(lagomJavadslApi, lagomJavadslPubSub),
    lagomCassandraEnabled in ThisBuild := false,
    lagomKafkaEnabled in ThisBuild := false
  )

lazy val `pubsub-impl` = (project in file("pubsub-impl"))
  .enablePlugins(LagomJava)
  .settings(common: _*)
  .dependsOn(`pubsub-api`)

def common = Seq(
  javacOptions in compile += "-parameters"
)

