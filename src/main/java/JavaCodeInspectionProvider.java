import com.intellij.codeInspection.InspectionToolProvider;

public class JavaCodeInspectionProvider implements InspectionToolProvider {
    public Class[] getInspectionClasses() {
        return new Class[]{
                JavaCodeInspection.class
        };
    }
}