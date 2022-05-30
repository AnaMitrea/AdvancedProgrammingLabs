package com.locale;

public class Settings {

    /**
     * This method is used to set the application current locale.
     */
    public void setCurrentLocale(java.util.Locale locale) {

        System.out.println("------------------------------");
        java.util.Locale defaultLocale = java.util.Locale.getDefault();

        System.out.println("Default locale="+defaultLocale);

        java.util.Locale.setDefault(locale);

        java.util.Locale chinaLocale = java.util.Locale.getDefault();

        System.out.println("Current locale="+chinaLocale);
    }
}
