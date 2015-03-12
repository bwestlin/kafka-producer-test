# Kafka Producer Test #

This is some code testing the new [Kafka Producer API](http://kafka.apache.org/documentation.html#producerapi)
introduced in Kafka 0.8.2 using Scala.

Easiest way to test this is to just clone this repo, then run [this](https://registry.hub.docker.com/u/devdb/kafka/)
docker container for a development Kafka node with the following:
```
docker pull devdb/kafka:latest
sudo docker run -d --net host --name kafka -p 2181:2181 -p 9092:9092 devdb/kafka
sudo docker exec -it kafka bin/kafka-console-consumer.sh --zookeeper localhost:2181 --from-beginning --topic test
```
This will start up Kafka and start consuming the topic test to the console.

The open another terminal and run the test code:
```
./activator "run 1234"
```

If everything works this should produce **1234** events on the Kafka topic **test** which the should be
consumed and outputted in the other terminal.


## Licence ##

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

Copyright &copy; 2015- Björn Westlin.
