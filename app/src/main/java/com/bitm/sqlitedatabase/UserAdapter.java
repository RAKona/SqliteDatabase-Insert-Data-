package com.bitm.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    private List<User> users;
    private Context context;

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_userrecyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        User user =users.get(position);

       holder.id.setText(String.valueOf(user.getId()));
       holder.name.setText(user.getName());
       holder.age.setText(user.getAge());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id,name,age;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.idTV);
            name=itemView.findViewById(R.id.nameTV);
            age=itemView.findViewById(R.id.ageTV);
        }
    }
}
