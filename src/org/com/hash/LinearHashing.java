package org.com.hash;

import java.util.Arrays;

public class LinearHashing {
	private int hashArray[];
	private int arraySize;
	private int temp;

	public LinearHashing() {

	}

	public LinearHashing(int size, int temp) {
		arraySize = size;
		hashArray = new int[size];
		this.temp = temp;
	}

	public boolean find(int searchEle) {
		int key = hashFunc(searchEle);
		while (hashArray[key] != 0) {
			if (hashArray[key] == searchEle) {
				return true;
			}
			key++;
			key = key % arraySize;
		}
		return false;
	}

	public int insert(int insertEle) {
		int index = hashFunc(insertEle);
		while (hashArray[index] != 0 && hashArray[index] != -1) {
			index++;
			index = index % arraySize;
		}
		hashArray[index] = insertEle;
		return index;
	}

	public boolean delete(int delEle) {
		int index = hashFunc(delEle);
		while (hashArray[index] != 0) {
			if (hashArray[index] == delEle) {
				// int delIndex=index;
				hashArray[index] = temp;
				return true;
			}
			index++;
			index = index % arraySize;
		}

		return false;

	}

	public int hashFunc(int ele) {
		return ele % hashArray.length;
	}

	public static void main(String args[]) {
		LinearHashing lh = new LinearHashing(10, -1);
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
