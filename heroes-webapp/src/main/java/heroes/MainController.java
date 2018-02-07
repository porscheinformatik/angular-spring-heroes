package heroes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping({"/", "/heroes", "/dashboard", "/detail/*"})
  public String index() {
    return "forward:/index.html";
  }

  @GetMapping("/lala")
  public String lala() {
    throw new RuntimeException("lala");
  }

}
