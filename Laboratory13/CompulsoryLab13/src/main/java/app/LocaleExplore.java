package app;
import java.util.Locale;
import java.util.Scanner;
import com.locale.Available;
import com.locale.Information;
import com.locale.Settings;

/**
 * Main class.
 */
public class LocaleExplore {


    public void start() {

        System.out.println("Commands:");
        System.out.println("[DisplayLocales: to display all available locales]");
        System.out.println("[SetLocale: to set the application current locale]");
        System.out.println("[Info: to display informations about the current or a specific locale.]");
        System.out.println("[Exit: to stop the application]");

        while (true) {

            Locale locale1 = Locale.getDefault();
            Resources resourceProperties = new Resources(locale1);
            System.out.printf("%s $ ", resourceProperties.getPrompt());
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\nEnter a command:");
            String command = keyboard.nextLine();

            switch (command) {
                case "Exit" -> System.exit(0);
                case "DisplayLocales" -> {
                    System.out.printf("%s\n", resourceProperties.getLocales());
                    Available locale = new Available();
                    locale.defaultLocale();
                    locale.availableLocale();
                }
                case "SetLocale" -> {
                    Settings setLocale = new Settings();
                    System.out.println("Please, enter the language tag from here <https://en.wikipedia.org/wiki/IETF_language_tag>:");
                    String type = keyboard.nextLine();
                    setLocale.setCurrentLocale(java.util.Locale.forLanguageTag(type));
                    resourceProperties = new Resources(java.util.Locale.forLanguageTag(type));
                    System.out.println(resourceProperties.getLocaleSet());
                }
                case "Info" -> {
                    System.out.println(resourceProperties.getInfo());
                    Information information = new Information();
                    information.getInfo();

                }

            }
        }

    }

}

