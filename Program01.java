package com;

import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Program01 {
	public static void main(String[] args) {
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				.uri(URI.create("https://jsonplaceholder.typicode.com/photos"))
				.GET()
				.build();
		try {
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				System.out.println(response.body());
				var a = response.body();
				var file = new File("D:\\jsonPhoto.json");
				file.createNewFile();
				var reader = new FileWriter(file);
				reader.write(a);
				reader.close();
			} else {
				System.out.println(response.statusCode());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}