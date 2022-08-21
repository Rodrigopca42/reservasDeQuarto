package appication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserviation;
import model.excepitions.DomainExcepition;

public class Program {

	public static void main(String[] args)  {
		
		
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número de Quarto: ");
			Integer roomNumber = tec.nextInt();
			
			System.out.print("Data do Check-in (dd/mm/aaaa):  ");
			Date checkIn = sdf.parse(tec.next());
			
			System.out.print("Data de Check-out (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(tec.next());
			
			
			Reserviation reservation = new Reserviation(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Insira a data para atualizar a reserva:");
			System.out.print("Data do Check-in (dd/mm/aaaa):  ");
			checkIn = sdf.parse(tec.next());
			
			System.out.print("Data de Check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(tec.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservas: " + reservation);
			tec.close();
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch(DomainExcepition e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro Inexperado");
		}
	}
}