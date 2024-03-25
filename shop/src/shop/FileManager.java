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
	
	public void saveItemFile() {
		String data = createItemData();

		try {
			fileWriter = new FileWriter(itemFile);
			fileWriter.write(data);
			fileWriter.close();

			System.out.println("아이템 파일저장 성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("아이템 파일저장 실패");
		}
	}
	
	private String createItemData() {
		String data = "";
		
		// <아이템> 아이템명/갯수/가격
		// <유저> 이름/아이디/패스워드
		//		 구매내역/갯수
		
		return data;
	}
	
	public void loadItemFile() {
		if (itemFile.exists()) {
			String data = "";

			try {
				fileReader = new FileReader(itemFile);
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
