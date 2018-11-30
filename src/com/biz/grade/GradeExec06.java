package com.biz.grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.vo.StudentVO;

public class GradeExec06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nameFile = "src/com/biz/grade/영어이름들.txt";
		
		/*
		 * 영어 이름들.txt 파일을 읽어서
		 * 각 라인을 : 을 기준으로 자른 후
		 * sVO리스트에 추가하시오
		 * 1:Korea:대한민국
		 */
		List<StudentVO> sVO = new ArrayList();
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(nameFile);
			buffer = new BufferedReader(fr);
			
			while(true) {
				String strName = buffer.readLine();
				if(strName==null) break;
			
				String[] strName1 = strName.split(":");
				
				if(strName1.length >2) { 
					
					StudentVO stVO = new StudentVO();
					stVO.setStrNum(strName1[0]);
					stVO.setStrEngName(strName1[1]);
					stVO.setStrKorName(strName1[2]);
					
					sVO.add(stVO);
					
				}
			}
			buffer.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(StudentVO vo : sVO) {
			System.out.println(vo);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
