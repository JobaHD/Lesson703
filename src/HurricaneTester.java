/**
 * @author Jonathan Rodriguez Gomez
 * @version 2/5/2023
 *
 */
 
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class HurricaneTester

{

    public static void main(String[] args) throws IOException
    {
        //read data from text file & put in an array
        File fileName = new File("src/HurricaneData.txt");
        Scanner inFile = new Scanner(fileName);
        int numValues = 0;
        
        //count number of lines in text file
        while (inFile.hasNextLine() )
        {
            inFile.nextLine();
            numValues++;
        }
        inFile.close();
        
        
        //initialize arrays based on lines counted in text file
        int [] years = new int[numValues];
        String [] months = new String[numValues];
        int [] pressures = new int[numValues];
        double [] windSpeeds = new double[numValues];
        String [] names = new String[numValues];
        int [] categories = new int[numValues];
        
        //read and assign data from text file to the arrays
        inFile = new Scanner(fileName);
        int index = 0;
        while(inFile.hasNext() )
        {
            years[index] = inFile.nextInt();
            months[index] = inFile.next();
            pressures[index] = inFile.nextInt();
            windSpeeds[index] = inFile.nextDouble();
            names[index] = inFile.next();
            index++;
        }
        inFile.close();
        
        //convert the windspeed, determine categories, calculate sums
        for (int i = 0; i < index; i++){
            windSpeeds[i] *= 1.15078;
            if (windSpeeds[i] <= 95 ){
                categories[i] = 1;
            } else if (windSpeeds[i] <= 110 ) {
                categories[i] = 2;
            } else if (windSpeeds[i] <= 129 ) {
                categories[i] = 3;
            } else if (windSpeeds[i] <= 156 ) {
                categories[i] = 4;
            } else  {
                categories[i] = 5;
            }
        }

        
        //create a Hurricane ArrayList using the data above
        ArrayList<Hurricane> hurricaneArrayList = new ArrayList<Hurricane>(index);
        for (int i = 0; i < index; i++){
            hurricaneArrayList.add(new Hurricane(years[i], names[i], months[i], categories[i],pressures[i], windSpeeds[i]));
        }
        

        //user prompted for range of years
        Scanner input = new Scanner(System.in);
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;

        while (start < 1995 || end > 2019 || start > end){
            System.out.println("Choose a range of years to display(1995-2019): ");

            System.out.print("Starting at: ");
            start = Integer.parseInt(input.nextLine());

            System.out.print("Ending at: ");
            end = Integer.parseInt(input.nextLine());

            if (start < 1995 || end > 2019 || start > end){
                System.out.println("Try Again");
            }
        }

        //divisor for average and sum
        ArrayList<Hurricane> chosenHurricanes = new ArrayList<Hurricane>(index);

        for (Hurricane a : hurricaneArrayList){
            if ( a.getYear() >= start && a.getYear() <= end){
                chosenHurricanes.add(a);
            }
        }

        //calculate max, mins and averages
        int categoryMax = Integer.MIN_VALUE;
        int pressureMax = Integer.MIN_VALUE;
        double windspeedMax = Integer.MIN_VALUE;

        int categoryMin = Integer.MAX_VALUE;
        int pressureMin = Integer.MAX_VALUE;
        double windspeedMin = Integer.MAX_VALUE;

        double categoryAvg = 0;
        double pressureAvg = 0;
        double windspeedAvg = 0;

        for (Hurricane i : chosenHurricanes){
            if (i.getCat() >= categoryMax){
                categoryMax = i.getCat();
            }
            if (i.getCat() <= categoryMin){
                categoryMin = i.getCat();
            }
            if (i.getPressure() >= pressureMax){
                pressureMax = i.getPressure();
            }
            if (i.getPressure() <= pressureMin) {
                pressureMin = i.getPressure();
            }
            if (i.getWindspeed() >= windspeedMax) {
                windspeedMax = i.getWindspeed();
            }
            if (i.getWindspeed() <= windspeedMin) {
                windspeedMin = i.getWindspeed();
            }
            categoryAvg += i.getCat();
            pressureAvg += i.getPressure();
            windspeedAvg += i.getWindspeed();
        }
        categoryAvg /= chosenHurricanes.size()-1;
        pressureAvg /= chosenHurricanes.size()-1;
        windspeedAvg /= chosenHurricanes.size()-1;


        //print the data
        System.out.printf("%14s %4d - %4d \n", "Hurricanes ", start, end);
        System.out.printf("Year \t Hurricane \t Category \t Pressure (mb) \t Windspeed (mph) \n\n");
        for (Hurricane c : chosenHurricanes){
            System.out.println(c.toString());
        }
        System.out.println("=============================================================================");
        System.out.printf("\t Average: \t %11.2f \t %16.2f \t %7.2f \n", categoryAvg, pressureAvg, windspeedAvg);
        System.out.printf("\t Minimum: \t %8d \t %14d \t %7.2f \n", categoryMin, pressureMin, windspeedMin);
        System.out.printf("\t Maximum: \t %8d \t %14d \t %7.2f \n", categoryMax, pressureMax, windspeedMax);

     }
}