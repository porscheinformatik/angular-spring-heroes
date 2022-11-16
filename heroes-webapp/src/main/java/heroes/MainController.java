package heroes;

import org.springframework.boot.devtools.autoconfigure.DevToolsProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController implements ApplicationContextAware {

  private Object devToolsProperties;

  @GetMapping({"/", "/heroes", "/dashboard", "/detail/*"})
  public ModelAndView index() {
    Map<String, Object> model = new HashMap<>();
    model.put("azureInstrumentationKey", System.getenv("APPINSIGHTS_INSTRUMENTATIONKEY"));
    model.put("devToolsProperties", devToolsProperties);
    return new ModelAndView("index", model);
  }

  @GetMapping("/lala")
  public String lala() {
    throw new RuntimeException("lala");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    try {
      Class.forName("org.springframework.boot.devtools.autoconfigure.DevToolsProperties");
      this.devToolsProperties = applicationContext.getBean(DevToolsProperties.class);
    } catch (Exception e) {
      // ignore
    }
  }
}
