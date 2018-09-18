package com.company.etc;

class NodeList {
	private Node head; // 맨 처음 
	private Node tail; // 맨 끝 
	private int size; // 노드 갯수 
	
	private class Node{
		int data;
		Node next; // 노드의 다음 노드를 가르킴 
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	public void addFirst(int data) // 맨 앞 노드 추가 
	{
		Node newNode = new Node(data); // 노드 생성 
		
		newNode.next = head; // 새로 만든 노드를 이전에 헤드 였던에랑 연결!!!
		
		head = newNode; // haed가 새로 만들어진 노드를 가르키도록 ! 
		
		if(head.next == null)
		{
			tail = head; // 현재 노드가 하나밖에 없어서 head 의 다음이 없다면 그곳이 tail 자리도 되니까 
		}
		
		size++;
	}
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		
		if(size == 0) {
			addFirst(data);
		}
		
		tail.next = newNode; // 이전 tail 의 노드 값과 새로운 노드 연결 
		tail = newNode; // tail 을 새로운 노드로 갱신 
		size++;
	}
	public Node node(int index) // 특정 인덱스 노드 찾아가기 
	{
		Node target = head;
		for(int i=0; i< index; i++)
		{
			target = target.next;
		}
		return target;
	}
	public void add(int index, int data) // 특정 인덱스 노드에 삽입 
	{
		if(size ==0) {
			addFirst(data);
		}
		else 
		{
			Node preNode = node(index-1); // 그전 노드 가져오기 
			Node nextNode = preNode.next; // 그 다음 노드 가져오기 
			
			Node newNode = new Node(data); // 중간에 삽입할 노드 
			preNode.next = newNode; // 이전 노드랑 연결 
			newNode.next = nextNode; // 새로만든 노드를 다음 노드와 연결 
			size++;
			
			if(newNode.next == null ) // 다음 노드가 없다는건 해당 노드가 끝 이니까 tail 로 갱신 
			{
				tail = newNode;
			}
		}
	}
	public int removeFirst() { // 가지고 있던 데이터 리턴이 원칙 
		
		Node temp = head; // 헤드가 가르키고 있는 첫번째 값을 임시로 저장 (삭제전)
		
		head = temp.next; // 헤드를 다음 노드를 가르키게 
		
		int deleteDate = temp.data; // 삭제 시킬 데이터 
		temp = null; // 삭제 
		
		size--;
		
		return deleteDate;
	}
	public int remove(int k) {
		
		if(k ==0) {
			return removeFirst();
		}
		Node temp = node(k-1); // 삭제시킬 바로 이전 노드 가져오기 
		
		Node todoDelete = temp.next; // 삭제할 노드 
		
		temp.next = temp.next.next; // 삭제 할 노드 다음 노드 
		
		int returnData = todoDelete.data;
		
		if(todoDelete == tail)
		{
			tail = temp; // 이전 노드로 갱신 
		}
		
		size--;
		todoDelete = null;
		return returnData;
	}
	public int removeLast()
	{
		return remove(size-1);
	}
	public String toString() {
		
		if(head == null) {
			return "[ ]";
		}
		
		Node temp = head;
		
		String str ="[";
		
		while(temp.next != null)
		{
			str += temp.data + ",";
			temp = temp.next;
		}
		str += temp.data;
		return str+"]";
	}
}

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeList list = new NodeList();
		list.addFirst(10);
		list.addFirst(20);
		list.addLast(30);
		System.out.println(list.removeFirst());
		System.out.println(list);
	}

}

