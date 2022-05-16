import java.text.*;
import java.util.Date;
//년월일시분초
class TimeFormatting {
	public static void main(String[] args) {
		//현재시간을 가지고 있는 객체
		Date d = new Date();
		//특정 시간을 나타내는 Date 객체
		//setTime(long) long 다입으로 L을 붙인다.
		d.setTime(1652681440652L);
		//2022-05-16(PM 03:06)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (a hh:mm - ss)");
		String format = sdf.format(d);
		System.out.println(format);

		try{
				//String format에서 Date 객체 구하기
				Date other = sdf.parse("2012-05-16 (오후 09:00 - 00)");
				//Date객체로 시간(long) 구하기
				System.out.println(other.getTime());
		}catch(ParseException e){
		}
	}
}