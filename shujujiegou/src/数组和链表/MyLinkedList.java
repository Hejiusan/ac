package 数组和链表;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    // 虚拟头尾节点   只起到占位作用
    final private Node<E> head, tail;
    private int size;

    // 双链表节点
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    // 构造函数初始化头尾节点
    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }


    /***** 增 *****/

    public void addLast(E e) {
        Node<E> x = new Node<>(e);  //定义这个新节点
        Node<E> temp = tail.prev;   //曾经的最后一个节点
        x.prev=temp;
        x.next = tail;

        tail.prev=x;
        temp.next=x;

        size++;
    }

    public void addFirst(E e) {
        Node<E> x = new Node<>(e);  //定义这个新节点
        Node<E> temp = head.next;
        x.next = temp;    //新节点指向的next为head指向的next
        x.prev = head;

        head.next = x;
        temp.prev = x;
        size++;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        Node<E> x = new Node<>(element);    //待插入节点
        Node<E> node = getNode(index);
        Node<E> temp = node.prev;
        x.next=node;
        x.prev=temp;

        temp.next=x;
        node.prev=x;
        size++;
    }

    /***** 删 *****/

    public E removeFirst() {
        Node<E> x = head.next;  //待删除节点
        head.next=x.next;
        x.next.prev=head;   //原本x的下一个的节点的prev指向了head
        size--;
        return x.val;
    }

    public E removeLast() {
        Node<E> x = tail.prev;  //待删除节点
        tail.prev=x.prev;
        x.prev.next=tail;

        size--;
        return x.val;
    }

    public E remove(int index) {
        Node<E> node = getNode(index);  //待删除节点
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        prev.next = node.next;
        next.prev=prev;

        node.next=node.prev=null;

        size--;
        return node.val;
    }

    /***** 查 *****/

    public E get(int index) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        return node.val;
    }

    public E getFirst() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }

    /***** 改 *****/

    public E set(int index, E val) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        E old = node.val;
        node.val=val;
        return old;
    }

    /***** 其他工具函数 *****/

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 因为链表不能随机访问，只能通过遍历
     * @param index
     * @return  返回index对应的节点
     */
    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> p = head.next;
        // TODO: 可以优化，通过 index 判断从 head 还是 tail 开始遍历
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 检查 index 索引位置是否可以存在元素
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * 检查 index 索引位置是否可以添加元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }


}