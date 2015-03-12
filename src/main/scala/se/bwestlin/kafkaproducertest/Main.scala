package se.bwestlin.kafkaproducertest

import java.util.concurrent.atomic.AtomicInteger

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}
import org.apache.logging.log4j.LogManager

import scala.collection.JavaConversions._

object Main {

  def main(args: Array[String]): Unit = {

    val log = LogManager.getLogger

    val nEvents = args(0).toInt
    val nthToLog = Math.ceil(Math.pow(10, Math.ceil(Math.log10(nEvents)) - 2)).toInt

    val config = Map(
      "bootstrap.servers" -> "localhost:9092",
      "key.serializer"    -> "org.apache.kafka.common.serialization.StringSerializer",
      "value.serializer"  -> "org.apache.kafka.common.serialization.StringSerializer"
    )

    val producer = new KafkaProducer[String, String](config)

    val counter = new AtomicInteger()

    (1 to nEvents).foreach { n =>
      producer.send(
        new ProducerRecord("test", "foo", s"bar,$n,${System.currentTimeMillis}"),
        new Callback {
          override def onCompletion(recordMetadata: RecordMetadata, e: Exception): Unit = Option(e) match {
            case Some(ex) =>
              log.error(s"Failure when sending event", ex)
            case _ =>
              val currCount = counter.incrementAndGet()
              if ((currCount % nthToLog) == 0) log.info(s"$currCount messages sent")
          }
        }
      )
    }

    Thread.sleep(1000)
    log.info(s"A total of ${counter.get} messages has been sent")
  }
}
