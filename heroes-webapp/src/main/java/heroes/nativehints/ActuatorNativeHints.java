package heroes.nativehints;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.lang.Nullable;

/**
 * TODO remove when this is fixed
 * https://github.com/oracle/graalvm-reachability-metadata/pull/113
 */
public class ActuatorNativeHints implements RuntimeHintsRegistrar {

  @Override
  public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
    hints
      .reflection()
      .registerType(
        java.lang.management.MemoryUsage.class,
        MemberCategory.INTROSPECT_PUBLIC_METHODS
      );
    hints
      .reflection()
      .registerType(
        java.lang.management.ThreadInfo.class,
        MemberCategory.INTROSPECT_PUBLIC_METHODS
      );
    hints
      .reflection()
      .registerType(java.lang.management.LockInfo.class, MemberCategory.INTROSPECT_PUBLIC_METHODS);
    hints
      .reflection()
      .registerType(
        java.lang.management.MonitorInfo.class,
        MemberCategory.INTROSPECT_PUBLIC_METHODS
      );
    hints
      .reflection()
      .registerType(java.lang.StackTraceElement.class, MemberCategory.INTROSPECT_PUBLIC_METHODS);
  }
}
