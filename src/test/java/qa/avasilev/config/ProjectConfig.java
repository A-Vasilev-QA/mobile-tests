package qa.avasilev.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("Google Pixel 3")
    String device();
    @DefaultValue("9.0")
    String osVersion();
    @DefaultValue("browserstack-build")
    String build();
    String login();
    String password();

}
