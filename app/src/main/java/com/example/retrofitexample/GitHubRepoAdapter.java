package com.example.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class GitHubRepoAdapter extends ArrayAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<GitHubRepo> list;
    GitHubRepoAdapter(Context context, int resource, List<GitHubRepo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null)
        {
            view = inflater.inflate(R.layout.rows,null);
        }
        TextView name = (TextView)view.findViewById(R.id.name);
        TextView description = (TextView) view.findViewById(R.id.desc);

        GitHubRepo gitHubRepo = list.get(position);
        if(name != null)
        {
            name.setText(gitHubRepo.getName());
            description.setText(gitHubRepo.getDescription());
        }

        return view;
    }

}
