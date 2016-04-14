import javax.swing.JOptionPane;
import java.io.*; 
public class TICKET
{  
    private String CustomerID;
    private String TicketID;
    private int NoOfTickets;
    private String MOP;
    //private String Ticket;
    int Total;
    
    
   public TICKET()
  {
     CustomerID = "";
     TicketID = "";
     NoOfTickets = 0;
     
  }
  
  public String getCustomerID(){
        return CustomerID;
    }
    
    public String getTicketID(){
        return TicketID;
    }
    
    public int getNoOfTickets(){
        return NoOfTickets;
    }
    
    public String getMOP(){
        return MOP;
    }
    
   public void setTicketData(String dataItems)
  {

   // unpack string of row data into fields
   String[] rowItems = dataItems.split(",");

   // store each data item as instance property
   CustomerID = rowItems[0];
   TicketID = rowItems[1];
   NoOfTickets = Integer.parseInt(rowItems[2]);
   MOP = rowItems[3];
  
      }
    
   public String writeDetails()
  {
     // join up data into a string to output as a row
     // use "," to separate csv columns
        String TicketData = "";
        TicketData = TicketData.concat(CustomerID);
        TicketData = TicketData.concat(",");
        TicketData = TicketData.concat(TicketID);
        TicketData = TicketData.concat(",");
        TicketData = TicketData.concat(Integer.toString(NoOfTickets));
        TicketData = TicketData.concat(",");
        TicketData = TicketData.concat(MOP);
        return TicketData;
    }
    
  public String getTicket()
  {
    return TicketID;
     
   }
     
    
    
    }
    
   
    
