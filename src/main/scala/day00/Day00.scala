package day00

import cats.effect._
import sttp.tapir._
import cats.syntax.all._
import sttp.tapir.server.http4s.Http4sServerInterpreter
import org.http4s.HttpRoutes
import scala.concurrent.ExecutionContext
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.server.Router
import org.http4s.implicits._ 

object Day00 extends IOApp {

    // endpoint description
    val endpointDescription: Endpoint[String, Unit, String, Any] = 
        endpoint
        .get
        .in("hello")
        .in(query[String]("name"))
        .out(stringBody)
    // ? monad
    // ? asRight
    
    //endpoint logic
    def endpointLogic(name:String) = IO(s"Hello, $name".asRight[Unit])

    //endpoint route
    val day00Routes: HttpRoutes[IO] = 
        Http4sServerInterpreter[IO]().toRoutes(endpointDescription)(endpointLogic _)
    

    // Blaze server
    def serverResource(routes:HttpRoutes[IO])(ec:ExecutionContext) =
            BlazeServerBuilder[IO](ec)
            .bindHttp(8080, "localhost")
            .withHttpApp(Router("/"-> routes).orNotFound)
            .resource
    
    implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

    override def run(args: List[String]): IO[ExitCode] = 
        serverResource(day00Routes)(ec)
        .use( _ => IO.never) // run forever, non-terminating IO instance
        .as(ExitCode.Success)

}