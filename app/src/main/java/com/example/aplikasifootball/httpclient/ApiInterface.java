package com.example.aplikasifootball.httpclient;

import com.example.aplikasifootball.model.ResponseAllLeague;
import com.example.aplikasifootball.model.ResponseDetailLeague;
import com.example.aplikasifootball.model.ResponseLastEvent;
import com.example.aplikasifootball.model.ResponseNextEvent;
import com.example.aplikasifootball.model.ResponseLookupTeam;
import com.example.aplikasifootball.model.ResponseAllTeam;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("search_all_leagues.php?s=Soccer")
    Call<ResponseAllLeague> getAllLeague();

    @GET("lookupleague.php")
    Call<ResponseDetailLeague> getDetailLeague(@Query("id") String id);

    @GET("eventsnextleague.php")
    Call<ResponseNextEvent> getNextEventByLeague(@Query("id") String id);

    @GET("eventspastleague.php")
    Call<ResponseLastEvent> getLastEventByLeague(@Query("id") String id);

    @GET("lookupteam.php")
    Call<ResponseLookupTeam> getLookupTeam(@Query("id") String id);

    @GET("lookup_all_teams.php")
    Call<ResponseAllTeam> getAllTeam(@Query("id") String id);
}
