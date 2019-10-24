package com.zerofinance.aka.core.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.zerofinance.aka.core.annoations.Builder;

public class AkaInitService {

	private List<String> scanPackages = Arrays.asList("com.zerofinance.aka.core.entity");

	public void build() throws IOException {

		List<ClassInfo> uiClassList = loadUiClassInfo();
		List<ClassInfo> autoGenerateEntityList = loadAllAutoGenerateEntity();
		generateCode(uiClassList, autoGenerateEntityList);

	}

	/**
	 * 构建代码
	 * 
	 * @param uiClassList            需要进行构建的界面类型
	 * @param autoGenerateEntityList 需要构建的实体列表
	 */
	private void generateCode(List<ClassInfo> uiClassList, List<ClassInfo> autoGenerateEntityList) {
		autoGenerateEntityList.stream().forEach(entity -> generateCode(entity.load(),
				uiClassList.stream().map(uiClassInfo -> uiClassInfo.load()).collect(Collectors.toList())));
	}

	private List<ClassInfo> loadAllAutoGenerateEntity() throws IOException {
		ClassPath classPath = ClassPath.from(this.getClass().getClassLoader());
		List<ClassInfo> list = new ArrayList<>();
		scanPackages.stream().map(item -> classPath.getTopLevelClasses(item)).collect(Collectors.toList()).stream()
				.forEach(item -> item.stream().forEach(insideItem -> list.add(insideItem)));
		return list;

	}

	private List<ClassInfo> loadUiClassInfo() throws IOException {
		ClassPath classPath = ClassPath.from(this.getClass().getClassLoader());
		ImmutableSet<ClassInfo> result = classPath.getTopLevelClasses("com.zerofinance.aka.core.ui");
		return result.stream().filter(item -> {
			Class<?> clazz = item.load();
			Builder builderAnnotation = clazz.getAnnotation(Builder.class);
			if (builderAnnotation != null) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());

	}

	@SuppressWarnings("unchecked")
	private  void generateCode(Class entity, List<Class<?>> uiClassList) {
		uiClassList.stream().filter(uiClass -> uiClass.isAssignableFrom(entity)).collect(Collectors.toList())
		.forEach(uiClass -> {
			System.out.println(String.format("构建代码开始: %s\t%s", entity.getName(),uiClass.getName()));
			Builder builderAnnoation = uiClass.getAnnotation(Builder.class);
				try {
					builderAnnoation.value().newInstance().buildCode(entity);
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("构建代码出错",e);
				}
		});
		
	}

	public static void main(String[] args) {
		try {
			new AkaInitService().build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取这个类的所有父类
	 * 
	 * @param clazz
	 * @return
	 */
	public static List<Class<?>> getAllSuperClass(Class<?> clazz) {
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		Class<?> suCl = clazz.getSuperclass();
		while (suCl != null) {
			System.out.println(suCl.getName());
			clazzs.add(suCl);
			suCl = suCl.getSuperclass();
		}
		return clazzs;
	}
}