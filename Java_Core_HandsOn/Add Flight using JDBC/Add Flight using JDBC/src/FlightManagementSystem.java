import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightManagementSystem {

	public boolean addFlight(Flight flightObj) {
		try {
			Connection conn = DB.getConnection();
			Statement stmt = conn.createStatement();

			String querry = "Insert into flight values(" + flightObj.getFlightId() + ",'" + flightObj.getSource()
					+ "','" + flightObj.getDestination() + "'," + flightObj.getNoOfSeats() + ","
					+ flightObj.getFlightFare() + ");";
			stmt.executeUpdate(querry);
			return true;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}