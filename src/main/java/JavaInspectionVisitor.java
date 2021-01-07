import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

public class JavaInspectionVisitor extends JavaElementVisitor {

    ProblemsHolder problemsHolder;

    public JavaInspectionVisitor(@NotNull ProblemsHolder holder) {
        problemsHolder = holder;
    }

    @Override
    public void visitJavaFile(PsiJavaFile file) {
        System.out.println(" File " + file.getName() + " visited and checked!");
        super.visitJavaFile(file);
    }

    @Override
    public void visitElement(@NotNull PsiElement element) {
        if (element.getText().equals("string") && element.getPrevSibling().getPrevSibling().getText().equals("String")) {
            problemsHolder.registerProblem(element, "This is not a proper name", new ChangeNameQuickFix());
        }
        super.visitElement(element);
    }

}