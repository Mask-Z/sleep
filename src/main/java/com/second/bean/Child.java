package com.second.bean;

/**
 * @author 周云龙
 * @date 2018/5/14 23:19
 */
public class Child implements People {
	@Override
	public void run() {
		System.out.println("步履蹒跚");
	}

	@Override
	public void eat() {
		System.out.println("囫囵吞枣");
	}

	@Override
	public String say(String name) {
		return name+"咿呀学语";
	}
}
