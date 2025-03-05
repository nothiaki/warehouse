package warehouse.ms_notify.infra.config.kafka;

public class KafkaProperties {

  public static final String BOOTSTRAP_SERVERS = "${spring.kafka.bootstrap-servers}";
  public static final String GROUP_ID = "${spring.kafka.consumer.group-id}";
  public static final String AUTO_OFFSET_RESET = "${spring.kafka.consumer.auto-offset-reset}";

  public static final String MS_NOTIFY_PROCESS = "${spring.kafka.topic.ms-notify.process}";

  public static final String API_GATEWAY_END_SAGA = "${spring.kafka.topic.api-gateway.end-saga}";
  public static final String MS_PRODUCT_FAIL = "${spring.kafka.topic.ms-product.fail}";

}
