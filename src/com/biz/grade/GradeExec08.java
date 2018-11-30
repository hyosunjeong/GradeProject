package com.biz.grade;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class GradeExec08 {
	/*
	 * 영어 이름들.txt 파일을 읽어서
	 * 각 라인을 : 을 기준으로 자른 후
	 * sVO리스트에 추가하시오
	 * 1:Korea:대한민국
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nameFile = "src/com/biz/grade/영어이름들.txt";
		
		String scoreFile = "src/com/biz/grade/성적표.txt";
	
		List<StudentVO> stList = new ArrayList();
		List<ScoreVO> scoreList = new ArrayList();
		
		
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
					
					stList.add(stVO);
					
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
		
		for(StudentVO sv : stList) {
			
			ScoreVO scv = new ScoreVO();
			scv.setStrNum(sv.getStrNum());
			
			int intKor = (int)(Math.random() * (100-50+1))+50;
			int intEng = (int)(Math.random() * (100-50+1))+50;
			int intMath = (int)(Math.random() * (100-50+1))+50;
			
			scv.setIntKor(intKor);
			scv.setIntEng(intEng);
			scv.setIntMath(intMath);
			
			int intSum = intKor + intEng + intMath;
			float floatAvg = (float) intSum / 3;
			
			scv.setIntSum(intSum);
			scv.setFloatAvg(floatAvg);
			
			scoreList.add(scv);
			
		}
	
		PrintWriter pr;
		
				
		try {
			pr = new PrintWriter(scoreFile);
			
			for(StudentVO vo : stList) {
				pr.print(vo.getStrNum() + ":");
				pr.print(vo.getStrEngName() + ":");
				pr.print(vo.getStrKorName() + ":");
				
				for(ScoreVO sc : scoreList) {
					
					if(vo.getStrNum().equals(sc.getStrNum())) {
						pr.print(sc.getIntKor() + ":" );
						pr.print(sc.getIntEng() + ":");
						pr.print(sc.getIntMath() + ":");
						pr.print(sc.getIntSum() + ":");
						pr.printf("%2.3f",sc.getFloatAvg());
					}
				}
				pr.println();
			}
			pr.close();
			System.out.println("성적처리완료");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		// stList : 학생정보
		// scoreList : 성적정보
		
		
		


