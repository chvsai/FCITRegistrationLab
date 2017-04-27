class FCITstudent {
	private String firstName;
	private String lastName;
	private int id;
	private int enterTime;
	private int timeForReg;
	private int numClasses;
	private FCITcourse[] courses;
	private int laptopSerialNumber;
	private FCITstudent next;
	
	FCITstudent(){
		
	}
	FCITstudent(int enterTime, String firstName, String lastName,int id,
			int numClasses) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEnterTime(enterTime);
		this.id = id;
		this.setnumClasses(numClasses);
	}

	private void setnumClasses(int numClasses) {
		// TODO Auto-generated method stub
		this.numClasses=numClasses;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the next
	 */
	public FCITstudent getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(FCITstudent next) {
		this.next = next;
	}
	/**
	 * @return the enterTime
	 */
	public int getEnterTime() {
		return enterTime;
	}
	/**
	 * @param enterTime the enterTime to set
	 */
	public void setEnterTime(int enterTime) {
		this.enterTime = enterTime;
	}
	/**
	 * @return the laptopSerialNumber
	 */
	public int getLaptopSerialNumber() {
		return laptopSerialNumber;
	}
	/**
	 * @param laptopSerialNumber the laptopSerialNumber to set
	 */
	public void setLaptopSerialNumber(int laptopSerialNumber) {
		this.laptopSerialNumber = laptopSerialNumber;
	}
	/**
	 * @return the numAnswered
	 */

	/**
	 * @param numAnswered the numAnswered to set
	 */
	/**
	 * @return the numClasses
	 */
	public int getnumClasses() {
		return numClasses;
	}
	/**
	 * @param numClasses the numClasses to set
	 */
	public void decrementnumClasses(int numClasses) {
		this.numClasses = --numClasses;
	}
	/**
	 * @return the timeForReg
	 */
	public int getTimeForReg() {
		return timeForReg;
	}
	/**
	 * @param timeForReg the timeForReg to set
	 */
	public void setTimeForReg(int timeForReg) {
		this.timeForReg = timeForReg;
	}

}
