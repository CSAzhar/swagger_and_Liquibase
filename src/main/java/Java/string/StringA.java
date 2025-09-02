package Java.string;

import java.util.Arrays;

public class StringA {
	public static void main(String[] args) {
		String a = "Azhar";
		String b = "Azhars";
		String c = "aliazhar";
		String d = "azhar\tUddin";
		String e = "AB\bC";
		String f = " Hello World ";
		String g = null+"azhar";
		String html = """
				<html>
		<h2>Hello Azhar</h2>
		<html>
				""";
		System.out.println(new StringBuilder(f).reverse().toString().trim());
		String arr[] = f.trim().split("\\s");
		System.out.println(Arrays.toString(arr));
	}

}
