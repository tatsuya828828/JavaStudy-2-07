import java.util.Iterator;
import java.util.Properties;

public class Main {
	public static void main(String[] args) {
		System.out.println("ご利用のJavaバージョン:");
		// JVMは内部にMap<String, String>を持っていて、動作に関する様々な情報を格納、利用している
		// このJVMが持つ文字列ペアの集合をシステムプロパティという
		// システムプロパティには、JVM生成時に様々な値が自動的に設定される
		// システムプロパティから、あるペアの情報を取得したい場合にはgetPropertyメソッドにキーを指定する
		// またgetPropertiesメソッドを使うことによって得られるPropertiesインスタンスのメソッドを使えば、
		// ペアの値を取り出したりセットしたりできる
		// java.versionキーは実行中のJREのバージョンを値として紐づけている
		System.out.println(System.getProperty("java.version"));
		Properties p = System.getProperties();
		Iterator<String> i = p.stringPropertyNames().iterator();
		System.out.println("[システムプロパティ一覧]");
		while(i.hasNext()) {
			String key = i.next();
			System.out.println(key + " = ");
			System.out.println(System.getProperty(key));
		}

		// Javaは基本的にはどのようなOSでも同様に動作するが100%ではない
		// 例えば下のプログラムは動かすOSによっては、エスケープシーケンスが改行と意味しない場合がある
		System.out.println("本日は\n晴天なり");
		// line.separatorシステムプロパティを利用すると現在動作中のOSが採用している改行コードが自動的に格納されることになっている
		// よって、どのOSでも正しく改行される
		final String BR = System.getProperty("line.separator");
		System.out.println("本日は"+ BR +"晴天なり");

		// setPropertyを使えば文字列であればシステムプロパティに設定することもできる
		System.setProperty("rpg.version", "0.3");
		System.setProperty("rpg.author", "ミナト");
		String ver = System.getProperty("rpg.version");
		String author = System.getProperty("rpg.author");
		System.out.println("RPG: スッキリ魔王征伐 ver"+ ver);
		System.out.println("Developed by "+ author);

		// システムプロパティは、どのようなクラスからも直接読み書きできる便利な格納領域だが
		// 不具合の原因にもなりやすいため濫用は禁物
	}
}
