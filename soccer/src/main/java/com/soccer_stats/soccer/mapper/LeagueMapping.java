package com.soccer_stats.soccer.mapper;

import com.soccer_stats.soccer.dto.request.league.CreateLeagueRequest;
import com.soccer_stats.soccer.dto.request.league.UpdateLeagueRequest;
import com.soccer_stats.soccer.dto.response.league.GetAllLeagueResponse;
import com.soccer_stats.soccer.dto.response.league.GetByIdLeagueResponse;
import com.soccer_stats.soccer.model.League;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LeagueMapping {

    LeagueMapping INSTANCE = Mappers.getMapper(LeagueMapping.class);

    @Mapping(source = "endDate",target = "endDate")
    League createLeagueMapping(CreateLeagueRequest request);
    League updateLeagueMapping(UpdateLeagueRequest request, @MappingTarget League league);

    GetByIdLeagueResponse getByIdLeague(League league);

    GetAllLeagueResponse getAllLeague(League league);
    List<GetAllLeagueResponse> getAllLeaguetoList(List<League> league);
}
