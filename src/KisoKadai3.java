import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
System.out.println("メニューを選び番号を入力してください");
System.out.println("1フォルダ作成");
System.out.println("２ファイル作成");
System.out.println("３上書き");
System.out.println("４追記");
System.out.println("５ファイルの参照");
System.out.println("６終了");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			String a =br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}










		int i=5;
		switch(i){
			case 1://フォルダ作成
				File newdir = new File("c:\\tmp\\sub");
				if(newdir.mkdir()){
					System.out.println("ディレクトリの作成に成功しました。");
				}else{
					System.out.println("ディレクトリが作成できませんでした。");
				}
				break;
			case 2://ファイル作成
				File newfile = new File("c:\\tmp\\newfile.txt");
			try {
				newfile.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
				break;
			case 3://上書き
			try {
				File file = new File("c:/temp/test.txt");
				if(checkBeforeWritefile(file)){
					FileWriter filewriter=new FileWriter(file);

				filewriter.write("aaaaaaaaaaa");

				filewriter.close();
				}else{
					System.out.println("上書きができません");
				}
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
				break;
			case 4://追記
				try {
					File file = new File("c:/temp/test.txt");
					if(checkBeforeWritefile(file)){
					FileWriter filewriter = new FileWriter(file,true);
					filewriter.write("\r\naaaaaaaaaaa");

					filewriter.close();
					}else{
						System.out.println("追記ができません");
					}
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
					break;
			case 5://見る
				try {
				File file=new File("c:/temp/test.txt");
				if(checkBeforeReadefile(file)){
				FileReader fr=new FileReader(file);
			    int ch= 0;
				try {
					ch = fr.read();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			    while(ch !=-1){
			    	System.out.print((char)ch);
			    	try {
						ch=fr.read();
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
			    }

				}

			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
				break;
			case 6:
				break;



		}
}

	private static boolean checkBeforeReadefile(File file) {
			if(file.exists()){
				if(file.isFile() && file.canRead()){
					return true;
				}
			}
		return false;
	}

	private static boolean checkBeforeWritefile(File file){
			if(file.exists()){
				if (file.isFile() && file.canWrite()){
					return true;
				}
				}
		return false;
		}
}

