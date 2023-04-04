/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eq3progpatterns;

/**
 *
 * @author adinashby
 */
public class LinkedList {
    Node head;
    
    class Node {
        int data;
        Node next;
    }
    
    public void insert(int data) {
        Node node = new Node();
        
        node.data = data;
        node.next = null;
        
        if(head == null) {
            head = node;
        } else {
            Node n = head;
            
            while(n.next != null) {
                n = n.next;
            }
            
            // n.next == null
            n.next = node;
            
        }
    }
    
    public void insertAtStart(int data) {
        Node node = new Node();
        
        node.data = data;
        node.next = null;
        
        node.next = head;
        
        head = node;
    }
    
    public void insertAt(int index, int data) {
        Node node = new Node();
        
        node.data = data;
        node.next = null;
        
        if(index == 0) {
            insertAtStart(data);
        } else {
            Node n = head;
            
            for(int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            
            node.next = n.next;
            n.next = node;
            
        }
    }
    
    public void deleteAt(int index) {
         
        if(index == 0) {
            head = head.next;
        } else {
            Node n = head;
            
            for(int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            
            n.next = n.next.next;
            
        }
        
    }
    
    public void show() {
        Node node = head;
        
        while(node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        
        System.out.println(node.data);
    }
    
}
