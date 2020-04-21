package ru.kpfu.itis.deadathomeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.deadathomeapi.dto.HousesDto;
import ru.kpfu.itis.deadathomeapi.models.House;
import ru.kpfu.itis.deadathomeapi.models.User;
import ru.kpfu.itis.deadathomeapi.repository.HousesRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static ru.kpfu.itis.deadathomeapi.dto.HousesDto.from;

@Service
public class HousesServiceImpl implements HousesService {


    @Autowired
    private HousesRepository housesRepository;

    @Override
    public List<HousesDto> getHouses() {
        return from(housesRepository.findAll());
    }

    @Override
    public HousesDto getConcreteHouse(Long houseId) {
        return from(housesRepository.getOne(houseId));
    }

    @Override
    public List<HousesDto> search(String name) {
        return from(housesRepository.search(name));
    }

}
