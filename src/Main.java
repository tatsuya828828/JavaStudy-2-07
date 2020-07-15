import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws Exception {
		// リフレクションAPIを使うとクラスやインタフェースに関する様々な情報(持っているフィールドやメソッド等)をJVMに調べさせることができる
		// Classインスタンスの基本的な取得方法
		// Stringに関する情報を取得して表示する
		Class<?> info1 = String.class;
		// getSimpleNameメソッドは、クラス部分のみを取得する
		System.out.println("クラス名:"+ info1.getSimpleName());
		// getNameメソッドは、FQCNを取得する
		System.out.println("FQCN:"+ info1.getName());
		// getPackageメソッドは、所属するパッケージ情報を取得する
		System.out.println("所属しているパッケージ:"+ info1.getPackage().getName());
		// isArrayは、配列であればtrueを返すメソッド
		System.out.println("配列:"+ info1.isArray());
		// getSuperclassは、親クラスの情報を取得する
		Class<?> info2 = info1.getSuperclass();
		System.out.println("親クラスの名前:"+ info2.getName());
		// argsは文字列配列として判定される
		Class<?> info3 = args.getClass();
		System.out.println("argsは文字配列である:"+ info3.isArray());


		// Classクラスは、その型が持つメンバに関する情報を返すメソッドも備えている
		// メンバに関する情報は、reflectパッケージに属するField、Method、Constructorの各クラスのインスタンスとして取得する
		Class<?> clazz = RefSample.class;
		// getConstructorメソッドは指定した引数の方を持つコンストラクタを取得する
		Constructor<?> cons = clazz.getConstructor(int.class);
		// 引数を渡し、インスタンスを生成する
		RefSample rs = (RefSample) cons.newInstance(256);
		// 指定した名前のフィールドを取得する
		// 一覧を取得したい場合はgetFields()を使う
		Field f = clazz.getField("times");
		// rsのtimesに代入して上書き
		f.set(rs, 2);
		// rsのtimesを取得
		System.out.println(f.get(rs));
		// 指定した名前と引数の型を持つメソッドを取得
		Method m = clazz.getMethod("hello", String.class, int.class);
		m.invoke(rs, "reflection!", 128);
		// クラスやメソッドへの修飾(publicやfinalの有無)を調べる
		boolean pubc = Modifier.isPublic(clazz.getModifiers());
		boolean finm = Modifier.isFinal(m.getModifiers());

		// MethodクラスやFieldクラスはsetAccessibleというメソッドを持っている
		// このメソッドを引数trueとともに呼び出すと、本来外部からは利用できないprivateなメンバを読み書きしたり、呼び出したりできるようになる
		// この仕組みを用いれば、テストや解析のために、privateメンバを操作するのに役に立つことがあるがみだりに利用すべきではない
		// また、クラスをnewして利用する必要があるが、そのクラスを使うかは実行時に決めたいといったような
		// 利用するクラスを動的に追加・変更できるようにしたい場合にもリフレクションは用いられる
	}
}
