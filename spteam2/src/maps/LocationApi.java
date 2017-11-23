package maps;

import java.io.IOException;

import org.json.JSONObject;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class LocationApi {
		//Google maps api key: AIzaSyClkJQFwTyGagntiurWzrvnMH_jJaPDprU
	//google maps api key places: AIzaSyD0dyOfjW-atWqNpmegYij04vb3sG7SMmo
		private static final String KEY = "AIzaSyClkJQFwTyGagntiurWzrvnMH_jJaPDprU";
		
		public static JSONObject getJsonAddress(String address) {
			JSONObject body = new JSONObject(formulateRequest(address));
			if(body.getString("status").equals("OK")) {
				return body;
			}
			return null;
		}
		
		private static String formulateRequest(String address) {
			HttpUrl url = new HttpUrl.Builder()
					.scheme("https")
					.host("maps.googleapis.com")
					.addPathSegment("maps")
					.addPathSegment("api")
					.addPathSegment("geocode")
					.addPathSegment("json")
					.addQueryParameter("address", address)
					.addQueryParameter("key", KEY)
					.build();
			String body = urlGetRequest(url.toString());
			return body;
		}
		
		private static String urlGetRequest(String url){	
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder()
		      .url(url)
		      .build();
			Response response;
			try {
				response = client.newCall(request).execute();
				return response.body().string();
			} catch (IOException e) {
				return null;
			} catch (NullPointerException e) {
				return null;
			}
		}
}
