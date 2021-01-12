package heroes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Properties;

@RestController
@RequestMapping("/api/translations")
public class TranslationsController {

  private final AllPropertiesReloadableResourceBundleMessageSource messageSource;

  public TranslationsController(AllPropertiesReloadableResourceBundleMessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @GetMapping("{lang}.json")
  public Properties translations(@PathVariable("lang") String lang) {
    return messageSource.getAllProperties(Locale.forLanguageTag(lang));
  }
}
