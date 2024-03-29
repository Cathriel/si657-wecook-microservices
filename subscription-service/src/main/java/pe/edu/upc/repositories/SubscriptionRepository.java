package pe.edu.upc.repositories;

import pe.edu.upc.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    public Optional<List<Subscription>> findSubscriptionsByChefId(long chefId);
}
