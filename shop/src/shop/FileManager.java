package shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	private File itemFile;
	private File userFile;
	private String itemFileName;
	private String userFileName;

	public FileManager() {
		this.itemFileName = "item.txt";
		this.itemFile = new File(itemFileName);
		this.userFileName = "user.txt";
		this.userFile = new File(userFileName);
	}

	public FileWriter getFileWriter() {
		return fileWriter;
	}

	public FileReader getFileReader() {
		return this.fileReader;
	}

	public BufferedReader getBufferedReader() {
		return this.bufferedReader;
	}

	public File getItemFile() {
		return this.itemFile;
	}

	public void setItemFile(File itemFile) {
		this.itemFile = itemFile;
	}

	public File getUserFile() {
		return this.userFile;
	}

	public void setUserFile(File userFile) {
		this.userFile = userFile;
	}

	public String getItemFileName() {
		return this.itemFileName;
	}

	public String getUserFileName() {
		return this.userFileName;
	}

}
