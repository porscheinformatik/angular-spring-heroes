package heroes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping({"/", "/heroes", "/dashboard", "/detail/*"})
  public String index() {
    return "forward:/index.html";
  }

}
