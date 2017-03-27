package Page3;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BST<K extends Comparable<K>, V extends Comparable<V>> {

	private class Node {

		private K key;

		private V value;

		Node left;

		Node right;

	    Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = this.right = null;
		}
	    
	    Node(Node node) {
			this.key = node.key;
			this.value = node.value;
			this.left = node.left;
			this.right = node.right;
		}
	}

	Node root;

	int count;

	public BST() {
		root = null;
		count = 0;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void levelOrder() {
		Queue<Node> queue = new LinkedBlockingQueue();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.key + " ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	// 后序遍历
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(BST<K, V>.Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.key);
		}
	}

	// 中序遍历
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(BST<K, V>.Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.key);
			inOrder(node.right);
		}
	}

	// 前序遍历
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(BST<K, V>.Node node) {
		if (node != null) {
			System.out.println(node.key);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public V seach(K key) {
		return contain(key) ? seach(root, key) : null;
	}

	private V seach(BST<K, V>.Node node, K key) {
		if (node == null) {
			return null;
		}
		if (key == node.key) {
			return node.value;
		} else if (key.compareTo(node.key) < 0) {
			return seach(node.left, key);
		} else {
			return seach(node.right, key);
		}

	}

	public boolean contain(K key) {
		return contain(root, key);
	}

	private boolean contain(BST<K, V>.Node node, K key) {
		if (node == null) {
			return false;
		}

		if (key == node.key) {
			return true;
		} else if (key.compareTo(node.key) < 0) {
			return contain(node.left, key);
		} else {
			return contain(node.right, key);
		}

	}

	public void insert(K key, V value) {
		root = insert(root, key, value);
	}

	private BST<K, V>.Node insert(BST<K, V>.Node node, K key, V value) {
		if (node == null) {
			count++;
			return new Node(key, value);
		}
		if (key == node.key) {
			node.value = value;
		} else if (key.compareTo(node.key) < 0) {
			node.left = insert(node.left, key, value);
		} else {
			node.right = insert(node.right, key, value);
		}

		return node;
	}

	public K minimum() {
		if (count != 0) {
			Node minNode = minimum(root);
			return minNode.key;
		}
		return null;
	}

	private BST<K, V>.Node minimum(BST<K, V>.Node node) {
		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}

	public K maxmum() {
		if (count != 0) {
			Node maxNode = maxmum(root);
			return maxNode.key;
		}
		return null;
	}

	private BST<K, V>.Node maxmum(BST<K, V>.Node node) {
		if (node.right == null) {
			return node;
		}
		return maxmum(node.right);
	}

	public void removeMin() {
		if (root != null) {
			root = removeMin(root);
		}
	}

	private BST<K, V>.Node removeMin(BST<K, V>.Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			count--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	public void removeMax() {
		if (root != null) {
			root = removeMax(root);
		}
	}

	private BST<K, V>.Node removeMax(BST<K, V>.Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			count--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}

	public void remove(K key) {
		root = remove(root, key);
	}

	private BST<K, V>.Node remove(BST<K, V>.Node node, K key) {
		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		} else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		} else { // key == node.key
			if (node.left == null) {
				Node rightNode = node.right;
				count--;
				return rightNode;
			}
			if (node.right == null) {
				Node leftNode = node.left;
				count--;
				return leftNode;
			}

			Node su = new Node( minimum(node.right) );		
			su.right = removeMin(node.right);
			su.left= node.left;
			return su;
		}
	}
	
	
}
