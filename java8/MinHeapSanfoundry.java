public class MinHeapSanfoundry {
	private int[] minHeap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeapSanfoundry(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		minHeap = new int[this.maxsize + 1];
		minHeap[0] = Integer.MIN_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) {
		int tmp;
		tmp = minHeap[fpos];
		minHeap[fpos] = minHeap[spos];
		minHeap[spos] = tmp;
	}

	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (minHeap[pos] > minHeap[leftChild(pos)] || minHeap[pos] > minHeap[rightChild(pos)]) {
				if (minHeap[leftChild(pos)] < minHeap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	public void insert(int element) {
		minHeap[++size] = element;
		int current = size;
		while (minHeap[current] < minHeap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + minHeap[i] + " LEFT CHILD : " + minHeap[2 * i] + " RIGHT CHILD :"
					+ minHeap[2 * i + 1]);
			System.out.println();
		}
	}

	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public int remove() {
		int popped = minHeap[FRONT];
		minHeap[FRONT] = minHeap[size--];
		minHeapify(FRONT);
		return popped;
	}

	public static void main(String... arg) {
		System.out.println("The Min Heap is ");
		MinHeapSanfoundry minHeap = new MinHeapSanfoundry(5);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		minHeap.insert(11);
		minHeap.insert(12);
		minHeap.insert(13);
		minHeap.insert(14);
		minHeap.insert(15);
		minHeap.insert(16);
		minHeap.minHeap();

		minHeap.print();
	}
}
