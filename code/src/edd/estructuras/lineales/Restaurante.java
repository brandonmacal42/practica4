import java.util.Iterator;

public class Restaurante {
	private ArrayQueue<Mesa> mesas;
	private ArrayQueue<Reservacion> reservaciones;

	public Restaurante() {
		mesas = new ArrayQueue<>();
		reservaciones = new ArrayQueue<>();
	}

	public void agregarMesa(Mesa mesa) {
		mesas.enqueue(mesa);
	}

	public void agregarReservacion(Reservacion reservacion) {
		reservaciones.enqueue(reservacion);
	}

	public Mesa obtenerMesaDisponible(int numeroPersonas) {
		Iterator<Mesa> it = mesas.iterator();
		while (it.hasNext()) {
			Mesa mesa = it.next();
			if (mesa.getCapacidadMaxima() >= numeroPersonas) {
				it.remove();
				return mesa;
			}
		}
		return null;
	}

	public void imprimirMesasDisponibles() {
		System.out.println("Mesas disponibles:");
		Iterator<Mesa> it = mesas.iterator();
		while (it.hasNext()) {
			Mesa mesa = it.next();
			System.out.println("- " + mesa);
		}
	}

	public void imprimirReservaciones() {
		System.out.println("Reservaciones:");
		Iterator<Reservacion> it = reservaciones.iterator();
		while (it.hasNext()) {
			Reservacion reservacion = it.next();
			System.out.println(reservacion);
		}
	}
}
