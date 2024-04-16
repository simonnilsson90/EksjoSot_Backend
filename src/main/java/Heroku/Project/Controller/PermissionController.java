package Heroku.Project.Controller;

import Heroku.Project.Repo.PermissionRepository;
import Heroku.Project.Tables.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    @GetMapping
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Permission getPermissionById(@PathVariable Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with id " + id));
    }

    @PostMapping
    public Permission createPermission(@RequestBody Permission permission) {
        return permissionRepository.save(permission);
    }

    @PutMapping("/{id}")
    public Permission updatePermission(@PathVariable Long id, @RequestBody Permission permissionDetails) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with id " + id));

        permission.setUserType(permissionDetails.getUserType());
        permission.setDescription(permissionDetails.getDescription());

        return permissionRepository.save(permission);
    }

    @DeleteMapping("/{id}")
    public void deletePermission(@PathVariable Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found with id " + id));

        permissionRepository.delete(permission);
    }
}
