package br.edu.ifpb.pweb2.utils;

public class Utils {
	public static int getId(String value) {
		String[] array = value.split(" - ");
		return Integer.parseInt(array[0]);
	}
}
