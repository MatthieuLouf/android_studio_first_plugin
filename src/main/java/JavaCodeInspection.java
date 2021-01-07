import com.intellij.codeInspection.LocalInspectionTool;

import com.intellij.codeInspection.ProblemsHolder;
import org.jetbrains.annotations.NotNull;

public class JavaCodeInspection extends LocalInspectionTool {

    /**
     * This method is overridden to provide a custom visitor.
     * The visitor must not be recursive and must be thread-safe.
     *
     * @param holder     object for visitor to register problems found.
     * @param isOnTheFly true if inspection was run in non-batch mode
     * @return {@link JavaInspectionVisitor} instance
     */
    @NotNull
    @Override
    public JavaInspectionVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new JavaInspectionVisitor();
    }

}