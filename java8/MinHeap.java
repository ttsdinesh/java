import java.util.Arrays;

public class MinHeap extends AbstractHeap {

	public MinHeap(int capacity) {
		super(capacity);
		heap[0] = Integer.MIN_VALUE;
	}

	private void minHeapify(int pos) {
		if (isLeaf(pos) == false) {
			if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
				if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
					swap(pos, heap[leftChild(pos)]);
					minHeapify(leftChild(pos));
				} else {
					swap(pos, heap[rightChild(pos)]);
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	@Override
	public void insert(int element) {
		if (size == capacity) {
			System.out.println("Reached max limit. Removing the leaf node.");
			size--;
		}
		heap[++size] = element;
		int currentSize = size;

		while (heap[currentSize] < heap[parent(currentSize)]) {
			swap(currentSize, parent(currentSize));
			currentSize = parent(currentSize);
		}
		System.out.println("" + Arrays.toString(heap));
	}

	@Override
	public int pop() {
		int popped = heap[_ROOT];
		heap[_ROOT] = heap[size--];
		minHeapify(_ROOT);
		return popped;
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(5);
		minHeap.insert(5);
		minHeap.insert(1);
		minHeap.insert(3);
		minHeap.insert(2);
		minHeap.insert(4);
		minHeap.print();
		minHeap.pop();
		System.out.println("Deleting");
		minHeap.print();
	}

}
