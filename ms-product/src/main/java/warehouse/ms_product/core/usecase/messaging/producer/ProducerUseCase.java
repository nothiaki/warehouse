package warehouse.ms_product.core.usecase.messaging.producer;

public interface ProducerUseCase {
  public void execute(String topic, String payload);
}
