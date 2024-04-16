package Heroku.Project.Controller;

import Heroku.Project.Tables.Seller;
import Heroku.Project.Tables.User;
import Heroku.Project.Repo.SellerRepository;
import Heroku.Project.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found with id: " + id));
        return ResponseEntity.ok(seller);
    }

    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerRepository.save(seller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller sellerDetails) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found with id: " + id));

        // Update user if needed, here you should add logic to handle user changes or verification
        seller.setUser(sellerDetails.getUser());
        seller.setSellerType(sellerDetails.getSellerType());
        seller.setSellerDescription(sellerDetails.getSellerDescription());
        seller.setPaymentModel(sellerDetails.getPaymentModel());

        final Seller updatedSeller = sellerRepository.save(seller);
        return ResponseEntity.ok(updatedSeller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found with id: " + id));

        sellerRepository.delete(seller);
        return ResponseEntity.noContent().build();
    }
}
