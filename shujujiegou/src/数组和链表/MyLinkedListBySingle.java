package 数组和链表;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 用单链表实现，也就是说链表通过next指针连成链
 * @param <E>
 */
public class MyLinkedListBySingle<E> implements Iterable<E> {
    // 虚拟头尾节点   只起到占位作用
    final private Node<E> head, tail;
    private int size;

    // 双链表节点
    private static class Node<E> {
        E val;
        Node<E> next;
        Node(E val) {
            this.val = val;
        }
    }

    // 构造函数初始化头尾节点
    public MyLinkedListBySingle() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;

        this.size = 0;
    }


    /***** 增 *****/

    public void addLast(E e) {
        Node<E> x = new Node<>(e);  //定义这个新节点
        Node<E> temp;   //单链表，所以可以通过getNode()方法来获得曾经的最后一个节点
        if (size - 1 >= 0) {
            temp = getNode(size - 1);
        } else {
            temp = head;
        }

        // temp -> tail
        x.next = tail;
        temp.next = x;

        size++;
    }

    public void addFirst(E e) {
        Node<E> x = new Node<>(e);  //定义这个新节点
        Node<E> temp = head.next;
        x.next = temp;    //新节点指向的next为head指向的next

        head.next = x;

        size++;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        // 判断特殊情况
        if (index == size) {
            addLast(element);
            return;
        }
        Node<E> x = new Node<>(element);    //待插入节点
        Node<E> node = getNode(index);
        Node<E> temp;   //待插入节点的prev节点
        if (index - 1 >= 0) {
            temp = getNode(index - 1);
        } else {
            temp = head;
        }
        x.next=node;

        temp.next=x;

        size++;
    }

    /***** 删 *****/

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> x = head.next;  //待删除节点
        // head -> x -> ...
        head.next = x.next;
        x.next = null;

        size--;
        return x.val;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> x = getNode(size - 1);  //待删除节点
        Node<E> temp;   //待删除节点的prev节点
        if (size - 2 >= 0) {
            temp = getNode(size - 2);
        } else {
            temp = head;
        }
        // temp -> x -> tail
        temp.next = tail;
        x.next = null;
        size--;
        return x.val;
    }

    public E remove(int index) {
        Node<E> node = getNode(index);  //待删除节点
        Node<E> prev;   //待删除节点的prev节点
        if (index - 1 >= 0) {
            prev = getNode(index - 1);
        } else {
            prev = head;
        }
        Node<E> next = node.next;
        prev.next = node.next;

        node.next=null;

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
        Node<E> node = getNode(size - 1);
        return node.val;
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