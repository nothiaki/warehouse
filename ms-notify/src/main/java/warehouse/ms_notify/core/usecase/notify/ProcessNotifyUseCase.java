package warehouse.ms_notify.core.usecase.notify;

import warehouse.ms_notify.core.domain.history.History;

public interface ProcessNotifyUseCase {

  public void execute(History history);

}
