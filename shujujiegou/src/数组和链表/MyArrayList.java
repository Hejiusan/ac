package 数组和链表;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {
    // 真正存储数据的底层数组
    private E[] data;
    // 记录当前元素个数
    private int size;
    // 默认初始容量
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    // 在索引位置插入值
    public void add(int index, E e) {
        checkPositionIndex(index);  //检查该索引还能添加元素不
        //数据搬移
        System.arraycopy(data,index,data,index+1,size-index);
        //赋值
        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        if (data.length == size) resize(data.length * 2);  //考虑边界
        data[size] = e;
        size++;

    }

    public void addFirst(E e) {
        add(0,e);
    }

    // 删除索引位置元素
    public E remove(int index) {
        checkElementIndex(index);
        E old = data[index];
        //如果当前元素个数小于容量到四分之一，缩一半
        if (size < data.length/4) resize(data.length/2);
        //数据整体往前搬一位
        System.arraycopy(data,index+1,data,index,size-index-1);
        //删掉最后位置的引用
        data[size-1] = null;
        size--;
        return old;
    }

    public E removeFirst() {
        return remove(0);
    }

    //删除数组的最后一个元素并返回
    public E removeLast() {
        //数组为空？
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        //如果当前元素个数小于容量到四分之一，缩一半
        if (size < data.length/4) resize(data.length/2);
        E oldVal=data[size-1];
        data[size-1] = null;
        size--;
        return oldVal;
    }

    // 查
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    // 修改索引上的元素并返回旧值
    public E set(int index, E element) {
        checkElementIndex(index);
        E old = data[index];
        data[index] = element;
        return old;
    }


    // 工具方法
    // 将 data 的容量改为 newCap
    private void resize(int newCap) {
        E temp[] = (E[]) new Object[newCap];
        //拷贝原数组到扩容后到数组中
        System.arraycopy(data, 0, temp, 0, size);
        //覆盖掉
        data = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
            private int p = 0;

            @Override
            public boolean hasNext() {
                return p != size;
            }

            @Override
            public E next() {
                return data[p++];
            }
        };
    }
}