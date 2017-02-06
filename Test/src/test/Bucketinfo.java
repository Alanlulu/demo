package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bucketinfo {
	public static String getFileContent(File file) {
		StringBuffer sb = new StringBuffer();
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			try {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					sb.append(lineTxt);
					sb.append("\n");
				}
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		File file = new File("D:\\bucket_info.txt");
		String content = getFileContent(file);
		Pattern pattern = Pattern.compile("num_objects.*?\\s+(\\d*)");
		Matcher match = pattern.matcher(content);
		while(match.find()) {
			System.out.println(match.group(1));
		}
	}

}
