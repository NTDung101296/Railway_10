import java.time.LocalDate;

public class Exam {
	int id;
	String code;
	String title;
	CategoryQuestion category;
	short duration;
	Account creator;
	LocalDate createDate;
	Question[] questions;

}
