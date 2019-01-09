// For com.github.mpeltonen
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

// For sbt assembly, sbteclipse plugins and so on.
resolvers += "bintray-sbt-plugins" at "http://dl.bintray.com/sbt/sbt-plugin-releases"

//https://github.com/sbt/sbt-assembly
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.9")

//addSbtPlugin for eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
