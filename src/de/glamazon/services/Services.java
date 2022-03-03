package de.glamazon.services;

import de.glamazon.util.DatabaseManager;

public abstract class Services {
	protected DatabaseManager dbm;
	
	public Services() {
		dbm = DatabaseManager.getInstance();
	}
}
