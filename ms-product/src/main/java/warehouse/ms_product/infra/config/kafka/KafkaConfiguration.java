package warehouse.ms_product.infra.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

  @Autowired
  private KafkaProperties kafkaProperties;

  private static final Integer PARTITION_COUNT = 1;
  private static final Integer REPLICA_COUNT = 1;

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
      return new DefaultKafkaConsumerFactory<>(consumerProps());
  }

  private Map<String, Object> consumerProps() {
      var props = new HashMap<String, Object>();
      props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
      props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupId());
      props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getBootstrapServers());
      return props;
  }

  @Bean
  public ProducerFactory<String, String> producerFactory() {
      return new DefaultKafkaProducerFactory<>(producerProps());
  }

  private Map<String, Object> producerProps() {
      var props = new HashMap<String, Object>();
      props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
      props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
      props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
      return props;
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
      return new KafkaTemplate<>(producerFactory);
  }

  private NewTopic buildTopic(String name) {
      return TopicBuilder
          .name(name)
          .partitions(PARTITION_COUNT)
          .replicas(REPLICA_COUNT)
          .build();
  }

  @Bean
  public NewTopic topicMsProductCreate() {
      return buildTopic(kafkaProperties.getMsProductCreate());
  }

}
