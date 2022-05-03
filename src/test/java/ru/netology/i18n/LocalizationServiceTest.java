package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceTest {

    @Test
    public void LocaleTestRus(){
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, localizationService.locale(Country.RUSSIA));
    }

    @Test
    public void LocaleTestUsa(){
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = "Welcome";
        Assertions.assertEquals(expected, localizationService.locale(Country.USA));
    }
}
