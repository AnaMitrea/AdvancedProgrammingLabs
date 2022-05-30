package com.locale;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * Constructor.
 */
public class Information {

    /**
     * Informations about the current or a specific locale.
     */
    public void getInfo() {

        System.out.println("---------------------");
        Locale locale = Locale.getDefault();
        Currency cur1 = Currency.getInstance(locale);
        String language = locale.getDisplayLanguage();
        String country = locale.getDisplayCountry();
        String currency = cur1.getSymbol(locale);
        System.out.println("Current locale=" + locale);
        System.out.println("Country=" + country);
        System.out.println("Language=" + language);
        System.out.println("Currency=" + currency);

        System.out.print("Week Days:");
        WeekFields wf = WeekFields.of(locale);
        DayOfWeek day = wf.getFirstDayOfWeek();
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            System.out.print(day.getDisplayName(TextStyle.FULL_STANDALONE, locale) + " ");
            day = day.plus(1);
        }

        System.out.print("\nMonths=");
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.getDefault());
        String[] germanyMonths = dfs.getMonths();
        for (String germanyMonth : germanyMonths) {
            System.out.print(germanyMonth + " ");
        }

        System.out.print("Today=");
        Instant now = Instant.now();

        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
        Date today = new Date();
        System.out.print(dateFormat.format(today));
    }
}
