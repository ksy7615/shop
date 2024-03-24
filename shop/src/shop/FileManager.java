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

	private File file;
	private String fileName;
	
	public FileManager() {
		this.fileName = "shop.txt";
		this.file = new File(fileName);
	}
	
	public void saveFile() {
		String data = "";

		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(data);
			fileWriter.close();

			System.out.println("파일저장 성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("파일저장 실패");
		}
	}
	
	public void loadFile() {
		if (file.exists()) {
			String data = "";

			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);

				while (bufferedReader.ready()) {
					data += bufferedReader.readLine() + "\n";
				}

				bufferedReader.close();
				fileReader.close();

				System.out.println("파일로드 성공");
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("파일로드 실패");
			}
		}
	}
	
}
