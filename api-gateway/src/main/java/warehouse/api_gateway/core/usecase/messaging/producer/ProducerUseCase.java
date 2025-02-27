package warehouse.api_gateway.core.usecase.messaging.producer;

public interface ProducerUseCase {

  public void execute(String topic, String Payload);

}
