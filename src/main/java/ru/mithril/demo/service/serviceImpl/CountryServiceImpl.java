package ru.mithril.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mithril.demo.dao.daoInterface.CountryDao;
import ru.mithril.demo.model.Country;
import ru.mithril.demo.model.mapper.CountryMapperFacade;
import ru.mithril.demo.service.serviceInterface.CountryService;
import ru.mithril.demo.view.CountryView;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;
    private final CountryMapperFacade countryMapperFacade;


    @Autowired
    public CountryServiceImpl(CountryDao countryDao, CountryMapperFacade countryMapperFacade) {
        this.countryMapperFacade = countryMapperFacade;
        this.countryDao = countryDao;
    }


    @Override
    public List<CountryView> country(CountryView countryView) {
        Country country = countryMapperFacade.mapToEntity(countryView);
        List<Country> countries = countryDao.country(country);
        return countryMapperFacade.mapAsListView(countries);
    }
}
