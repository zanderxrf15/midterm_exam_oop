package tree;
/** Binary trees with nodes labelled by integers */
public class Tree {
		private int root;
		private Tree left, right;

		/** Creates a new instance of Tree: a branch */
		public Tree(int root, Tree left, Tree right) {
			this.root = root;
			this.left = left;
			this.right = right;
		}

		/**
		 * Creates a new instance of Tree: a leaf (a special case
		 * of the above) */
		public Tree(int root) {
			this.root = root;
			this.left = null;
			this.right = null;
		}

		/** Sample method: Mirror myself */
		public void mirror() {
			if (left != null) { // Left branch, please mirror yourself
				left.mirror();  // This works by delegation
			}
			if (right != null) { // Right branch, please mirror yourself
				right.mirror();  // This works by delegation
			}
			Tree originalLeft = left; // Swap the branches, mirror myself
			left = right;
			right = originalLeft;
		}
		
		/**
		 * Converts a tree to an expression-tree string representation
		 */
		@Override
		public String toString() {
			String sleft, sright;

			// Convert the left and right branches to strings,
			// delegating the task to them if they exist.
			if (left == null) {
				sleft = "empty";
			} else {
				sleft = left.toString(); // Please do your job, Mr. Left Subtree.
			}
			if (right == null) {
				sright = "empty";
			} else {
				sright = right.toString(); // Please do your job, Mrs. Right Subtree.
			}
			// Now I do my own job:
			String s = "branch(" + root + "," + sleft + "," + sright + ")";
			return s;
		}

		/**
		 * Converts a tree to an expression-tree string representation (advanced)
		 */
		public String toStringAdv() {
			return this.toStringFrom(0);
		}
		public String toStringFrom(int depth) {
			int step = 4; // Depth step (number of spaces printed)

			// Delegate task to Mr. Left Subtree, if necessary:
			String sleft;
			if (left != null) {
				sleft = left.toStringFrom(depth + step);
			} else {
				sleft = "";
			}
			// Delegate task to Mrs. Right Subtree, if necessary:
			String sright;
			if (right != null) {
				sright = right.toStringFrom(depth + step);
			} else {
				sright = "";
			}
			// My own task now:
			String s = sright + spaces(depth) + root + "\n" + sleft;
			return s;
		}
		private String spaces(int n) {
			String s = "";
			for (int i = 0; i < n; i++) {
				s = s + " ";
			}
			return s;
		}
		
		// 2
		// Triple the value of each node in the tree
		public void triple() {
		    if (left != null) {
		        left.triple(); // Recursively triple left subtree
		    }
		    if (right != null) {
		        right.triple(); // Recursively triple right subtree
		    }
		    root *= 3; // Triple node value
		}

		// 3
		// Print tree in depth-first order
		public void printDepthFirst() {
		    System.out.print(root + " "); // Print node value
		    if (left != null) {
		        left.printDepthFirst(); // Recursively print left subtree
		    }
		    if (right != null) {
		        right.printDepthFirst(); // Recursively print right subtree
		    }
		}

		// 4
		// Create fresh copy of tree
		public Tree createFreshCopy() {
		    Tree leftCopy = null;
		    Tree rightCopy = null;

		    if (left != null) {
		        leftCopy = left.createFreshCopy(); // Recursively create fresh copy of left subtree
		    }
		    if (right != null) {
		        rightCopy = right.createFreshCopy(); // Recursively create fresh copy of right subtree
		    }

		    return new Tree(root, leftCopy, rightCopy); // Create new tree with copied values
		}

		// 5
		// Save tree in depth-first order into array
		public int saveDepthFirst(int a[], int whereToStart) {
		    a[whereToStart] = this.root; // Save node value in array

		    if (left != null) {
		        whereToStart = left.saveDepthFirst(a, whereToStart + 1); // Recursively save left subtree
		    }
		    if (right != null) {
		        whereToStart = right.saveDepthFirst(a, whereToStart + 1); // Recursively save right subtree
		    }
		    return whereToStart; // Return updated whereToStart, indicating next available position in array
		}

		// 6
		// Find node in tree
		public Tree find(int n) {
		    if (root == n) {
		        return this; // Return node if it matches search value
		    } 
		    else if (n < root && left != null) {
		        return left.find(n); // Search left subtree if value is smaller
		    } 
		    else if (n > root && right != null) {
		        return right.find(n); // Search right subtree if value is bigger
		    } 
		    else {
		        return null; // Return null if node not found
		    }
		}

		// 7 
		// Insert value into tree
		public Tree insert(int n) {
		    if (root == n) {
		        return this; // Return node if it has same value
		    } 
		    else if (n < root) {
		        if (left != null) {
		            left = left.insert(n); // Recursively insert into left subtree
		        } 
		        else {
		            left = new Tree(n); // Create new left subtree if it is nonexistent
		        }
		    } 
		    else if (n > root) {
		        if (right != null) {
		            right = right.insert(n); // Recursively insert into right subtree
		        } 
		        else {
		            right = new Tree(n); // Create new right subtree if it is nonexistent
		        }
		    }
		    return this; // Return node
		}
}

