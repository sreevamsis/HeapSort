public interface HeapADT<E> {
  void insert(E data);
  void extract_min();
  E delete_min();
  void heapify(int index);
  boolean isEmpty();
  boolean isFull();
  void sort();
}