@SuppressWarnings("unchecked")

class HeapArraySort<E extends Comparable<E>> implements HeapADT<E> {
  E[] heap;
  int capacity;
  int size;
  HeapArraySort() {
    size = -1;
    capacity = 10;
    heap = (E[])new Comparable[capacity];
  }
  public boolean isFull() {
    if (size + 1 == capacity) {
      return true;
    }
    return false;
  }
  public boolean isEmpty() {
    if (size == -1) {
      return true;
    }
    return false;
  }
  public void insert(E data) {
    if (isFull()) {
      System.out.println("Heap is Full");
    } else {
      heap[++size] = data;
      if (size > 0) {
        heapify(size);
      }
    }
  }
  public void heapify(int index) {
    for (int i = index; i > 0; i--) {
      if (heap[i].compareTo(heap[(i - 1) / 2]) < 0) {
        E temp = heap[i];
        heap[i] = heap[(i - 1) / 2];
        heap[(i - 1) / 2] = temp;
      }
    }
  }
  public void extract_min() {
    if (isEmpty()) {
      System.out.println("Heap is empty");
    }else {
      System.out.println(heap[0]);
    }
  }
  public E delete_min() {
    E data = null;
    if (size >= 0) {
      data = heap[0];
      heap[0] = heap[size];
      size--;
      for (int i = 0; i <= size; i ++) {
        if (((2 * i + 1) <= size) && ((2 * i + 2) <= size)) {
          if (heap[2*i+1].compareTo(heap[2*i+2]) < 0) {
            if (heap[2*i+1].compareTo(heap[i]) < 0) {
              E temp = heap[2*i+1];
              heap[2*i+1] = heap[i];
              heap[i] = temp;
            }
          } else {
            if (heap[2*i+2].compareTo(heap[i]) < 0) {
              E temp = heap[2*i+2];
              heap[2*i+2] = heap[i];
              heap[i] = temp;
            }
          }
        } else {
          if (2*i+1 <= size) {
            if (heap[2*i+1].compareTo(heap[i]) < 0) {
              E temp = heap[2*i+1];
              heap[2*i+1] = heap[i];
              heap[i] = temp;
            }
          }
          if (2*i+2 <= size) {
            if (heap[2*i+2].compareTo(heap[i]) < 0) {
              E temp = heap[2*i+2];
              heap[2*i+2] = heap[i];
              heap[i] = temp;
            }
          }
        }
      }
    }
    return data;
  }
  public void sort() {
    E[] data = (E[])new Comparable[capacity];
    int i = 0;
    E min = null;
    for (i = 0; (min = delete_min()) != null; i++) {
      data[i] = min;
    }
    for (int j = 0; j < i; j++) {
      System.out.print(data[j]);
      if (j < i - 1) {
        System.out.print(",");
      }
    }
  }
  public void display() {
    if (isEmpty()) {
      System.out.println("Heap is empty");
    } else {
      for (int i = 0; i <= size; i++) {
        System.out.print(heap[i]);
        if (i < size) {
          System.out.print(",");
        }
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    HeapArraySort<Integer> heaparray = new HeapArraySort<Integer>();
    heaparray.insert(1);
    heaparray.insert(4);
    heaparray.insert(5);
    heaparray.insert(5);
    heaparray.insert(2);
    heaparray.insert(3);
    heaparray.display();
    heaparray.sort();
  }
}