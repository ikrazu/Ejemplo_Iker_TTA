package tta.es.adibide3_1;

import android.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by irazu on 8/01/16.
 */
public class RestClient {
    private final static String AUTH = "Authorization";
    private final String baseUrl;
    private final Map<String, String> properties = new HashMap<>();

    public RestClient (String baseUrl){
        this.baseUrl = baseUrl;
    }

    public void serHttpBasicAuth (String user, String passwd){

        String basicAuth = Base64.encodeToString(String.format("%s:%s", user, passwd).getBytes(), Base64.DEFAULT);
        properties.put(AUTH, String.format("Basic %s", basicAuth));
    }
    public String getAuthorization(){
        return properties.get(AUTH);
    }
    public void setAuthorizatio(String auth){
        properties.put(AUTH, auth);
    }
    public void setProperty (String name, String value){
        properties.put(name,value);
    }

    private HttpURLConnection getConnection ( String path) throws IOException {

        URL url = new URL(String.format("%s/%s",baseUrl,path));
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        for(Map.Entry<String,String> property : properties.entrySet())
            httpURLConnection.setRequestProperty(property.getKey(), property.getValue());
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    private String getString(String path) throws IOException{
        HttpURLConnection httpURLConnection = null;
        try{
            httpURLConnection = getConnection(path);
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                return bufferedReader.readLine();
            }
        }finally {
            if( httpURLConnection != null)
                httpURLConnection.disconnect();
        }

    }

    public JSONObject getJson ( String path) throws IOException, JSONException {
        return new JSONObject(getString(path));
    }
    public int postFile(String path, InputStream inputStream, String fileName) throws IOException{
        String boundary = Long.toString(System.currentTimeMillis());
        String newLine = "\r\n";
        String prefix = "--";
        HttpURLConnection httpURLConnection = null;
        try{
            httpURLConnection= getConnection(path);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(prefix + boundary + newLine);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + fileName + "\"" + newLine);
            dataOutputStream.writeBytes(newLine);
            byte[] data = new byte[1024*1024];
            int len;
            while ((len = inputStream.read(data)) > 0)
                dataOutputStream.write(data, 0, len);
            dataOutputStream.writeBytes(newLine);
            dataOutputStream.writeBytes(prefix + boundary + prefix + newLine);
            dataOutputStream.close();
            return httpURLConnection.getResponseCode();
        }finally {
            if( httpURLConnection !=null)
                httpURLConnection.disconnect();
        }
    }

    public int postJson ( final JSONObject json, String path) throws IOException{
        HttpURLConnection httpURLConnection = null;
        try{
            httpURLConnection = getConnection(path);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.print(json.toString());
            printWriter.close();
            return httpURLConnection.getResponseCode();
        }finally {
            if( httpURLConnection != null)
                httpURLConnection.disconnect();
        }
    }
}
