import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;

import com.intellij.psi.impl.PsiJavaParserFacadeImpl;
import org.jetbrains.annotations.NotNull;

public class ChangeNameQuickFix implements LocalQuickFix {

    @Override
    public @IntentionFamilyName @NotNull String getFamilyName() {
        return "Change to a proper name";
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        PsiJavaParserFacade facade = JavaPsiFacade.getInstance(project).getParserFacade();
        descriptor.getPsiElement().replace(facade.createTypeElementFromText("properStringName",descriptor.getPsiElement().getContext()));

        NotificationGroup notification = new NotificationGroup("changeStringName", NotificationDisplayType.BALLOON,true);
        notification.createNotification("String name changed !",
                "Name of the string changed at line " +(descriptor.getLineNumber()+1),
                NotificationType.INFORMATION,
                null).notify(null);
    }
}
