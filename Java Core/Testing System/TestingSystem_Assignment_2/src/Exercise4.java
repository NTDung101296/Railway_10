import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		// Question 1: In ngau nhien ra 1 so nguyen
		int i = random.nextInt();
		System.out.println("So nguyen ngau nhien: " + i);

		// Question 2: In ngau nhien ra 1 so thuc
		float f = random.nextFloat();
		System.out.println("So thuc ngau nhien: " + f);
		
		// Question 3: Khai bao 1 array bao gom cac ten cua cac ban trong lop, sau do in ngau nhien ra ten 1 ban
		String[] nameStrings = {"Dung", "Hung", "Thien", "Thanh", "Hien", "Tung"};
		int n = random.nextInt(nameStrings.length);
		System.out.println("Ten ngau nhien: " + nameStrings[n]);
		
		// Question 4: In ngau nhien 1 ngay trong khoang thoi gian 24-07-1995 toi ngay 20-12-1995
		int day1 = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int day2 = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		
		long randomInt = day1 + random.nextInt(day2 - day1);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngay ngau nhien la: " + randomDay);
		
		// Question 5: In ngau nhien 1 ngay trong khoang thoi gian 1 nam tro lai day
		int now = (int) LocalDate.now().toEpochDay();
		int randomDate = now - random.nextInt(365);
		LocalDate randomDate2 = LocalDate.ofEpochDay(randomDate);
		System.out.println("Ngay ngau nhien 1 nam tro lai day: " + randomDate2);
		
		// Question 6: In ngau nhien 1 ngay trong qua khu
		int maxDay = (int) LocalDate.now().toEpochDay();
		long randomDay1 = random.nextInt(maxDay);
		LocalDate randomDay2 = LocalDate.ofEpochDay(randomDay1);
		System.out.println("Ngay ngau nhien trong qua khu: " + randomDay2);

		// Question 7: In ngau nhien  1 so co 3 chu so
		int i1 = random.nextInt(999 - 100 + 1) + 100;
		System.out.println("So ngau nhien co 3 chu so: " + i1);

	}

}
