package Heroku.Project.Controller;

import Heroku.Project.Entity.Dataset;
import Heroku.Project.Repo.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datasets")
public class DatasetController {

    @Autowired
    private DatasetRepository datasetRepository;


    @GetMapping("/get/all")
    public List<Dataset> getAllDatasets() {
        return datasetRepository.findAll();
    }

    @PostMapping("/create")
    public Dataset createDataset(@RequestBody Dataset dataset) {
        return datasetRepository.save(dataset); // Save the Dataset with the Permission set
    }

    // Additional endpoints as needed
}
