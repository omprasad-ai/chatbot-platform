@RestController
public class ProjectController {

    private final ProjectRepository repo;

    public ProjectController(ProjectRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/project")
    public Project create(@RequestBody Project project) {
        return repo.save(project);
    }
}
