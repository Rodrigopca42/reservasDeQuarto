package appication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserviation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número de Quarto: ");
		Integer roomNumber = tec.nextInt();
		
		System.out.print("Data do Check-in (dd/mm/aaaa):  ");
		Date checkIn = sdf.parse(tec.next());
		
		System.out.print("Data de Check-out (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(tec.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data do check-out deve ser posterior a data do check-in;");
		}
		else {
			Reserviation reservation = new Reserviation(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Insira a data para atualizar a reserva:");
			System.out.print("Data do Check-in (dd/mm/aaaa):  ");
			checkIn = sdf.parse(tec.next());
			
			System.out.print("Data de Check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(tec.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: As reservas devem ser feitas com datas futuras");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: A data do check-out deve ser posterior a data do check-in;");
			} 
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservas: " + reservation);
			}
		}
		
		tec.close();

		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
