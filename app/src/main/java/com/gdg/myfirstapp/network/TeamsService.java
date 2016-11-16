package com.gdg.myfirstapp.network;

import com.gdg.myfirstapp.json.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Santiago Carrillo.
 */

public interface TeamsService
{
    @GET("teams.json")
    Call<List<Team>> listTeams();
}
