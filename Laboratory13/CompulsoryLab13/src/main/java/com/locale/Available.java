package com.locale;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import static java.util.Locale.*;

public class Available {


    /**
     * This method provides the default locale.
     */
    public void defaultLocale() {
        Locale localeInfo;
        System.out.println("Default locale:");
        localeInfo = getDefault();
        System.out.println(localeInfo);
    }

    public void availableLocale() {

        System.out.println("------------------------------------------");
        Locale[] available = Locale.getAvailableLocales();
        System.out.println("Number of available locales=" + available.length);
        sortLocalesOnToString(available);
        System.out.println("Available locales:");
        for (Locale locale : available) {
            System.out.println("Country=" + locale.getDisplayCountry() + " " + "Language=" + locale.getDisplayLanguage(locale));

        }

    }

    /**
     * Comparator method.
     *
     * @param locales array
     */
    public static void sortLocalesOnToString(Locale[] locales) {
        Comparator<Locale> localeComparator = Comparator.comparing(Locale::toString);
        Arrays.sort(locales, localeComparator);
    }

}