import sbt._

// This notation is useful for maintaining automatic version updates e.g when e.g [Scala Steward](https://github.com/scala-steward-org/scala-steward) is used

object Versions {
    val Cats = "2.6.1"
    val CatsEffect = "2.5.2"
    val Circe = "0.14.1"
    val Tapir = "0.19.0-M3"
    val Sttp = "3.3.12"
    val SttpOAuth2 = "0.11.1"
}


object Dependencies {

    private val cats = Seq(
        "org.typelevel" %% "cats-core" % Versions.Cats
    )

    private val catsEffect = Seq(
        "org.typelevel" %% "cats-effect" % Versions.CatsEffect
    )

    private val circe = Seq(
        "io.circe" %% "circe-generic" % Versions.Circe
    )

    private val tapir = Seq(
        "com.softwaremill.sttp.tapir" %% "tapir-core" % Versions.Tapir,
        "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % Versions.Tapir
    )

    private val sttp = Seq(
        "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats-ce2" % Versions.Sttp
    )

    private val sttpOAuth2 = Seq(
        "com.ocadotechnology" %% "sttp-oauth2" % Versions.SttpOAuth2
    )

    val appDependencies = 
        cats ++ catsEffect ++ circe ++ tapir ++ sttp ++ sttpOAuth2

}
