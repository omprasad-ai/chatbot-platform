@Entity
public class Project {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private User user;
}
