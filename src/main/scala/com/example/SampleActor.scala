package com.example

import akka.actor.{Actor, ActorLogging, Props}
import kamon.Kamon
import kamon.trace.Span

object SampleActor {
  def props: Props = Props(new SampleActor())
  case class Echo(s: String)
}
class SampleActor() extends Actor with ActorLogging {

  def receive: Receive = {
    case SampleActor.Echo(s) =>
      val span: Span = Kamon.spanBuilder("received-echo").tag("string-tag", "echo").start()
      Kamon.runWithSpan(span, true) {
        log.info("received {}", s)
      }

    case s: String =>
      val span: Span = Kamon.spanBuilder("received-string").tag("string-tag", "hello").start()
      Kamon.runWithSpan(span, true) {
        val origin = sender()
        origin ! SampleActor.Echo(s)
      }
  }
}
