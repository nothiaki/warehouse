package warehouse.ms_category.core.usecase.category;

import warehouse.ms_category.core.domain.history.History;

public interface ProcessCategoryUseCase {

  public void execute(History history);

}
