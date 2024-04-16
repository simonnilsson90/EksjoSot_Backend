package Heroku.Project.Controller;

import Heroku.Project.Tables.Subscription;
import Heroku.Project.Repo.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Integer id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id: " + id));
        return ResponseEntity.ok(subscription);
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable Integer id, @RequestBody Subscription subscriptionDetails) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id: " + id));

        subscription.setUserId(subscriptionDetails.getUserId());
        subscription.setSubscriptionTypeId(subscriptionDetails.getSubscriptionTypeId());
        subscription.setStartDate(subscriptionDetails.getStartDate());
        subscription.setEndDate(subscriptionDetails.getEndDate());

        final Subscription updatedSubscription = subscriptionRepository.save(subscription);
        return ResponseEntity.ok(updatedSubscription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Integer id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id: " + id));

        subscriptionRepository.delete(subscription);
        return ResponseEntity.noContent().build();
    }
}
