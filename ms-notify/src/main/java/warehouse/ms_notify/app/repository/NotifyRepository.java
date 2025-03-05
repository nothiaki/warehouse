package warehouse.ms_notify.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import warehouse.ms_notify.core.domain.notify.Notify;

public interface NotifyRepository extends JpaRepository<Notify, UUID> {}
