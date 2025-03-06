package warehouse.api_gateway.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import warehouse.api_gateway.core.domain.history.History;

public interface HistoryRepository extends JpaRepository<History, UUID> {}
