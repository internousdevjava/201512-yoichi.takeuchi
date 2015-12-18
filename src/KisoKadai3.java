import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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
		while (true){
System.out.println("メニューを選び番号(半角)を入力してEnterを押してください");
System.out.println("1フォルダ作成　２ファイル作成　３上書き　４追記 ５ファイルの参照　６終了");


	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String a=null;
			try {
				a = br.readLine();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			int i=Integer.parseInt(a);


		switch(i){
			case 1://フォルダ作成
			System.out.println("C:/フォルダ名");
			System.out.println("上の例のように入力してください");
				try {
				a = br.readLine();//ふぉーむ
			}   catch (IOException e1) {
				e1.printStackTrace();
			}
				File newdir = new File(a);
				if(newdir.mkdir()){
					System.out.println("ディレクトリの作成に成功しました。");
				}else{
					System.out.println("ディレクトリが作成できませんでした。");
				}
		continue;
			case 2://ファイル作成
				System.out.println("C:/");
				try {
					a = br.readLine();//ふぉーむ
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				File newfile = new File(a);
			try {
				newfile.createNewFile();
				System.out.println("ファイルが作成できました。");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("ファイルが作成できませんでした。");
			}
		continue;
			case 3://上書き
				try {
					System.out.println("C:/フォルダ名/ファイル名.txt");
					System.out.println("上の例のように上書きするファイルを指定してください");
					a = br.readLine();
					File file = new File(a);//ファイルを指定
				    if(checkBeforeWritefile(file)){//チェック
					PrintWriter pw = new PrintWriter(
					new BufferedWriter(new FileWriter(file)));
					BufferedReader d=new BufferedReader(new InputStreamReader(System.in));
					String g=null;
					try {
						g = d.readLine();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					pw.println(g);//書き込場所
					pw.close();System.out.println("上書きが完了しました。");
					}else{System.out.println("書き込みできません");}
				 } catch (IOException e1){
						e1.printStackTrace();
					  }
			continue;
			case 4://追記
				try {
					System.out.println("例 C:/フォルダ名/ファイル名.txt");
					System.out.println("上の例のように追記するファイルを指定してください");
					a = br.readLine();
					File file = new File(a);
					if(checkBeforeWritefile(file)){
					FileWriter filewriter = new FileWriter(file,true);
					BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
					String aa=null;
					try {
						aa = br2.readLine();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					filewriter.write(aa);       //追記時はtrueを付け
					filewriter.close();//FR閉じ
					System.out.println("追記が完了しました。");
					}else{
					  System.out.println("追記ができません");
					}
				} catch (IOException e){
					e.printStackTrace();
				}
			continue;
			case 5://参照
				try {
				System.out.println("例 C:/フォルダ名/ファイル名.txt");
					System.out.println("上の例のように参照するファイルを指定してください");
					try {
						a = br.readLine();
					} catch (IOException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}
				File file=new File(a);
				if(checkBeforeReadefile(file)){
				FileReader fr=new FileReader(file);
			    int ch= 0;
				try {
					ch = fr.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			    while(ch !=-1){
			    	System.out.print((char)ch);
			    	try {
						ch=fr.read();
					} catch (IOException e) {
						e.printStackTrace();
					}
			    }

				}

			    }
				catch (FileNotFoundException e) {
					e.printStackTrace();
			       }
		  continue;
			case 6://終了
				//動作なし//case6はSWのけつなのでbreakeなしでも外に出る!!
             }break;//スイッチの外に出る
		}System.out.println("終了しました。");//一番外のwhileの中
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

