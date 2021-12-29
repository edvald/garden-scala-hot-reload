package com.example.hotreloadtest

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    HotreloadtestServer.stream[IO].compile.drain.as(ExitCode.Success)
}
