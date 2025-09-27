package ifellow.tools;

import java.util.Properties;

public class Config extends Properties {
    public Config() {
        super();
        try (var stream = Config.class.getResourceAsStream("src/main/java/resources/config.properties")) {
            load(stream);
        }
        catch (Exception ignored) { }
    }
}
