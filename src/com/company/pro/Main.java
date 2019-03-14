package com.company.pro;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {1,2,3,4,5,6,7,8,9,10};
		Arrays.sort(list, new mySort());
		System.out.println(Arrays.toString(list));
		
		Student stu1 = new Student(1, "홍길동");
		Student stu2 = new Student(2, "일지매");
		Student stu3 = new Student(3, "일지매");
		List<Student> test = Arrays.asList(stu1,stu2,stu3);
		Collections.sort(test);
		for(Student st : test)
		{
			System.out.println(st);
		}
	}
	static class mySort implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}

class Student implements Comparable<Student> {
	int num;
	String name;
	Student(int a, String b) {
		num=a; name =b;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.name.compareTo(o.name) < 0) return -1;
		else if(this.name.compareTo(o.name) > 0) return 1;
		else return 0;
	}
}
