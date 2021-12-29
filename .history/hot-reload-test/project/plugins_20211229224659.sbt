resolvers += Resolver.sbtPluginRepo("snapshots")
resolvers += Resolver.sbtPluginRepo("release")
resolvers += Resolver.sonatypeRepo("public")

addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.14")
addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
