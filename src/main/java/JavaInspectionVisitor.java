import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class JavaInspectionVisitor extends PsiElementVisitor {

    ProblemsHolder problemsHolder;
    public JavaInspectionVisitor(@NotNull ProblemsHolder holder) {
        problemsHolder = holder;
    }

    @Override
    public void visitElement(@NotNull PsiElement element) {
        if(element.getText().equals("string") && element.getPrevSibling().getPrevSibling().getText().equals("String"))
        {
            problemsHolder.registerProblem(element,"This is not a proper name");
        }
        super.visitElement(element);
    }

    @Override
    public void visitFile(@NotNull PsiFile file) {
        super.visitFile(file);
    }

}