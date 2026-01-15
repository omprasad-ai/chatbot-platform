@Controller
public class ChatController {

    private final LlmService llm;

    public ChatController(LlmService llm) {
        this.llm = llm;
    }

    @PostMapping("/chat")
    public String chat(@RequestParam String message, Model model) {
        model.addAttribute("reply", llm.chat(message));
        return "chat";
    }
}
