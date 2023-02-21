import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerSelectionSystem {

	public List<String> playersBasedOnHeightWeight (double minHeight, double maxWeight){
		
		// Fill your code here	
		List<String> l=new ArrayList<String>();
		try {
			Connection c=DB.getConnection();
			Statement s=c.createStatement();
			ResultSet r=s.executeQuery("select * from player where height>="+minHeight
					+" and weight<="+maxWeight+" order by playerName asc");
			while(r.next()){
				l.add(r.getString(2));	
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
}
