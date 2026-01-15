@Entity
public class Prompt {
    @Id @GeneratedValue
    private Long id;
    private String content;

    @ManyToOne
    private Project project;
}
