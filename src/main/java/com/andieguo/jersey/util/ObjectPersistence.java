package com.andieguo.jersey.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 将对象写入文件采用的全部覆盖的方式，如果想要添加元素到对象集合中，需先读取对象集合-->添加元素到对象集合-->写入对象集合到文件
 * @author andieguo@foxmail.com
 *
 */
public class ObjectPersistence {
	
	private final static String PATH = "/user.dat";

	public static boolean writeObjectToFile(Object obj) {
		File file = new File(ObjectPersistence.class.getResource(PATH).getPath());
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			ObjectOutputStream objectOut = new ObjectOutputStream(out);
			objectOut.writeObject(obj);
			objectOut.flush();
			objectOut.close();
			System.out.println("write object success!");
			return true;
		} catch (IOException e) {
			System.out.println("write object failed");
			e.printStackTrace();
			return false;
		}
	}

	public static Object readObjectFromFile() {
		Object obj = null;
		File file = new File(ObjectPersistence.class.getResource(PATH).getPath());
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			ObjectInputStream objectInput = new ObjectInputStream(in);
			obj = objectInput.readObject();
			objectInput.close();
			System.out.println("read object success!");
		} catch (IOException e) {
			System.out.println("read object failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
