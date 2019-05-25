package ru.mithril.demo.service.serviceInterface;

import org.springframework.validation.annotation.Validated;
import ru.mithril.demo.view.CountryView;

import java.util.List;
@Validated
public interface CountryService {
    List<CountryView> country(CountryView countryView);
}
