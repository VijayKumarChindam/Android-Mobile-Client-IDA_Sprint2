package org.intelehealth.app.activities.healthWorkerListActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.intelehealth.app.R;

import java.util.ArrayList;

public class NurseAdapter extends RecyclerView.Adapter<NurseAdapter.ViewHolder>  {
    public Context context;
    public ArrayList<String> nurseNames;
    public ArrayList<String> role;
    public ArrayList<String> cases;

    public NurseAdapter(Context context, ArrayList<String> nurseNames, ArrayList<String> role, ArrayList<String> cases) {
        this.context = context;
        this.nurseNames = nurseNames;
        this.role = role;
        this.cases = cases;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nurse_row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String Name="Name:-"+nurseNames.get(position);
        String Role="Role:-"+role.get(position);
        String Cases="Cases:-"+cases.get(position);
        holder.Setdata(Name,Role,Cases);
    }

    @Override
    public int getItemCount() {
        return nurseNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName,textViewRole,textViewCases;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.hw_Name);
            textViewRole=itemView.findViewById(R.id.hw_Role);
            textViewCases=itemView.findViewById(R.id.hw_Cases);

        }

        public void Setdata(String name, String role, String cases) {
            textViewName.setText(name);
            textViewRole.setText(role);
            textViewCases.setText(cases);

        }
    }
}
