package de.glamazon.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.glamazon.util.DatabaseManager;

class DbmanagerTest {
	
	private static DatabaseManager dbm;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dbm = DatabaseManager.getInstance();
		assertNotNull(dbm);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			dbm.closeConnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		assertNull(dbm.getConnection());
	}

	@BeforeEach
	void setUp() throws Exception {
		assertNotNull(dbm.getConnection());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void checkInstance() {
		
	}

}
