package de.glamazon.pojo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public final class Configuration {
	private static Configuration instance = null;
	private String version;
	private String language;
	private String nuller = null; // for testing serializing nulls
	
	private Configuration() {
		super();
	}
	
	private static String getJson() throws IOException {
		byte[] jsonbyte = Files.readAllBytes(Paths.get("config.json"));
		String jsonfile = new String(jsonbyte);
		return jsonfile;
	}
	
	public static Configuration getInstance() {
		if(instance == null) {
			try {
				instance = new Gson().fromJson(getJson(), Configuration.class);
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		updateJson();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
		updateJson();
	}
	
	private void updateJson() {
		try {
//			Files.write(Paths.get("config.json"), new Gson().toJson(this).getBytes()); // compact
			Files.write(Paths.get("config.json"), 
					new GsonBuilder().setPrettyPrinting().serializeNulls().create().toJson(this).getBytes())
			; //pretty printing & serializing nulls
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		String gson = new String(new GsonBuilder().setPrettyPrinting().serializeNulls().create().toJson(this).getBytes());
		return gson;
	}

	public String getNuller() {
		return nuller;
	}

	public void setNuller(String nuller) {
		this.nuller = nuller;
	}
}
