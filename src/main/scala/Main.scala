package com.joprice

import org.dhallj.syntax._
import org.dhallj.yaml.YamlConverter
import cats.effect.{ContextShift, IO, Resource}
import org.dhallj.core.Expr
import org.dhallj.imports.syntax._
import org.http4s.client.Client
import org.http4s.client.blaze.BlazeClientBuilder
import scala.concurrent.ExecutionContext

object Main extends App {
  implicit val cs = IO.contextShift(ExecutionContext.global)
  val client = BlazeClientBuilder[IO](ExecutionContext.global).resource
  val kubernetesExamplePath = "./deployment.dhall"
  val Right(expr) = kubernetesExamplePath.parseExpr
  val result = client.use { implicit c =>
        expr.resolveImports[IO]
    }
      .map( _.normalize)
      .unsafeRunSync
  println(YamlConverter.toYamlString(result.normalize))
}
