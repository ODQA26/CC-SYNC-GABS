CC – GABS Vehicle Sync Automation

This project is a Selenium-based automation framework built in Java to validate vehicle data synchronization between CC (CarChief System) and GABS (Global Auction Backend System).
The automation verifies that the vehicle information and CRF images count in CC correctly match the data available in GABS.

Purpose
The main goal of this project is to:
- Fetch vehicle data from CC
- Fetch the same vehicle data from GABS
- Compare:
   - Vehicle specifications (make, model, grade, drive, etc.)
   - CRF ticked images count
   - Identify mismatches between the two systems
   - Identify broken synced images in Gabs   

This ensures data integrity and prevents incorrect vehicle listings.

Tech Stack
- Java
- Selenium WebDriver
- ChromeDriver
- Page Object Model (POM) structure
- Eclipse IDE
- Emojis: https://emojipedia.org/glowing-star

VehicleData

- Stock Number, Make, Model, Chassis, Register Year, Manufactured Year, EngineCC, Colour, Mileage, Fuel, Transmission, Grade, Drive Type, Wheel Drive, Seats, Length, Width, Height,volumeM3

 LoginCC 
 - Log in to Carchief Control Panel.

CCVehiclePage
 - Fetches vehicle details and CRF images from CC.

CCVehicleImagePage
 - Extract CRF Ticked images from CC.

loginPageGABS  
 - Log in to caricom (Gabs) Control Panel.

GABSVehiclePage
 - Fetches vehicle details from GABS for comparison.  

VehicleComparator
 - Compare vehicle details

 cri (Main Class)
   - Log in to CC
   - Fetch vehicles by stock number
   - Log in to GABS
   - Compare vehicle images from both systems
   - Print results
   - Export Result
 
Features Implemented
  - Login automation
  - Vehicle search by stock number
  - CRF image extraction
  - Data comparison between systems
  - Broken images validation
  - Console output for mismatches

How to Run
  - Prerequisites
     - Java JDK 11+ [https://www.oracle.com/java/technologies/downloads/]
     - Maven [https://maven.apache.org/download.cgi]
     - Eclipse IDE [https://www.eclipse.org/downloads/packages/release/indigo/sr2/eclipse-ide-java-ee-developers]
     - Google Chrome browser

 Install & Run
 
    1.  Install Google Chrome
    2.  Import the project into Eclipse
    3.  Ensure Maven dependencies are configured
    4.  Update login credentials
    5.  Run the project
    
                 - Right-click cri.java → Run As → Java Application
                        - Chrome will open automatically
                        - Console output will display: Vehicle details from CC & GABS
                                                       Field-by-field comparison results (✅ / ❌)
                                                       Broken image reports
                                                       Image count mismatches

  Optional: Add more vehicles
   - Edit the stockNumbers array in cri.java to test multiple vehicles

Note
Manual reacpatch verification needed for Gabs Login

   
   
   

## Author
Nathasha Welitharage  
QA  Engineer  
Email: nathasha.outdesk@gmail.com  
     

 
