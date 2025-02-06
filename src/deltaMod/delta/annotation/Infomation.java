package gamma;

import java.io.*;
import java.util.*;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//構成情報宣言
@Documented
@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Target({ElementType.TYPE, ElementType.FIELD})

/**
* 自作アノテーション
* @author う
* @version 1.01
*/
//@interface命令でアノテーション定義
public @interface Infomation {
	String value() default "";
	Class cls() default Infomation.class;
	//型の後に「.class」をつけるとクラスリテラルになる
}
//public @interface Infomation {
//
//	//アノテーションで利用できる属性を宣言
//	String value() default "";
//	String version() default "";
//	String description() default "";
//
//}