class FCITlaptopStack {
	private int[] stack;
	private int top ;
	private int maxSize;

	FCITlaptopStack(int maxSize) {
		stack = new int[maxSize];
	}

	void push(int laptopSerialNumber) {
		stack[top++] = laptopSerialNumber;
	}

	int pop() {
		return stack[--top];
	}
	int peek(){
		return stack[top];
	}
	int laptopsAvailable() {
		return top;
	}

	/**
	 * @return the maxSize
	 */
	public int getmaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize
	 *            the maxSize to set
	 */
	public void setmaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}
