package heroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Properties;

@SpringBootApplication
public class HeroesApplication {
  public static void main(String[] args) {
    SpringApplication.run(HeroesApplication.class, args);
  }

  @Bean
  public AllPropertiesReloadableResourceBundleMessageSource messageSource() {
    var localMessageSource = new AllPropertiesReloadableResourceBundleMessageSource();
    localMessageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
    localMessageSource.setBasename("messages");
    localMessageSource.setFallbackToSystemLocale(false);
    localMessageSource.getAllProperties(Locale.ENGLISH);
    localMessageSource.getAllProperties(Locale.GERMAN);
    return localMessageSource;
  }
}

/**
 * {@link ReloadableResourceBundleMessageSource} providing all properties.
 */
class AllPropertiesReloadableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {

  public Properties getAllProperties(Locale locale) {
    return super.getMergedProperties(locale).getProperties();
  }
}
