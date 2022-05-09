package org.intelehealth.app.activities.healthWorkerListActivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.intelehealth.app.R;
import org.intelehealth.app.auth.BasicAuthClient;
import org.intelehealth.app.auth.DemoRemoteService;
import org.intelehealth.app.models.data.EncounterProviders;
import org.intelehealth.app.models.data.Encounters;
import org.intelehealth.app.models.data.Results;
import org.intelehealth.app.models.data.VisitData;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthWorkerListActivity extends AppCompatActivity {
    public Context context=this;
    public ArrayList<String> nurseNames=new ArrayList<String>();
    public ArrayList<String> role = new ArrayList<String>();
    public ArrayList<String> date = new ArrayList<String>();
    public ArrayList<String> cases = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_worker_list);

         healthworkerloadProfile();
        }

        private void healthworkerloadProfile() {
            Call call = (Call) new BasicAuthClient().createService(DemoRemoteService.class).getAllData();
            call.enqueue(new Callback<VisitData>() {

                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onResponse(Call<VisitData> call, Response<VisitData> response) {
                    if (response.isSuccessful()){
                        String details=new Gson().toJson(response.body().results);
                        ArrayList<Results> results=response.body().results;
//                    Log.d("results", new Gson().toJson(results));
                        if (details!=null){
                            for (int i=0;i<results.size();i++) {
//                            Log.d("results", new Gson().toJson(results.get(i)));
                                ArrayList<Encounters> encounters=results.get(i).encounters;
                                for (int j=0;j<encounters.size();j++) {
//                                Log.d("logencounters",new Gson().toJson(encounters.get(j)));
                                    ArrayList<EncounterProviders> encounterProviders=encounters.get(j).encounterProviders;
                                    for (int k=0;k<encounterProviders.size();k++) {
//                                    Log.d("logencounterProviders",new Gson().toJson(encounterProviders.get(k)));
                                        if (results.get(i).encounters.get(j).encounterProviders.get(k).encounterRole.display.contains("Nurse")==true) {
                                            if (results.get(i).encounters.get(j).encounterProviders.get(k).provider.display.contains("Doctor")!=true) {
                                                Log.d("role", results.get(i).encounters.get(j).encounterProviders.get(k).encounterRole.display);
                                                Log.d("nurseNames", results.get(i).encounters.get(j).encounterProviders.get(k).provider.display);
                                                nurseNames.add(results.get(i).encounters.get(j).encounterProviders.get(k).provider.display);
                                                role.add(results.get(i).encounters.get(j).encounterProviders.get(k).encounterRole.display);
                                                cases.add(String.valueOf(results.get(i).encounters.get(j).encounterProviders.get(k).provider.display.length()));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    //Adding Recycler to Adapterm
                    RecyclerView rc_doctor = findViewById(R.id.MainrecyclerView);
                    NurseAdapter nurseAdapter = new NurseAdapter(context,nurseNames,role,cases);
                    rc_doctor.setAdapter(nurseAdapter);
                    rc_doctor.setLayoutManager(new LinearLayoutManager(context));

                    // Sorting Healthworkers name and Cases
                    Map<String, Long> result = nurseNames.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                    System.out.println(result);

                    String sorteddata = result.toString().substring(1, result.toString().length() - 1);
                    System.out.println(sorteddata);
                    String[] sorted=sorteddata.split(",");

                    nurseNames.clear();
                    cases.clear();
                    int k =sorted.length;
                    for (int i=0;i<k;i++){
                        String[] name=sorted[i].split("=");
                        nurseNames.add(name[0]);
                        cases.add(name[1]);
                    }

                }
                @Override
                public void onFailure(Call<VisitData> call, Throwable t) {
                    Log.e("TAG", "response Error");

                }

            });
        }
    }