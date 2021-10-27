package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static Utilities.Log.*;


public class FrameworkUtils {

    protected static void displayWebDriverManagerBrowsersVersions(Boolean showBrowserVersions) {
        if (showBrowserVersions) {
            info(String.format("ChromeDriver available versions: %s", WebDriverManager.chromedriver().getDriverVersions()));
            info(String.format("GeckoDriver available versions: %s", WebDriverManager.firefoxdriver().getDriverVersions()));
            info(String.format("OperaDriver available versions: %s ", WebDriverManager.operadriver().getDriverVersions()));
            info(String.format("EdgeDriver available versions: %s", WebDriverManager.edgedriver().getDriverVersions()));
            info(String.format("IEDriver available versions: %s", WebDriverManager.iedriver().getDriverVersions()));
        }
    }

    public static void deleteOldLogs(boolean flag) {
        if (!flag)
            return;

        try {
            FileUtils.deleteDirectory(new File("logs"));
            FileUtils.deleteDirectory(new File("test-output"));     // fazladan olusani siliyor
        } catch (IOException e) {
            error("Failed to delete logs directory!");
        }
    }

    public static String getCurrentPath() {
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }

    public static void main(String[] args) {
        // displayWebDriverManagerBrowsersVersions(true);
        deleteOldLogs(true);
    }

}
