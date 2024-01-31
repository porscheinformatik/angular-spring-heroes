package heroes.nativehints;

import java.lang.reflect.Constructor;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

public class LiquibaseNativeHints implements RuntimeHintsRegistrar {

  @Override
  public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
    registerConstructor(hints, java.util.ArrayList.class);
    hints.resources().registerPattern("db/changelog/*.xml");

    registerConstructor(hints, liquibase.changelog.ChangeLogHistoryServiceFactory.class);
    registerPublicMethods(hints, liquibase.plugin.AbstractPlugin.class);
    registerPublicMethods(hints, liquibase.change.core.CreateViewChange.class);
    registerPublicMethods(hints, liquibase.change.core.DeleteDataChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropAllForeignKeyConstraintsChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropColumnChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropDefaultValueChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropForeignKeyConstraintChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropIndexChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropNotNullConstraintChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropPrimaryKeyChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropProcedureChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropSequenceChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropTableChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropUniqueConstraintChange.class);
    registerPublicMethods(hints, liquibase.change.core.DropViewChange.class);
    registerPublicMethods(hints, liquibase.change.core.EmptyChange.class);
    registerPublicMethods(hints, liquibase.change.core.ExecuteShellCommandChange.class);
    registerPublicMethods(hints, liquibase.change.core.LoadDataChange.class);
    registerPublicMethods(hints, liquibase.change.core.LoadUpdateDataChange.class);
    registerPublicMethods(hints, liquibase.change.core.MergeColumnChange.class);
    registerPublicMethods(hints, liquibase.change.core.ModifyDataTypeChange.class);
    registerPublicMethods(hints, liquibase.change.core.OutputChange.class);
    registerPublicMethods(hints, liquibase.change.core.RawSQLChange.class);
    registerPublicMethods(hints, liquibase.change.core.RenameColumnChange.class);
    registerPublicMethods(hints, liquibase.change.core.RenameSequenceChange.class);
    registerPublicMethods(hints, liquibase.change.core.RenameTableChange.class);
    registerPublicMethods(hints, liquibase.change.core.RenameViewChange.class);
    registerPublicMethods(hints, liquibase.change.core.SQLFileChange.class);
    registerPublicMethods(hints, liquibase.change.core.SetColumnRemarksChange.class);
    registerPublicMethods(hints, liquibase.change.core.SetTableRemarksChange.class);
    registerPublicMethods(hints, liquibase.change.core.StopChange.class);
    registerPublicMethods(hints, liquibase.change.core.TagDatabaseChange.class);
    registerPublicMethods(hints, liquibase.change.core.UpdateDataChange.class);
    registerPublicMethods(hints, liquibase.change.custom.CustomChangeWrapper.class);
    registerPublicMethods(hints, liquibase.AbstractExtensibleObject.class);
    registerPublicMethods(hints, liquibase.change.AbstractChange.class);
    registerPublicMethods(hints, liquibase.change.AbstractSQLChange.class);
    registerPublicMethods(hints, liquibase.change.core.AbstractModifyDataChange.class);
    registerPublicMethods(hints, liquibase.change.core.AddAutoIncrementChange.class);
    registerPublicMethods(hints, liquibase.change.core.AddColumnChange.class);
    registerPublicMethods(hints, liquibase.change.core.AddDefaultValueChange.class);
    registerPublicMethods(hints, liquibase.change.core.AddForeignKeyConstraintChange.class);
    registerPublicMethods(hints, liquibase.change.core.AddLookupTableChange.class);
    registerPublicMethods(hints, liquibase.change.core.AddNotNullConstraintChange.class);
    registerPublicMethods(hints, liquibase.change.core.AddPrimaryKeyChange.class);
    registerPublicMethods(hints, liquibase.change.core.AddUniqueConstraintChange.class);
    registerPublicMethods(hints, liquibase.change.core.AlterSequenceChange.class);
    registerPublicMethods(hints, liquibase.change.core.CreateIndexChange.class);
    registerPublicMethods(hints, liquibase.change.core.CreateProcedureChange.class);

    hints
      .reflection()
      .registerType(
        liquibase.change.ConstraintsConfig.class,
        MemberCategory.DECLARED_FIELDS,
        MemberCategory.INVOKE_PUBLIC_METHODS
      );
  }

  private static <T> void registerConstructor(RuntimeHints hints, Class<T> clazz) {
    try {
      Constructor<T> constructor = ReflectionUtils.accessibleConstructor(clazz);
      hints.reflection().registerConstructor(constructor, ExecutableMode.INVOKE);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  private static <T> void registerPublicMethods(RuntimeHints hints, Class<T> clazz) {
    hints.reflection().registerType(clazz, MemberCategory.INVOKE_PUBLIC_METHODS);
  }
}
