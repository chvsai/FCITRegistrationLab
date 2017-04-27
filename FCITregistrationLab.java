import java.io.*;
import java.util.Scanner;

public class FCITregistrationLab {
		public static void main(String[] args) throws IOException {
			Scanner in = new Scanner(new File("src/input.txt"));
			int noOfLaptops = in.nextInt();
			PrintWriter out = new PrintWriter("src/output.txt", "UTF-8");
			FCITlaptopStack laptopStack = new FCITlaptopStack(noOfLaptops);
			addLaptops(noOfLaptops, in, laptopStack);
			routine(in, laptopStack, out);
			in.close();
			out.close();
		}
		public static void addLaptops(int noOfLaptops, Scanner in,
				FCITlaptopStack laptopStack) {
			for (int i = 0; i < noOfLaptops; i++) {
				laptopStack.push(in.nextInt());
			}
		}
		public static void routine(Scanner in, FCITlaptopStack laptopStack,
				PrintWriter out) {
			int noOfDays = in.nextInt();
			for (int i = 1; i <= noOfDays; i++) {
				out.printf("********** \nDay %d:\n**********\n",i);
				performDayRoutine(in, laptopStack, i, out);
			}
		}
		public static void performDayRoutine(Scanner in,
				FCITlaptopStack laptopStack, int i, PrintWriter out) {
			int studentsCount = in.nextInt();
			FCITqueue outsideQueue = addStudentsToOutsideLine(in, studentsCount);
			int startTime = getStartTime(outsideQueue);
			int endTime = getEndTime(outsideQueue)>=299? 299:getEndTime(outsideQueue);
			FCITqueue laptopQueue = new FCITqueue();
			FCITqueue regQueue = new FCITqueue();
			FCITqueue lapReturnQueue = new FCITqueue();
			int laptopIssueTime = 0;
			int laptopReturnTime =0;
			for (; startTime <= endTime; startTime++) {

				if (!(outsideQueue.isEmpty())) {
					while (!(outsideQueue.isEmpty())
							&& outsideQueue.getfront().getEnterTime() <= startTime) {
						printTimeStamp(startTime, out);
						out.println(outsideQueue.getfront().getFirstName()
								+ " "
								+ outsideQueue.getfront().getLastName()
								+ " has arrived at the Registration Lab and entered the Laptop Check-out Line.");
						laptopQueue.enqueue(outsideQueue.dequeue());
					}

				}
					if(laptopIssueTime!=0){
					if (laptopQueue.getfront().getLaptopSerialNumber() == 0) {
						laptopQueue.getfront().setLaptopSerialNumber(laptopStack.pop());
						lapReturnQueue.enqueue(laptopQueue.dequeue());
						printTimeStamp(startTime, out);
						out.println(lapReturnQueue.getBack().getFirstName() + " "
								+ lapReturnQueue.getBack().getLastName()
								+ " has checked-out laptop # "
								+ lapReturnQueue.getBack().getLaptopSerialNumber());
						laptopIssueTime = 0;
					}else{
						//laptopQueue.get
					}
				}else if(!(laptopQueue.isEmpty())) laptopIssueTime++;
				
				registration(startTime,lapReturnQueue,laptopStack,out);
			}
		}

		private static void registration(int startTime, FCITqueue lapReturnQueue,
				FCITlaptopStack laptopStack, PrintWriter out) {
			FCITstudent curr = lapReturnQueue.getfront();
			while(curr!=null){
				curr.setTimeForReg(curr.getTimeForReg()+1);
				if(curr.getTimeForReg()==6){
					printTimeStamp(startTime, out);
					out.println(curr.getFirstName()+" "+curr.getLastName()+" finished registering and entered the Laptop Return Line.");
				}else if(curr.getTimeForReg()==7){
					printReportMessage(startTime, curr, out);
					laptopStack.push(lapReturnQueue.getfront().getLaptopSerialNumber());
					lapReturnQueue.dequeue();
				}
				curr = curr.getNext();
			}
			
		}
		private static int getEndTime(FCITqueue outsideQueue) {
			// TODO Auto-generated method stub
			return outsideQueue.getBack().getEnterTime();
		}

		private static int getStartTime(FCITqueue outsideQueue) {
			// TODO Auto-generated method stub
			return outsideQueue.getfront().getEnterTime();
		}

		
		private static void printReportMessage(int startTime, FCITstudent first,
				PrintWriter out) {
			printTimeStamp(startTime, out);
			out.println(first.getFirstName() + " " + first.getLastName()
					+ " successfully registered and returned laptop # " + first.getLaptopSerialNumber());
		}

		private static void printTimeStamp(int startTime, PrintWriter out) {
			out.printf("%d:%02d PM:   ",
					(startTime / 60 == 0 ? 12 : startTime / 60), (startTime % 60));
		}

		public static FCITqueue addStudentsToOutsideLine(Scanner in,
				int studentsCount) {
			FCITqueue outsideQueue = new FCITqueue();
			for (int i = 1; i <= studentsCount; i++) {
				int enterTime = in.nextInt();
				String lastName = in.next();
				String firstName = in.next();
				int id = in.nextInt();
				int numClasses = in.nextInt();
				//FCITcourse[] courses = new FCITcourse[numClasses];
				in.nextLine();
				for (int k = 0; k <numClasses; k++) {
					in.nextLine();
				}
				FCITstudent student = new FCITstudent(enterTime, firstName,
						lastName, id, numClasses);
				outsideQueue.enqueue(student);
			}
			return outsideQueue;
		}
	}
