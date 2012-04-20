/*
 * Configuration.java
 *
 * Created on 21 de Dezembro de 2006, 17:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package persistence.grow.ic.ufal.br.gkmt.persistence.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 
 * @author Ig
 * @author <a href="mailto:marlos.tacio@gmail.com">Marlos Tacio Silva</a>
 */
public final class Configuration {

	// Static ------------------------------------------------------------------

	private static Logger logger;

	static {
		logger = Logger.getLogger(Configuration.class.getName());
	}

	private static Configuration instance;

	private static String file_name;

	private static String source;
	
	// Constants ---------------------------------------------------------------

	private static final String USER_PATH = "user.home";

	// Attributes --------------------------------------------------------------

	private Properties prop;

	private String path;


	// Constructors ------------------------------------------------------------

	/**
	 * Creates a new this.persistenceOWLLog.getConfiguration() instance of
	 * Configuration
	 */
	private Configuration(final String file_name) {
		Configuration.file_name = file_name;

		if (Configuration.source != null) {

			try {
				StringBuilder path = new StringBuilder();
				path.append(new File("").getAbsolutePath());
				path.append(System.getProperty("file.separator"));
				path.append(Configuration.source);
				path.append(System.getProperty("file.separator"));
				path.append(Configuration.file_name + ".properties");

				this.path = path.toString();

				if (new File(path.toString()).exists()) {
					this.prop = new Properties();
					this.prop.load(new FileInputStream(path.toString()));
					logger.info("Loading configurations of " + path.toString());
					return;
				}

			} catch (FileNotFoundException e) {
				throw new IllegalArgumentException("Classpath not found");

			} catch (IOException e) {
				throw new IllegalArgumentException("Troubles trying to open the file.");
			}
		}

		try {
			StringBuilder path = new StringBuilder();
			path.append(System.getProperty(USER_PATH));
			path.append(System.getProperty("file.separator") + "emathema");
			path.append(System.getProperty("file.separator") + file_name
					+ ".properties");

			this.path = path.toString();

			this.prop = new Properties();
			this.prop.load(new FileInputStream(path.toString()));

			logger.info("Loading configurations of " + path.toString());

		} catch (FileNotFoundException ex) {
			throw new IllegalArgumentException("Configuration file not found.");

		} catch (IOException ex) {
			throw new IllegalArgumentException("Troubles trying to open the file.");
		}
	}

	// Public ------------------------------------------------------------------

	/**
	 * 
	 * @return
	 */
	public synchronized static Configuration getInstance(final String file_name) {
		if (Configuration.file_name == null	|| !Configuration.file_name.equals(file_name))
			Configuration.instance = new Configuration(file_name);

		return Configuration.instance;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(final String key) {
		if (!this.prop.containsKey(key))
			throw new IllegalArgumentException("Key" + key + " not found");

		return this.prop.getProperty(key);
	}

	/**
	 * 
	 * @return
	 */
	public Collection<Object> getKeys() {
		return this.prop.keySet();
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, String value) {
		this.prop.put(key, value);

		try {
			this.prop.store(new FileOutputStream(this.path), "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public static final void setSource(final String source) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(".classpath"));

			while (scanner.hasNext()) {

				String src = "";
				if ((src = scanner.nextLine()).contains("kind=\"src\"")) {

					if (source.equals(src.split("path=\"")[1].split("\"")[0])) {
						Configuration.source = source;
						return;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		throw new IllegalStateException("Source not found!!!");
	}
}