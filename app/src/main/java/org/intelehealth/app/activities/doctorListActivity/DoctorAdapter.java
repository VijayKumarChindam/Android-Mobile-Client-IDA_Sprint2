package org.intelehealth.app.activities.doctorListActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.intelehealth.app.R;

import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    public Context context;
    public ArrayList<String> doctorNames;
    public ArrayList<String> role;
    public ArrayList<String> date;
    public ArrayList<String> cases;

    public DoctorAdapter(Context context, ArrayList<String> doctorNames, ArrayList<String> role, ArrayList<String> date, ArrayList<String> cases) {
        this.context = context;
        this.doctorNames = doctorNames;
        this.role = role;
        this.date = date;
        this.cases = cases;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doctor_row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String Name="Name:-"+doctorNames.get(position);
        String Role="Role:-"+role.get(position);
        String Date="TAT:-"+date.get(position);
        String Cases="Cases:-"+cases.get(position);
        holder.Setdata(Name,Role,Date,Cases);
    }

    @Override
    public int getItemCount() {
       return doctorNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName,textViewRole,textViewCases,textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.d_Name);
            textViewRole=itemView.findViewById(R.id.d_Role);
            textViewCases=itemView.findViewById(R.id.d_Cases);
            textViewDate=itemView.findViewById(R.id.d_TAT);

        }

        public void Setdata(String name, String role, String date, String cases) {
            textViewName.setText(name);
            textViewRole.setText(role);
            textViewDate.setText(date);
            textViewCases.setText(cases);

        }
    }
}
