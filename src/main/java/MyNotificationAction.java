import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class MyNotificationAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        NotificationGroup notificationGroup = new NotificationGroup("AndroidVille", NotificationDisplayType.BALLOON, true);
        notificationGroup.createNotification(
                "Hello from the first plugin",
                "Welcome to AndroidVille's intellig plugin development tutorial",
                NotificationType.INFORMATION,
                null
        ).notify(e.getProject());
    }
}
