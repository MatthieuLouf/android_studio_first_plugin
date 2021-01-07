import com.intellij.codeInsight.daemon.GroupNames;
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class JavaCodeInspection extends AbstractBaseJavaLocalInspectionTool {

    public String getDisplayName() {
        return "Naming of a String as string is not recommended ";
    }

    public String getGroupDisplayName() {
        return GroupNames.NAMING_CONVENTIONS_GROUP_NAME;
    }

    public String getShortName() {
        return "StringBasicName";
    }

    public boolean isEnabledByDefault() {
        return true;
    }

    @NotNull
    @Override
    public JavaInspectionVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new JavaInspectionVisitor(holder);
    }

}