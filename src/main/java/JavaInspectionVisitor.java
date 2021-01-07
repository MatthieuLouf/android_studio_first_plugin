import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiPlainTextFile;
import org.jetbrains.annotations.NotNull;

public class JavaInspectionVisitor extends PsiElementVisitor {

    @Override
    public void visitElement(@NotNull PsiElement element) {
        System.out.println(element.getText());
        super.visitElement(element);
    }

    @Override
    public void visitFile(@NotNull PsiFile file) {
        System.out.println("File visited ! ");
        super.visitFile(file);
    }

}