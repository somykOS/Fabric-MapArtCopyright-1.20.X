package net.somyk.mapartcopyright.util;

import net.fabricmc.loader.api.FabricLoader;
import org.simpleyaml.configuration.comments.format.YamlCommentFormat;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static net.somyk.mapartcopyright.MapArtCopyright.*;

public class ModConfig {

    public static void registerConfigs() {
        Path path = (FabricLoader.getInstance().getConfigDir());
        Path path2 = path.resolve(Paths.get("MapArtCopyright"));
        final YamlFile config = new YamlFile((path2.resolve( "config.yml" ).toFile()).getAbsolutePath());
        try {
            if (!config.exists()) {
                config.createNewFile();
                LOGGER.info("New file has been created: " + (path2.resolve( "config.yml" ).toFile()).getPath());
            } else {
                LOGGER.info((path2.resolve( "config.yml" ).toFile()).getPath() + " already exists, loading configurations...");
            }
            config.loadWithComments();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        config.addDefault("copyright", true);
        config.addDefault("displayAuthors", true);
        config.addDefault("disableCopy", false);
        config.addDefault("authorsCanCopy", true);
        config.addDefault("authorsCanAddAuthors", false);
        config.addDefault("cleanMap", false);

        config.setCommentFormat(YamlCommentFormat.PRETTY);
        config.setComment("copyright", "Adds NBT 'authors' while creating new filled map");
        config.setComment("displayAuthors", "Works if 'copyright' is/was 'true'");
        config.setComment("disableCopy", "Nobody can make a copy of a map (except authors if 'authorsCanCopy' is 'true')");
        config.setComment("authorsCanCopy", "Works if 'copyright' is/was 'true'");
        config.setComment("authorsCanAddAuthors", "Command /newAuthor <player> works if it's true");
        config.setComment("cleanMap", "Allows to clean map with a bucket of water in a cartography table");

        try {
            config.save();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean getBooleanValue(String key){
        Path path = (FabricLoader.getInstance().getConfigDir());
        Path path2 = path.resolve(Paths.get("MapArtCopyright"));
        final YamlFile config = new YamlFile((path2.resolve( "config.yml" ).toFile()).getAbsolutePath());
        try {
            config.loadWithComments();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        return config.getBoolean(key);
    }

    public static String getStringValue(String key){
        Path path = (FabricLoader.getInstance().getConfigDir());
        Path path2 = path.resolve(Paths.get("MapArtCopyright"));
        final YamlFile config = new YamlFile((path2.resolve( "config.yml" ).toFile()).getAbsolutePath());
        try {
            config.loadWithComments();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        return config.getString(key);
    }

    public static void setValue(String key, Object newValue){
        Path path = (FabricLoader.getInstance().getConfigDir());
        Path path2 = path.resolve(Paths.get("MapArtCopyright"));
        final YamlFile config = new YamlFile((path2.resolve( "config.yml" ).toFile()).getAbsolutePath());

        try {
            config.loadWithComments();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        config.set(key, newValue);

        try {
            config.save();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
