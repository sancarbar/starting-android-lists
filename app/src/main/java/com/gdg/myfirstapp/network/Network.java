package com.gdg.myfirstapp.network;

import android.util.Log;
import com.gdg.myfirstapp.json.Team;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 */
public class Network
{

    public static final String TEAMS_URL = "https://raw.githubusercontent.com/sancarbar/starting-android-lists/master/teams.json";

    public List<Team> getTeamsFromUrl( String serverUrl )
    {
        List<Team> teams = new ArrayList<>();
        try
        {
            URL url = new URL( serverUrl );
            InputStreamReader inputStreamReader = new InputStreamReader( url.openStream() );
            BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ( ( line = bufferedReader.readLine() ) != null )
            {
                stringBuilder.append( line );
            }

            inputStreamReader.close();
            String json = stringBuilder.toString();
            JSONArray jsonArray = new JSONArray( json );
            for ( int i = 0; i < jsonArray.length(); i++ )
            {
                JSONObject jsonObject = jsonArray.getJSONObject( i );
                teams.add( new Team( jsonObject ) );
            }

        }
        catch ( Exception e )
        {
            e.printStackTrace();
            Log.e( Network.class.getSimpleName(), "Error loading network data", e.getCause() );
        }
        return teams;
    }
}