package warehouse.ms_notify.core.usecase.messaging.producer;

public interface ProducerUseCase {
  public void execute(String topic, String payload);
}
