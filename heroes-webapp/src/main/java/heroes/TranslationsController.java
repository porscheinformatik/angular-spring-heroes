package heroes;

import at.porscheinformatik.weblate.spring.AllPropertiesSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Properties;

@RestController
@RequestMapping("/api/translations")
public class TranslationsController {

  private final AllPropertiesSource messageSource;

  public TranslationsController(AllPropertiesSource messageSource) {
    this.messageSource = messageSource;
  }

  @GetMapping("{lang}.json")
  public Properties translations(@PathVariable("lang") String lang) {
    return messageSource.getAllProperties(Locale.forLanguageTag(lang));
  }
}
