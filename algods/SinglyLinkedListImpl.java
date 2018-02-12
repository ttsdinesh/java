public class SinglyLinkedListImpl
{
	public static void main(String[] args)
	{
		List<Integer> linkedList = new SinglyLinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(4);
		linkedList.traverse();
		linkedList.delete(4);
		//		linkedList.insertAfter(4, 5);
		linkedList.traverse();
	}
}

class SinglyLinkedList<Data> implements List<Data>
{
	Node<Data> head, tail;

	@Override
	public void add(Data item)
	{
		Node<Data> node = new Node<Data>();
		node.setItem(item);
		if (head == null)
		{
			head = tail = node;
		}
		else
		{
			tail.setNextNode(node);
			tail = node;
		}
	}

	@Override
	public void delete(Data item)
	{
		Node<Data> cursor = head;
		Node<Data> prevNode = null;
		Node<Data> targetNode = null;
		if (cursor == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			while (true && cursor != null)
			{
				System.out.println("Traversing the item: " + cursor.getItem());
				if (cursor.compareTo(item) == 0)
				{
					System.out.println("Found and removing the item: " + item);
					targetNode = cursor;
					break;
				}
				prevNode = cursor;
				cursor = cursor.getNextNode();

			}
			if (targetNode != null && prevNode == null)
			{
				removeHead();
			}
			else if (targetNode != null)
			{
				prevNode.setNextNode(targetNode.getNextNode());
				System.out.println("Removed the item");
			}
			else
			{
				System.out.println("Unable to find the item: " + item);
			}
		}
	}

	private void removeHead()
	{
		System.out.println("Removed the item: " + head.getItem());
		head = head.getNextNode();
	}

	@Override
	public void insertAfter(Data referenceItem, Data item)
	{
		Node<Data> cursor = head;
		Node<Data> newNode = null;
		if (cursor == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			while (true && cursor != null)
			{
				System.out.println("Traversing the item : " + cursor.getItem());
				if (cursor.compareTo(referenceItem) == 0)
				{
					System.out.println("Found the reference item: " + cursor.getItem());
					newNode = new Node<Data>();
					newNode.setItem(item);
					newNode.setNextNode(cursor.getNextNode());
					cursor.setNextNode(newNode);
					break;
				}
				cursor = cursor.getNextNode();
			}
			if (newNode == null)
			{
				System.out.println("Unable to find the item: " + referenceItem);
			}
		}
	}

	@Override
	public void traverse()
	{
		Node<Data> tmp = head;
		if (tmp == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			while (true)
			{
				System.out.println("Value: " + tmp.getItem());
				if (tmp.getNextNode() == null)
				{
					break;
				}
				tmp = tmp.getNextNode();
			}
		}
	}
}

class Node<Data> implements Comparable<Data>
{
	private Data item;
	private Node<Data> nextNode;

	public Data getItem()
	{
		return item;
	}

	public void setItem(Data item)
	{
		this.item = item;
	}

	public Node<Data> getNextNode()
	{
		return nextNode;
	}

	public void setNextNode(Node<Data> node)
	{
		this.nextNode = node;
	}

	@Override
	public int compareTo(Data arg)
	{
		if (this.item == arg)
		{
			return 0;
		}
		return 1;
	}
}

interface List<Data>
{
	public void add(Data item);

	public void delete(Data item);

	public void insertAfter(Data referenceItem, Data item);

	public void traverse();
}
