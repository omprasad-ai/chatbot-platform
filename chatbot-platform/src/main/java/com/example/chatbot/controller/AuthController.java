@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwt;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository repo, JwtUtil jwt, PasswordEncoder encoder) {
        this.repo = repo;
        this.jwt = jwt;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = repo.findByEmail(user.getEmail());
        if (encoder.matches(user.getPassword(), dbUser.getPassword())) {
            return jwt.generateToken(dbUser.getEmail());
        }
        throw new RuntimeException("Invalid credentials");
    }
}
