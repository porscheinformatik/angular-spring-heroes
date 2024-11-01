package heroes.nativehints;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration
@ImportRuntimeHints({ LiquibaseNativeHints.class, MessagesNativeHints.class })
public class NativeHintsConfig {}
