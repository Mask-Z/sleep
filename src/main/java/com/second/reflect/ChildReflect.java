package com.second.reflect;

import com.second.bean.Child;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 周云龙
 * @date 2018/5/14 23:20
 */
public class ChildReflect {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Class clazz = Class.forName("com.second.bean.Child");
		Method[] methods = clazz.getMethods();
		Arrays.asList(methods).forEach(System.out::println);
		System.out.println(clazz.getClassLoader());
		System.out.println(clazz.getConstructors()[0]);
		System.out.println(clazz.getMethod("say", String.class).invoke(clazz.newInstance(), "小明"));
	}
}
