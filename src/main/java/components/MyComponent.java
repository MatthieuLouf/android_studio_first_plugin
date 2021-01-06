package components;

import com.intellij.ide.plugins.PluginManager;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.intellij.util.xmlb.annotations.Attribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@State(
        name="MyConfiguration",
        storages ={@Storage("myConfiguration.xml")})
public class MyComponent implements ApplicationComponent, PersistentStateComponent<MyComponent> {

    @Attribute
    private String localVersion = "0.0.0";
    private String version;

    @Override
    public void initComponent() {
        version = Objects.requireNonNull(PluginManager.getPlugin(PluginId.getId("org.example.android_studio_first_plugin"))).getVersion();

        if (isANewVersion()) {
            updateLocalVersion();

            NotificationGroup notification = new NotificationGroup("myplugin", NotificationDisplayType.BALLOON,true);
            notification.createNotification("Plugin updated",
                    "Welcome to the new version",
                    NotificationType.INFORMATION,
                    null).notify(null);
        }
    }

    private Boolean isANewVersion() {
        String[] s1 = localVersion.split("-")[0].split("\\.");
        System.out.println(localVersion);
        System.out.println(version);
        String[] s2 = version.split("-")[0].split("\\.");

        if (s1.length != s2.length) return false;
        int i = 0;
        do {
            if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])) {
                return true;
            }
            i++;
        } while (i < s1.length);

        return false;
    }

    private void updateLocalVersion() {
        localVersion = version;
    }

    @Override
    public @Nullable MyComponent getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull MyComponent state) {
        XmlSerializerUtil.copyBean(state,this);
    }
}
