package java8.ex02;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 02 - LocalDate
 */
public class DateAndTime_02_Test {

    @Test
    public void test_localDate_of() {

        // TODO créer un objet LocalDate à la date 24/12/2050
        LocalDate result = LocalDate.of(2050, 12, 24);

        // TODO valoriser les différentes variables afin de rendre le test passant
        int year = result.get(ChronoField.YEAR);
        Month month = result.getMonth();
        int dayOfMonth = result.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = result.getDayOfWeek();
        int dayOfYear = result.getDayOfYear();

        assertThat(year, is(2050));
        assertThat(month, is(Month.DECEMBER));
        assertThat(dayOfMonth, is(24));
        assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
        assertThat(dayOfYear, is(358));
    }

    @Test
    public void test_localDate_parse() {

        // TODO créer un objet LocalDate à la date 10/01/1990
        // TODO utiliser la méthode parse
        LocalDate result = LocalDate.of(1990, 1, 10);


        // TODO valoriser les différentes variables afin de rendre le test passant
        int year =result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();


        assertThat(year, is(1990));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(10));
    }

    @Test
    public void test_localDate_format() {

        // TODO créer un objet LocalDate à la date 11/03/2015
        // TODO utiliser la méthode of
        LocalDate localDate = LocalDate.of(2015, 3, 11);

        // TODO Formatter la date pour que le test soit passant
        String result = localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy"));

        assertThat(result, is("11 - 03 - 2015"));
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void test_localDate_format_with_hour() {

        // TODO créer un objet LocalDate à la date 11/03/2015
        // TODO utiliser la méthode of
        LocalDate localDate = LocalDate.of(2015, 3, 11);;

        // TODO Formatter la date pour avoir l'affichage suivant : "11/03/2015 00:00:00"
        localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy HH:mm:ss"));
    }

    @Test
    public void test_with() {

        // TODO créer un objet LocalDate à la date 10/01/2000
        // TODO utiliser la méthode of
        LocalDate localDate = LocalDate.of(2000, 1, 10);;

        // TODO transformer la date précédente en 05/02/2015
        LocalDate result = localDate.with(ChronoField.YEAR, 2015).with(Month.FEBRUARY).with(ChronoField.DAY_OF_MONTH, 5);

        assertThat(result.getYear(), is(2015));
        assertThat(result.getMonth(), is(Month.FEBRUARY));
        assertThat(result.getDayOfMonth(), is(5));
    }

}
