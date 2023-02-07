/**
 * @purpose: Hurricane Object Class
 *
 * @author Jonathan Rodriguez Gomez
 * @version 2/5/2023
 * @purpose OOP program to calculate the average category, pressure, and wind speed of Atlantic hurricanes that have occurred between a given year range. Also, tally the number of storms in each category according to the Saffir-Simpson scale.
 *
 */
 
 
public class Hurricane
{
   private String name, month;
   private int year;
   private int cat;
   private int pressure;
   private double windspeed;

     
   
   //constructor - all private instance variables initialized
   public Hurricane(int y, String n, String m, int c, int p, double w) {
      this.year = y;
      this.name = n;
      this.month = m;
      this.cat = c;
      this.pressure = p;
      this.windspeed = w;
   }

   //accessor for year
   public int getYear() {
      return year; 
   }

   //accessor for name
   public String getName() {
      return name; 
   }
   
   //accessor for month
   public String getMonth() {
      return month;  
   }
   
   //accessor for category
   public int getCat() {
      return cat;  
   }
   
   //accessor for pressure
   public int getPressure() {
      return pressure;
   }
   
   //accessor for windspeed
   public double getWindspeed() {
      return windspeed;
   }
   
   //mutator for year
   public void setYear(int y) {
      year = y;
   }
   
   //mutator for name
   public void setName(String n) {
      name = n;
   }
   
   //mutator for month
   public void setMonth(String m) {
      month = m;
   }
   
   //mutator for category
   public void setCat(int c) {
      cat = c;
   }
   
   //mutator for pressure
   public void setPressure(int p) {
      pressure = p;
   }
   
   //mutator for windspeed
   public void setWindspeed (double w) {
      windspeed = w;
   }


   public String toString() {
      // complete the toString method using String.format()
      return String.format("%4d \t %-9s \t %8d \t %13d \t %15.2f ", this.year, this.name, this.cat, this. pressure, this.windspeed);
   }
    
}
