package com.biz.grade;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GradeExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nameFile = "src/com/biz/grade/영어이름들.txt";
		
		FileReader fr;
		
		try {
			fr = new FileReader(nameFile);
			
			while(true) { // => int intRead = fr.read();를 while문 안으로 넣어줘야 반복해서 전체를 볼 수 있다.
				// 파일 내용을 읽되
				int intRead = fr.read(); // => fr파일로부터 read를 하면 글자들을 한개씩 쪼개서 int형으로 리턴한다.
				
				// EOF(End Of File) 신호가 오면 그만읽기
				if(intRead < 0) break;
				
				
				System.out.print((char)intRead); //문자열로 보기 위해 char형으로 형변환 한다.
			}
			
			// 기본값: 파일의 내용을 ASCII코드 형식으로
			// 			읽어서 그 값을 10진수 정수로 return
		
		} catch (FileNotFoundException e) {
			// 파일을 읽기 위해 open하는 과정에서 발생하는
			// Exception을 처리하는 부분
			
			// java에서 기본으로 제공하는 Exception 메시지를
			// 콘솔에 보여주는 메서드
			e.printStackTrace();
			
		} catch (IOException e) {
			
			// 파일로부터 데이터(문자, 문자열)을 읽는중에
			// 발생하는 Exception을 처리하는 부분
			e.printStackTrace();
		}
		
	 

	}

}
