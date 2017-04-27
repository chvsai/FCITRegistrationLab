class FCITqueue {
	private FCITstudent front;
	private FCITstudent back;
	private int noOfStudentsInQueue;

	public boolean isEmpty() {
		return this.getNoOfStudentsInQueue()==0;//return getfront() == null;
	}

	public void enqueue(FCITstudent student) {
		FCITstudent oldback = back;
		back = student;
		if (isEmpty())
			setfront(back);
		else
			oldback.setNext(back);
		setNoOfStudentsInQueue(getNoOfStudentsInQueue() + 1);
	}

	public FCITstudent dequeue() {
		FCITstudent student = getfront();
		setfront(getfront().getNext());
		if (isEmpty())
			back = null;
		setNoOfStudentsInQueue(getNoOfStudentsInQueue() - 1);
		student.setNext(null);
		return student;
	}

	/**
	 * @return the front
	 */
	public FCITstudent getfront() {
		return front;
	}

	/**
	 * @param front the front to set
	 */
	public void setfront(FCITstudent front) {
		this.front = front;
	}
	public FCITstudent getBack() {
		return back;
	}
	/**
	 * @return the noOfStudentsInQueue
	 */
	public int getNoOfStudentsInQueue() {
		return noOfStudentsInQueue;
	}

	/**
	 * @param noOfStudentsInQueue the noOfStudentsInQueue to set
	 */
	public void setNoOfStudentsInQueue(int noOfStudentsInQueue) {
		this.noOfStudentsInQueue = noOfStudentsInQueue;
	}

}
