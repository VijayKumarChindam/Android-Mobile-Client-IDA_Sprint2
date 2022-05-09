package org.intelehealth.app.activities.doctorListActivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.intelehealth.app.R;
import org.intelehealth.app.activities.healthWorkerListActivity.NurseAdapter;
import org.intelehealth.app.auth.BasicAuthClient;
import org.intelehealth.app.auth.DemoRemoteService;
import org.intelehealth.app.models.data.EncounterProviders;
import org.intelehealth.app.models.data.Encounters;
import org.intelehealth.app.models.data.Results;
import org.intelehealth.app.models.data.VisitData;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorActivity extends AppCompatActivity {
    public Context context=this;
    public ArrayList<String> doctorNames=new ArrayList<String>();
    public ArrayList<String> role = new ArrayList<String>();
    public ArrayList<String> date = new ArrayList<String>();
    public ArrayList<String> cases = new ArrayList<String>();
    public ArrayList<String> sdate = new ArrayList<String>();
    public ArrayList<String> ldate = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        doctorloadprofile();
    }

    private void doctorloadprofile() {
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
                                    if (results.get(i).encounters.get(j).encounterProviders.get(k).encounterRole.display.contains("Doctor")==true) {
                                        if (results.get(i).encounters.get(j).encounterProviders.get(k).provider.display.contains("nurse")!=true) {
                                            Log.d("role", results.get(i).encounters.get(j).encounterProviders.get(k).encounterRole.display);
                                            Log.d("doctorname", results.get(i).encounters.get(j).encounterProviders.get(k).provider.display);
                                            doctorNames.add(results.get(i).encounters.get(j).encounterProviders.get(k).provider.display);
                                            role.add(results.get(i).encounters.get(j).encounterProviders.get(k).encounterRole.display);
                                            cases.add(String.valueOf((results.get(i).encounters.get(j).encounterProviders.get(k).provider.display).length()));
                                            if (results.get(i).encounters.get(j).encounterTypes.display.contains("Visit Note")==true);
                                            {
                                                Log.d("end date", results.get(i).encounters.get(j).encounterDatetime);
                                                sdate.add(results.get(i).encounters.get(j).encounterDatetime);
                                            }
                                            if (results.get(i).encounters.get(j).encounterTypes.display.contains("Visit Complete")==true);
                                            {
                                                Log.d("end date", results.get(i).encounters.get(j).encounterDatetime);
                                                ldate.add(results.get(i).encounters.get(j).encounterDatetime);
                                            }
//                                            date.add(results.get(i).encounters.get(j).encounterDatetime);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                // Adding adapter to recycler view
                RecyclerView rc_doctor = findViewById(R.id.MainrecyclerView);
                DoctorAdapter doctorAdapter = new DoctorAdapter(context,doctorNames,role,date,cases);
                rc_doctor.setAdapter(doctorAdapter);
                rc_doctor.setLayoutManager(new LinearLayoutManager(context));


                // Soring Doctor name and cases
                Map<String, Long> result = doctorNames.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                System.out.println(result);

                String sorteddata = result.toString().substring(1, result.toString().length() - 1);
                System.out.println(sorteddata);
                String[] sorted=sorteddata.split(",");

                doctorNames.clear();
                cases.clear();
                int k =sorted.length;
                for (int i=0;i<k;i++){
                    String[] name=sorted[i].split("=");
                    doctorNames.add(name[0]);
                    cases.add(name[1]);
                }

                //TAT Logic code

                String Sleftcarlyremove = sdate.toString().substring(1, sdate.toString().length() - 1);
                String[] ssdate=Sleftcarlyremove.split(",");
                String Lleftcarlyremove = ldate.toString().substring(1, ldate.toString().length() - 1);
                String[] lldate=Lleftcarlyremove.split(",");

                int n =ssdate.length;
                for (int i=0;i<n;i++) {
                    for (int j=0;j<n;j++) {
                        Log.d("ssdate", ssdate[i]);
                        Log.d("lldate",lldate[i]);
                        String[] sh = ssdate[i].split("T");
                        String[] stime = sh[1].split(":");
                        String[] lh = lldate[j].split("T");
                        String[] ltime = lh[1].split(":");

                        String starttime = (stime[0] + ":" + stime[1]);
                        String lastttime = (ltime[0] + ":" + ltime[1]);

                        Log.d("stime", stime[0] + ":" + stime[1]);
                        Log.d("ltime", ltime[0] + ":" + ltime[1]);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                        try {
                            Date startTime = simpleDateFormat.parse(starttime);
                            Date lastTime = simpleDateFormat.parse(lastttime);

                            Long difference = lastTime.getTime() - startTime.getTime();
                            if (difference < 0) {
                                Date dateMax = simpleDateFormat.parse("24:00");
                                Date dateMin = simpleDateFormat.parse("00:00");
                                difference = dateMax.getTime() - startTime.getTime() + (lastTime.getTime() - dateMin.getTime());
                            }
                            Integer days = Math.toIntExact((difference / (1000 * 60 * 60 * 24)));
                            Integer hours = Math.toIntExact(((difference - 1000 * 60 * 60 * 24 * days) / (1000 * 60 * 60)));
                            Integer min = Math.toIntExact((difference - 1000 * 60 * 60 * 24 * days - 1000 * 60 * 60 * hours) / (1000 * 60));
                            Log.i("log_tag", "Hours:" + hours + " Mins:" + min);
                            date.add(hours + ":" + min);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
            @Override
            public void onFailure(Call<VisitData> call, Throwable t) {
                Log.e("TAG", "response Error");

            }

        });
    }
}