package Heroku.Project.Controller;


import Heroku.Project.Repo.PermissionRepository;
import Heroku.Project.Tables.Dataset;
import Heroku.Project.Repo.DatasetRepository;
import Heroku.Project.Tables.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datasets")
public class DatasetController {

    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @GetMapping("/get/all")
    public List<Dataset> getAllDatasets() {
        return datasetRepository.findAll();
    }

    @PostMapping("/create")
    public Dataset createDataset(@RequestBody Dataset dataset) {
        // Assuming your Dataset entity has been modified to include a transient permissionId field
        // Or if you're using a DTO, it would include permissionId as well
        Long permissionId = dataset.getPermissionId().getPermissionsId(); // Get this from your Dataset entity or DTO
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found with id " + permissionId));

        dataset.setPermission(permission); // Set the fetched Permission to the Dataset

        return datasetRepository.save(dataset); // Save the Dataset with the Permission set
    }

    // Additional endpoints as needed
}
