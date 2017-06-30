package com.example.guilhermes.mobprof;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by guilherme.s on 26/06/2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String>{

    AlertDialog alertDialog;
    Context ctx;
    Activity activity;
    AlertDialog.Builder builder;

    BackgroundTask(Context ctx)
    {

        this.ctx = ctx;
        activity = (Activity) ctx;
    }


    @Override
    protected void onPreExecute(){
        builder = new AlertDialog.Builder(activity);
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Informações do Login....");
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://10.8.77.47:8080/phpmyadmin/registro-tipo.php";
        String login_url = "http://10.8.77.47:8080/phpmyadmin/login.php";
        String method = params[0];

        if(method.equals("Registro")){
            String CDTIPO  = params[1];
            String DSTIPO  = params[2];

            try{
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("CDTIPO", "UTF-8") + "=" + URLEncoder.encode(CDTIPO, "UTF-8") + "&" +
                              URLEncoder.encode("DSTIPO", "UTF-8") + "=" + URLEncoder.encode(DSTIPO, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Registrado com Sucesso...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("Login"))
        {
            String MATRICULA = params[1];
            String SENHA = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("MATRICULA", "UTF-8") + "=" + URLEncoder.encode(MATRICULA, "UTF-8") + "&" +
                              URLEncoder.encode("SENHA","UTF-8")+"="+URLEncoder.encode(SENHA,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("Login"))
        {
            String MATRICULA = params[1];
            String SENHA = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("MATRICULA", "UTF-8") + "=" + URLEncoder.encode(MATRICULA, "UTF-8") + "&" +
                        URLEncoder.encode("SENHA","UTF-8")+"="+URLEncoder.encode(SENHA,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    @Override
    protected void onPostExecute(String result) {

        if(result.equals(null)){

        }

        if(result.equals("Registrado com Sucesso..."))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
            //Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(activity,MainActivity.class);
            //activity.startActivity(intent);

        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

