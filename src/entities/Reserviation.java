package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserviation {

	private Integer roomNumber; //número do quarto
	private Date checkIn; //entrada do hospede
	private Date checkOut; //saída do hospede 
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	public Reserviation() {
	}

	public Reserviation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn  = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString(){
		return "Quarto: "
				+ roomNumber
				+", Data do check-in (dd/mm/aaaa): "
				+ sdf.format(checkIn)
				+", Data de check-out (dd/mm/aaaa): "
				+sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " noites";
	}
	
}
