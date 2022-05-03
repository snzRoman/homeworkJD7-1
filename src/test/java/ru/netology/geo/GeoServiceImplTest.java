package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {

    @ParameterizedTest
    @ValueSource(strings = {"172.21.56.4", "172.1", "172.56.48.444"})
    public void byIpTestRus(String ip){

        GeoService geoService = new GeoServiceImpl();
        Assertions.assertEquals(Country.RUSSIA, geoService.byIp(ip).getCountry());
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.21.56.4", "96.1", "96.56.48.444"})
    public void byIpTestUsa(String ip){

        GeoService geoService = new GeoServiceImpl();
        Assertions.assertEquals(Country.USA, geoService.byIp(ip).getCountry());
    }
}
