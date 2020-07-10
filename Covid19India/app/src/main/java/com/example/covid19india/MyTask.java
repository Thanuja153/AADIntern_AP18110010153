package com.example.covid19india;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MyTask extends AsyncTask<Void,Void,String > {
String str="https://api.covid19api.com/dayone/country/IN";
Context contxt;
RecyclerView RV;
ProgressDialog pd;
    public MyTask(MainActivity mainActivity, RecyclerView rv) {
        contxt=mainActivity;
        RV=rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(contxt);
        pd.setMessage("Loading.....");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url=new URL(str);
            HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
            InputStream is=con.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            String s="";
            StringBuilder sb=new StringBuilder();
            while ((s=reader.readLine())!=null)
            {
                sb.append(s);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        List<CovidData> cd=new ArrayList<>();
        try {
            JSONArray arr=new JSONArray(s);
            for(int i=arr.length()-1;i>=0;i--)
            {
                JSONObject obj=arr.getJSONObject(i);
                String date=obj.getString("Date").substring(0,10);
                String active=obj.getString("Active");
                String recovered=obj.getString("Recovered");
                String deaths=obj.getString("Deaths");
                CovidData cvd=new CovidData(date,active,recovered,deaths);
                cd.add(cvd);
            }
            RV.setLayoutManager(new LinearLayoutManager(contxt));
            RV.setAdapter(new adapt(contxt,cd));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
