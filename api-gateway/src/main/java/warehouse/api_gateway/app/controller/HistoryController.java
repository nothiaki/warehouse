package warehouse.api_gateway.app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import warehouse.api_gateway.core.domain.history.History;
import warehouse.api_gateway.core.usecase.history.FindOneHistoryUseCase;

@RestController
@RequestMapping("/history")
public class HistoryController {

  @Autowired
  private FindOneHistoryUseCase findOneHistoryUseCase;

  @GetMapping("/{id}")
  public ResponseEntity<History> findOne(@PathVariable UUID id) {
    return ResponseEntity.ok(findOneHistoryUseCase.execute(id));
  }

}
