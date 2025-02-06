package gamma;

import java.io.*;
import java.util.*;
import java.lang.*;


/**
* Bean
*/
@Infomation(value = "inbe", cls = InfomeBean.class)
public class InfomeBean implements Serializable {

	private String name;
	private int age;
	private Class cls;

	/**
	* コンストラクタ
	*/
	public InfomeBean() {}
	public InfomeBean(String s, int i) {}

//セッター
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public void setCls(Class cls) {
		this.cls = cls;
	}


//ゲッター
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	public Class getCls() {
		return cls;
	}


//Annotator
	private void annoExp() {
		try {
				System.out.println("--- 5 ---");
			var tator = Class.forName("gamma.Annotator");
				System.out.println(tator);
		} catch(ClassNotFoundException e) {
			
		}
	}


}