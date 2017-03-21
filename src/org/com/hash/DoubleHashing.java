package org.com.hash;

import java.util.Arrays;

public class DoubleHashing {
	private int hashArray[];
	private int arraySize;
	private int temp;

	public DoubleHashing(){
		
	}

	public DoubleHashing(int size,int temp){
		arraySize=size;
		hashArray=new int[size];
		this.temp=temp;
	}

	public boolean find(int searchEle) {
		int key = hashFunc(searchEle);
		int stepSize=hashFunc2(searchEle);
		while (hashArray[key] != 0) {
			if (hashArray[key] == searchEle) {
				return true;
			}
			key=key+stepSize;
			key = key % arraySize;
		}
		return false;
	}

	public int insert(int insertEle) {
		int index = hashFunc(insertEle);
		int stepSize=hashFunc2(insertEle);
		while (hashArray[index] != 0 && hashArray[index] != -1) {
			index=index+stepSize;
			index = index % arraySize;
		}
		hashArray[index] = insertEle;
		return index;
	}

	public boolean delete(int delEle) {
		int index = hashFunc(delEle);
		int stepSize=hashFunc2(delEle);
		while (hashArray[index] != 0) {
			if (hashArray[index] == delEle) {
				// int delIndex=index;
				hashArray[index] = temp;
				return true;
			}
			index=index+stepSize;
			index = index % arraySize;
		}

		return false;

	}

	public int hashFunc(int ele) {
		return ele % hashArray.length;
	}
	public int hashFunc2(int index){
		return 5-index%5;
	}
	public static void main(String args[]) {
		DoubleHashing lh = new DoubleHashing(10, -1);
		lh.insert(10);
		lh.insert(15);
		lh.insert(18);
		lh.insert(58);
		lh.insert(68);
		lh.insert(167);
		lh.insert(25);
		System.out.println(Arrays.toString(lh.hashArray));
		System.out.println("Element found: " + lh.find(67));
		System.out.println("Element deleted: " + lh.delete(25));
		System.out.println(Arrays.toString(lh.hashArray));

	}
}
