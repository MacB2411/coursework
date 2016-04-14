import javax.swing.JOptionPane;
import java.io.*;
import java.util.Calendar;
public class SHOW
{ 
    private String MPM;
    private TICKET orderList[];
    int noOfOrders;
    int Total;
    FILEREADCSV orderFile;
    FILEWRITECSV fridayDataFile;

    public SHOW()
    {
        orderFile = new FILEREADCSV();
        fridayDataFile = new FILEWRITECSV();
    }

    public void processOrders() throws IOException{
        setUpOrderList();
        calcTotal();
        calcMPM();
        displayShowData();
    }

    public void setUpOrderList() throws IOException{
        System.out.println("** Preparing to read data file.");
        String[] dataRows = orderFile.readCSVtable();

        noOfOrders = dataRows.length ;
        System.out.println("** " + noOfOrders + " rows read.\n\n");
        orderList = new TICKET[noOfOrders];

        for  (int i = 0; i < noOfOrders; i++) {
            orderList[i] = new TICKET();

            orderList[i].setTicketData(dataRows[i]);
        }
    }

    public void calcTotal() throws IOException{ 
        String fridayOutputData = "";
        for (int i = 0; i < noOfOrders; i++)
        { 
            if (orderList[i].getTicket().substring(0,1).equals("W") ||
            orderList[i].getTicket().substring(0,1).equals("T") ) {
                Total = Total + orderList[i].getNoOfTickets() * 5;
            }
            else{
                Total = Total + orderList[i].getNoOfTickets() * 10;
                fridayOutputData += orderList[i].writeDetails() + "\n";
            }
            
        }
         //write data to csv file
        fridayDataFile.writeCSVtable(fridayOutputData);
    }

    public void calcMPM(){ 
        int school = 0;
        int website = 0;
        
        for(int i = 0 ; i < noOfOrders; i++){
            if(orderList[i].getMOP().substring(0,1).equals("S")){
                school = school + 1;
            }
            else{
                website = website + 1;
            }
        }
        
        if(school > website){
            MPM = "School";
        }
        else{
            MPM = "Website";
        }
    }

    public void displayShowData(){
        System.out.println("Essell Academy Choral Shield " + Calendar.getInstance().get(Calendar.YEAR));
        System.out.println("The most popular method of sales is " + MPM);
        System.out.println("The total money raised for charity is £" + Total);
    }
}
