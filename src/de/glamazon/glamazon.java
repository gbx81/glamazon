package de.glamazon;

import de.glamazon.pojo.Configuration;

public class glamazon {

	public static void main(String[] args) {
		Configuration config = Configuration.getInstance();
		System.out.println(config);
		config.setLanguage("DE");
		System.out.println(config);
	}
}
