import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.ConstantCallSite;
import java.util.*;

public class GradeProcessor {
	private String score;
	private String setting;
	private String result;
	private File scoreFile;
	private File settingFile;
	private File resultFile;
	
	private ArrayList mainSubjectsList;
	private HashMap mainSubjectsScore;
	
	private ArrayList otherSubjectsList;
	private HashMap otherSubjectsFlags;
	private HashMap otherSubjectsScore;
	
	final private int StudentN = 10;
	final private int SubjectN = 6;
	
	
	public GradeProcessor( String score, String setting, String result ) {
		
		// ファイル名を受け取る
		this.score = score;
		this.setting = setting;
		this.result = result;
		scoreFile = new File(score);
		settingFile = new File(setting);
		resultFile = new File(result);
		//
		
		// 変数初期化
		mainSubjectsList = new ArrayList();
		mainSubjectsScore = new HashMap();
		otherSubjectsList = new ArrayList();
		otherSubjectsFlags = new HashMap();
		otherSubjectsScore = new HashMap();
		//
		
		
	}
	
	public void process() {
		// 仕様に従って処理を実行し，ファイルに結果を出力する
		
		// main科目 事前調査
		mainSubjectsDetector(scoreFile);
		
		// other科目 事前調査
		otherSubjectsList.add("sum");
		otherSubjectsList.add("average");
		otherSubjectsList.add("fuka");
		otherSubjectsDetector(settingFile);
		//
		
		try {

			FileReader scoreFileReader = new FileReader(scoreFile);
			BufferedReader scoreBufferedReader  = new BufferedReader(scoreFileReader);
			FileWriter resultFileWriter = new FileWriter(resultFile);
			BufferedWriter resultBufferedWriter = new BufferedWriter(resultFileWriter);
			
			String subjecString = scoreBufferedReader.readLine();
			for( String otherSubject : otherSubjectsList ) {
				if( otherSubjectsFlags.get(otherSubject) ) {
					subjecString += "," + otherSubject.substring(0, 1).toUpperCase() + otherSubject.substring(1).toLowerCase();
				}
			}

			resultBufferedWriter.write(subjecString); resultBufferedWriter.newLine();
			
			String tmpString;
			while( (tmpString = scoreBufferedReader.readLine() ) != null ) {
				int sum = 0,ave,fuka = 0;
				String[] scoreStrings = tmpString.split(",");
				for( int i = 0; i < SubjectN; i++ ) {
					int score = Integer.parseInt(scoreStrings[i+1]);
					sum += score;
					if( score < 60 ) fuka++;
				}
				ave = sum/SubjectN;

				if( otherSubjectsFlags.get("sum") ) tmpString += "," + sum;
				if( otherSubjectsFlags.get("average") ) tmpString += "," + ave;
				if( otherSubjectsFlags.get("fuka") ) tmpString += "," + fuka;
				
				resultBufferedWriter.write(tmpString); resultBufferedWriter.newLine();
				
			}
			
			resultBufferedWriter.close();
			scoreBufferedReader.close();
			
			
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}
	
	private void mainSubjectsDetector( File scoreFile ) {
		// scoreファイルから科目を特定します
		String tmpString;
		try {
			FileReader scoreFileReader = new FileReader(scoreFile);
			BufferedReader scoreBufferedReader  = new BufferedReader(scoreFileReader);
			
			tmpString = scoreBufferedReader.readLine();
			String[] mainSubjects = tmpString.split(",");
			
			for( int si = 1; si < SubjectN; si++ ) {
				mainSubjectsList.add(mainSubjects[si]);
			}
			
			scoreFileReader.close();
			scoreBufferedReader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void otherSubjectsDetector( File settingFile ) {
		// iniファイルに含まれるsum,average,fukaを探します
		String tmpString;
		for (String string : otherSubjectsList) {
			otherSubjectsFlags.put(string, false);
		}
		try {
			FileReader settingFileReader = new FileReader(settingFile);
			BufferedReader settingBufferedReader = new BufferedReader(settingFileReader);
			while ( (tmpString = settingBufferedReader.readLine()) != null ) {
				String settingName = tmpString.split(" ")[0];
				String YesNo = tmpString.split(" ")[2];
				if( YesNo.contentEquals("yes") ) {
					otherSubjectsFlags.put(settingName, true);
				}
			}
			
			settingFileReader.close();
			settingBufferedReader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
