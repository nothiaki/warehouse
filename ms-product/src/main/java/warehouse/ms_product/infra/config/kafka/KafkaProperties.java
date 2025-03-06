package warehouse.ms_product.infra.config.kafka;

public class KafkaProperties {

  public static final String BOOTSTRAP_SERVERS = "${spring.kafka.bootstrap-servers}";
  public static final String GROUP_ID = "${spring.kafka.consumer.group-id}";
  public static final String AUTO_OFFSET_RESET = "${spring.kafka.consumer.auto-offset-reset}";

  public static final String MS_PRODUCT_CREATE = "${spring.kafka.topic.ms-product.create}";
  public static final String MS_NOTIFY_PROCESS = "${spring.kafka.topic.ms-notify.process}";
  public static final String MS_PRODUCT_PROCESS = "${spring.kafka.topic.ms-product.process}";
  public static final String MS_CATEGORY_FAIL = "${spring.kafka.topic.ms-category.fail}";

}
