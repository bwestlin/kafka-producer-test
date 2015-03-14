# Kafka Producer Test #

This is some code testing the new [Kafka Producer API](http://kafka.apache.org/documentation.html#producerapi)
introduced in Kafka 0.8.2 using Scala.

Easiest way to test this is to just clone this repo, then run [this](https://registry.hub.docker.com/u/devdb/kafka/)
docker container for a development Kafka node with the following:
```
sudo docker pull devdb/kafka:latest
sudo docker run -d --net host --name kafka -p 2181:2181 -p 9092:9092 devdb/kafka
sudo docker exec -it kafka bin/kafka-console-consumer.sh \
                 --zookeeper localhost:2181 --from-beginning --topic test
```
This will start up Kafka and a console consumer for the topic **test**.

Then open another terminal and run the actual producer test code:
```
./activator "run 1234"
```

If everything works this should produce **1234** events on the Kafka topic **test** which the should be
consumed and outputted in the other terminal.

As stated the new Kafka Producer is to be considered as Beta quality so your milage trying this may differ.
Depending on OS and Docker version you might need to do some extra configuratiopn to make things work correctly.

I've only tested this on Linux and docker v1.5.0 where the docker container will share hostname with the host by using ```--net host```.

If you're running [boot2docker](http://boot2docker.io/) it might not work out of the box, but adding the hostname ```boot2docker``` to  ```/etc/hosts``` might help.
