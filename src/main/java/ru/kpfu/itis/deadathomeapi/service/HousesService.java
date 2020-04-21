package ru.kpfu.itis.deadathomeapi.service;

import ru.kpfu.itis.deadathomeapi.dto.HousesDto;
import ru.kpfu.itis.deadathomeapi.models.House;
import ru.kpfu.itis.deadathomeapi.models.User;

import java.util.List;

public interface HousesService {
    List<HousesDto> getHouses();
    HousesDto getConcreteHouse(Long houseId);

    List<HousesDto> search(String name);

}
