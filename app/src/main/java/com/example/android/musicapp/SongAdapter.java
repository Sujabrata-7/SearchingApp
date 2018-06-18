package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SongAdapter extends BaseAdapter implements Filterable{
    Context mContext;
    LayoutInflater inflater;
    private List<Song> songList;
    private ArrayList<Song> arrayList;

    public SongAdapter(Context context,List<Song> song){
        mContext=context;
        this.songList=song;
        inflater=LayoutInflater.from(mContext);
        this.arrayList=new ArrayList<Song>();
        this.arrayList.addAll(songList);

    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public class ViewHolder{
        TextView songname;
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Song getItem(int position) {
        return songList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder holder;
        View listItemView= convertView;
        if(listItemView==null){
            holder=new ViewHolder();
            listItemView=inflater.inflate(R.layout.list_item,null);
            holder.songname=(TextView)listItemView.findViewById(R.id.song_name);
            listItemView.setTag(holder);
        }
     else {
        holder = (ViewHolder) listItemView.getTag();
    }
        holder.songname.setText(songList.get(position).returnText());
        return listItemView;
    }

    // Filter Class
   public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        songList.clear();
        if (charText.length() == 0) {
            songList.addAll(arrayList);
        } else {
            for (Song wp : arrayList) {
                if (wp.returnText().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                  songList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
