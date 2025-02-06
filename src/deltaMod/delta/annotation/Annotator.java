package gamma;

import java.io.*;
import java.util.*;
import java.lang.Exception;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
* 自作アノテーション実験
* @author う
* @version 1.01
*/
//@Infomation(version = "1.1", description = "HandMadeAnno")
@Infomation
public class Annotator implements Cloneable {

	@Autowired public String str;
	@Autowired public SampleFace face;
	public int num;

	/**
	* コンストラクタ
	*/
	public Annotator() {
		
	}

	/**
	* 何かアクションする
	* @param str 文字列
	* @return 文字列
	*/
	public void action() {
		try {
					System.out.println("\n--- 1 ---\n");
			
				System.out.println(Infomation.class);
			var cls = Class.forName("gamma.Annotator");
			var cls2 = Class.forName("gamma.JavadocTest");
				System.out.println(cls.getName());
			
			Infomation info = (Infomation)cls.getAnnotation(Infomation.class);
	
			var f = Field.class;
			var aw = f.getAnnotation(Autowired.class);
				System.out.println(f);
				System.out.println(aw);
				System.out.println(Autowired.class);
			
					System.out.println("\n--- 2 ---\n");

				System.out.println(this.getClass());
				System.out.println(this.getClass().getSimpleName());
				
			Class clsname = Class.forName(this.getClass().getName());
			
			var fls = clsname.getFields();
				System.out.println(Arrays.toString(fls));
			
			for(Field fi : fls) {
				if(fi.isAnnotationPresent(Autowired.class)) {
					
					System.out.println("ARU " + fi.toString());
				} else {
					System.out.println("NAI " + fi.toString());
				}
			}
			
					System.out.println("\n--- 3 ---\n");
			
				System.out.println(info);//注釈インタフェース
			
			var infot = info.annotationType();
				System.out.println(infot);//インタフェース
//			System.out.println(Arrays.toString(info.annotationType().getAnnotations()));
			
					System.out.println("\n--- 4 ---\n");

				System.out.println(cls.getPackage());//インタフェース

					System.out.println("\n--- 5 ---\n");

				

//		} catch(ClassNotFoundException|NoSuchFieldException e ) {
//		} catch(ClassNotFoundException|IllegalAccessException|InstantiationException|InvocationTargetException|NoSuchMethodException e ) {
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	* 何もしない
	* @throws Exception :エグゼぷしょん
	*/
	public static void men() throws Exception {
		
	}

	@Override
	public Annotator clone() {
		try {
			return (Annotator)super.clone();
		} catch(Exception e) {
			throw new InternalError(e.toString());
		}
	}

}