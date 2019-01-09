import sbt._
import Keys._
import sbtassembly.AssemblyPlugin.autoImport._


object Settings {

  lazy val settings: Seq[Def.Setting[_]] = Seq(

    version := "$version$" + sys.props.getOrElse("buildNumber", default="-SNAPSHOT"),
    scalaVersion := "$scala_version$",
    organization := "$package$",

    publishMavenStyle := true,
    publishArtifact in Test := false,

    // java complile
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xmx2G"),
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature"),
    fork := true,

    // sbt assembly public area
    test in assembly := {},
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs@_*) => MergeStrategy.discard
      case PathList(xs @ _*) if xs.last endsWith ".html" => MergeStrategy.discard
      case PathList(xs @ _*) if xs.last endsWith ".properties" => MergeStrategy.filterDistinctLines
      case PathList(xs @ _*) if xs.last endsWith ".conf" => MergeStrategy.filterDistinctLines
      case _ => MergeStrategy.first
    },

    // Resolver Repository
    resolvers += Opts.resolver.mavenLocalFile,
    resolvers ++= Seq(DefaultMavenRepository,
      Resolver.defaultLocal,
      Resolver.mavenLocal,
      "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
      "Aliyun Maven2 Snapshots" at "http://maven.aliyun.com/nexus/content/groups/public",
      "Apache Staging" at "https://repository.apache.org/content/repositories/staging/",
      Classpaths.typesafeReleases,
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
      Classpaths.sbtPluginReleases,
      "Eclipse repositories" at "https://repo.eclipse.org/service/local/repositories/egit-releases/content/"
    )
  )

  lazy val testSettings = Seq(
    fork in Test := false,
    parallelExecution in Test := false
  )

  lazy val itSettings = Defaults.itSettings ++ Seq(
    logBuffered in IntegrationTest := false,
    fork in IntegrationTest := true
  )

  lazy val $appname$Settings = Seq(
    assemblyJarName in assembly := "$appname$-" + version.value + ".jar",
    mainClass in assembly := Some("$package$.$appname;format="word"$.$appname;format="Camel"$"),
    target in assembly := file(baseDirectory.value + "/../bin/"),
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(
      includeScala = false, includeDependency = false
    )
  )

  lazy val $module1$Settings = Seq(
    assemblyJarName in assembly := "$module1$-" + version.value + ".jar"
  )

  lazy val $module2$Settings = Seq(
    assemblyJarName in assembly := "$module2$-" + version.value + ".jar"
  )

}
