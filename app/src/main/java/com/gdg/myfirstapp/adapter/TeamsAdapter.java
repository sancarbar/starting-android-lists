package com.gdg.myfirstapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gdg.myfirstapp.R;
import com.gdg.myfirstapp.json.Team;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * @author Santiago Carrillo
 */
public class TeamsAdapter
    extends RecyclerView.Adapter<TeamsAdapter.ViewHolder>
{
    private final List<Team> teams;


    public TeamsAdapter( List<Team> teams )
    {
        this.teams = teams;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i )
    {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.team_row, viewGroup, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position )
    {
        Team team = teams.get( position );
        viewHolder.name.setText( team.getName() );
        viewHolder.shortName.setText( team.getShortName() );
        ImageLoader.getInstance().displayImage( team.getImageUrl(), viewHolder.logo );
    }

    @Override
    public int getItemCount()
    {
        return teams.size();
    }

    public static class ViewHolder
        extends RecyclerView.ViewHolder
    {

        TextView name;

        TextView shortName;

        ImageView logo;

        public ViewHolder( View view )
        {
            super( view );
            name = (TextView) view.findViewById( R.id.name );
            shortName = (TextView) view.findViewById( R.id.shortName );
            logo = (ImageView) view.findViewById( R.id.logo );
        }
    }
}