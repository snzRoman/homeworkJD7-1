package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    @Test
    public void MessageSenderTestRussia(){
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172."))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");

        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, messageSender.send(headers));

    }

    @Test
    public void MessageSenderTestUsa(){
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96."))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");

        String expected = "Welcome";
        Assertions.assertEquals(expected, messageSender.send(headers));

    }

}
