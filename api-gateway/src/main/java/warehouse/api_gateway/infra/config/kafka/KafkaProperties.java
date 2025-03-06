package warehouse.api_gateway.infra.config.kafka;

public class KafkaProperties {

  public static final String BOOTSTRAP_SERVERS = "${spring.kafka.bootstrap-servers}";
  public static final String GROUP_ID = "${spring.kafka.consumer.group-id}";
  public static final String AUTO_OFFSET_RESET = "${spring.kafka.consumer.auto-offset-reset}";

  public static final String MS_PRODUCT_CREATE = "${spring.kafka.topic.ms-product.create}";
  public static final String MS_CATEGORY_PROCESS = "${spring.kafka.topic.ms-category.process}";

  public static final String API_GATEWAY_END_SAGA = "${spring.kafka.topic.api-gateway.end-saga}";

}
