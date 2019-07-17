package com.mindtree.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class GetLife {

	public static ObjectMapper mapper = new ObjectMapper();





	public static void main(String args[]) throws IOException, InterruptedException {
		//						saveLife("7qodv3"); // Pankaj MiA1
		//		saveLife("c78t85");
		//		saveLife("si5554");
		//				saveLife("5uznu9"); // Pankaj Yu
		//		saveLife("49y1fj"); // Anoop
		transferToPaytm(10000);
	}





	public static void getLife(String code) throws IOException, InterruptedException {
		/**
		 *
		 *
		 * NOT WORKING
		 *
		 *
		 *
		 */

		int count = 1;
		while (count < 1000) {
			Client client = Client.create();
			String input = "{\"inviteUserId\":\"" + UUID.randomUUID().toString().replace("-", "").substring(0, 5)
					+ "\",\"source\":1,\"inviteCode\":\"" + code + "\"}";
			String releaseUri = "http://weshow-1461899548.ap-south-1.elb.amazonaws.com/invite/inviteNo";
			WebResource webResource = client.resource(releaseUri);
			ClientResponse response = webResource.header("x-requested-with", "com.lenovo.anyshare.gps")
					.header("accept", "application/json, text/plain, */*").header("accept-encoding", "gzip, deflate")
					.header("accept-language", "en-US").header("content-type", "application/json;charset=UTF-8")
					.header("host", "weshow-1461899548.ap-south-1.elb.amazonaws.com")
					.header("origin", "http://cdn.weshow.me")
					.header("referer", "http://cdn.weshow.me/w/weshow/hq/index.html?source=32")
					.header("user-agent", "Mozilla/5.0 (Linux; Android 7.1.2; AO5510 Build/NJH47B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/59.0.3071.92 Mobile Safari/537.36")
					.header("x-requested-with", "com.lenovo.anyshare.gps").type("application/json")
					.post(ClientResponse.class);
			System.out.println("API count: " + count++);
			Thread.sleep(10000);
		}
		System.out.println("API stopped");
	}





	public static void saveLife(String code) throws IOException, InterruptedException {
		OkHttpClient client = new OkHttpClient();
		int count = 1;
		while (count <= 50) {
			String requestBody = "{\"inviteUserId\":\"" + "F"
					+ UUID.randomUUID().toString().replace("-", "").substring(0, 3) + "3"
					+ "\",\"source\":1,\"inviteCode\":\"" + code + "\"}";
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, requestBody);
			System.out.println(requestBody);
			Request request = new Request.Builder()
					.url("http://weshow-1461899548.ap-south-1.elb.amazonaws.com/invite/inviteNo").post(body)
					.addHeader("accept", "application/json, text/plain, */*")
					.addHeader("accept-encoding", "gzip, deflate").addHeader("accept-language", "en-US")
					.addHeader("content-length", "57").addHeader("content-type", "application/json")
					.addHeader("host", "weshow-1461899548.ap-south-1.elb.amazonaws.com")
					.addHeader("origin", "http://cdn.weshow.me").addHeader("proxy-connection", "keep-alive")
					.addHeader("referer", "http://cdn.weshow.me/w/weshow/hq/index.html?source=32")
					.addHeader("user-agent", "Mozilla/5.0 (Linux; Android 7.1.2; AO5510 Build/NJH47B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/59.0.3071.92 Mobile Safari/537.36")
					.addHeader("x-requested-with", "com.lenovo.anyshare.gps").addHeader("Cache-Control", "no-cache")
					.build();

			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
			System.out.println("API count: " + count++);
			//			Thread.sleep(1000);
		}
		System.out.println("API stopped");
	}





	public static void transferToPaytm(int amount) throws IOException, InterruptedException {
		OkHttpClient client = new OkHttpClient();
		int count = 1;
		Map<Integer, Integer> statusCodes = new HashMap<>();
		while (count <= 1) {
			//			String requestBody = "{\"userId\":\"" + UUID.randomUUID().toString().replace("-", "").substring(0, 5)
			//					+ "\",\"source\":1,\"advanceValue\":" + amount + ",\"paytmNo\":\"8981484358\"}";
			String requestBody = "{\"userId\":\"5UZNU9\",\"source\":1,\"advanceValue\":" + 71
					+ ",\"paytmNo\":\"8981484358\"}";
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, requestBody);
			System.out.println(requestBody);
			Request request = new Request.Builder()
					.url("http://weshow-1461899548.ap-south-1.elb.amazonaws.com/account/advanceDetail").post(body)
					.addHeader("accept", "application/json, text/plain, */*")
					.addHeader("accept-encoding", "gzip, deflate").addHeader("accept-language", "en-US")
					.addHeader("content-length", "57").addHeader("content-type", "application/json")
					.addHeader("host", "weshow-1461899548.ap-south-1.elb.amazonaws.com")
					.addHeader("origin", "http://cdn.weshow.me").addHeader("proxy-connection", "keep-alive")
					.addHeader("referer", "http://cdn.weshow.me/w/weshow/hq/index.html?source=32")
					.addHeader("user-agent", "Mozilla/5.0 (Linux; Android 7.1.2; AO5510 Build/NJH47B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/59.0.3071.92 Mobile Safari/537.36")
					.addHeader("x-requested-with", "com.lenovo.anyshare.gps").addHeader("Cache-Control", "no-cache")
					.build();

			Response response = client.newCall(request).execute();
			String responseData = response.body().string();
			System.out.println(responseData);
			int statusCode = mapper.readTree(responseData).get("code").asInt();
			if (statusCodes.get(statusCode) == null) {
				statusCodes.put(statusCode, 1);
			} else {
				statusCodes.put(statusCode, statusCodes.get(statusCode) + 1);
			}
			System.out.println("API count: " + count++);
			//			Thread.sleep(1000);
		}
		System.out.println("API stopped");
		System.out.println(statusCodes);
	}
}
