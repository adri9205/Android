package com.example.a01034348_lab_webservice_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class ClimaServiceCall {
	public ClimaServiceCall(){
	super();
		}
	public JSONObject getJSONFromUrl(String url) throws SocketException{
		JSONObject jsonObject=null;
		HttpURLConnection urlConnection=null;
		try{
			URL myUrl= new URL(url);
			urlConnection = (HttpURLConnection)myUrl.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			int reponseCode=urlConnection.getResponseCode();
			if (reponseCode ==HttpStatus.SC_OK){
				String responseString= readStream(urlConnection.getInputStream());
				jsonObject=new JSONObject(responseString);
			}
			
		} catch(SocketTimeoutException e){
			e.printStackTrace();
			Log.v("SocketTimeoutException",e.toString());
		} catch(IOException e){
			e.printStackTrace();
			Log.v("IOException", e.toString());
		}catch (JSONException e){
			e.printStackTrace();
			Log.v("JSONException", e.toString());
		}
		
		return jsonObject;
	}

	private String readStream(InputStream in) {
		BufferedReader reader	=	null;	
		StringBuffer	response	=	null; 			
		try	{	
			 		reader	=	new	BufferedReader(new	InputStreamReader(in,	"UTF-8"));	
			 		String	line	=	"";	
			 		response	=	new	StringBuffer();	
			 	 while	((line	=	reader.readLine())	!=	null)	{	
			 							response.append(line);	
			 			}	
			 		}	catch	(IOException	e)	{	
			 					e.printStackTrace();	
			 		}	finally	{	
			 					if	(reader	!=	null)	{	
			 							try	{	
			 									reader.close();	
			 							}	catch	(IOException	e)	{	
			 									e.printStackTrace();	
			 							}	
			 					}	
			 			}	
			 			return	response.toString();	
			 	}
	
	}

