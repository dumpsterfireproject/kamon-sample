package com.example

import akka.actor.ActorSystem
import kamon.Kamon
import scala.concurrent.duration._

object Main extends App {
  Kamon.init()
  val actorSystem: ActorSystem = ActorSystem.create("helloAkka")
  import actorSystem.dispatcher
  val receiver = actorSystem.actorOf(SampleActor.props, "receiver")
  val sender = actorSystem.actorOf(SampleActor.props, "sender")
  actorSystem.scheduler.schedule(1.seconds, 10.seconds) { receiver.tell("Hello", sender) }
}
