package heroes;

import at.porscheinformatik.weblate.spring.AllPropertiesReloadableResourceBundleMessageSource;
import at.porscheinformatik.weblate.spring.AllPropertiesSource;
import at.porscheinformatik.weblate.spring.WeblateMessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class HeroesApplication {
  public static void main(String[] args) {
    SpringApplication.run(HeroesApplication.class, args);
  }

  @Bean
  public AllPropertiesSource messageSource(WeblateProperties weblate) {
    if (weblate.getBaseUrl() != null) {
      var weblateMessageSource = new WeblateMessageSource();
      weblateMessageSource.setAsync(true);
      weblateMessageSource.setBaseUrl(weblate.getBaseUrl());
      weblateMessageSource.setProject(weblate.getProject());
      weblateMessageSource.setComponent(weblate.getComponent());
      weblateMessageSource.useAuthentication(weblate.getAuthentication());
      weblateMessageSource.setParentMessageSource(localMessageSource());
      return weblateMessageSource;
    } else {
      return localMessageSource();
    }
  }

  private static AllPropertiesReloadableResourceBundleMessageSource localMessageSource() {
    var localMessageSource = new AllPropertiesReloadableResourceBundleMessageSource();
    localMessageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
    localMessageSource.setBasename("classpath:messages");
    localMessageSource.setFallbackToSystemLocale(false);
    return localMessageSource;
  }
}
