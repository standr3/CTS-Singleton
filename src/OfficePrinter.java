public class OfficePrinter extends AbstractPrinterConnection{
    private static OfficePrinter printerConnectionLaser = null;
    private static OfficePrinter printerConnectionThermal = null;
    private static OfficePrinter printerConnectionInkjet = null;
    private static OfficePrinter printerConnection = null;


    private OfficePrinter() {
        super();
        printerName = "INKJET Printer";
        printerIp = "725.0.42.102";
    }

    public static OfficePrinter getPrinter() {
        if (printerConnection == null) {
            System.out.println(" -- Creating new printer connection for " + PrinterType.INKJET_PRINTER);
            printerConnection = printerConnectionInkjet = new OfficePrinter();
        }
        return printerConnection;
    }
    public static OfficePrinter getPrinter(PrinterType type) {

        //switch type using checkConnectionStatus(type) method
        switch (type) {
            case LASER_PRINTER -> {
                if (printerConnection != null && printerConnection.checkConnectionStatus(type)) {
                    System.out.println(" -- Using existing printer connection for " + type);
                    printerConnection = printerConnectionLaser;
                } else {
                    System.out.println(" -- Creating new printer connection for " + type);
                    printerConnection = printerConnectionLaser = new OfficePrinter();
                }
                setPrinterInfo(type);
            }
            case THERMAL_PRINTER -> {
                if (printerConnection != null && printerConnection.checkConnectionStatus(type)) {
                    System.out.println(" -- Using existing printer connection for " + type);
                    printerConnection = printerConnectionThermal;
                } else {
                    System.out.println(" -- Creating new printer connection for " + type);
                    printerConnection = printerConnectionThermal = new OfficePrinter();
                }
                setPrinterInfo(type);
            }
            default -> {
                if (printerConnection != null && printerConnection.checkConnectionStatus(type)) {
                    System.out.println(" -- Using existing printer connection for " + type);
                    printerConnection = printerConnectionInkjet;
                } else {
                    System.out.println(" -- Creating new printer connection for " + type);
                    printerConnection = printerConnectionInkjet = new OfficePrinter();
                }
                setPrinterInfo(type);
            }
        }

        return printerConnection;
    }
    @Override
    public void print(String documentName) {
        System.out.println("Printing document " + documentName + " on " + printerName + " with IP " + printerIp);
    }

    @Override
    public boolean checkConnectionStatus() {
        return printerConnection != null;
    }

    public boolean checkConnectionStatus(PrinterType type) {
        switch (type) {
            case LASER_PRINTER -> {
                return printerConnectionLaser != null;
            }
            case THERMAL_PRINTER -> {
                return printerConnectionThermal != null;
            }
            default -> {
                return printerConnectionInkjet != null;
            }
        }
    }
    public static void setPrinterInfo(PrinterType type) {
        switch (type) {
            case LASER_PRINTER -> {
                getPrinter().printerName = "LASER Printer";
                getPrinter().printerIp = "1234.0.42.102";

            }
            case THERMAL_PRINTER -> {
                getPrinter().printerName = "THERMAL Printer";
                getPrinter().printerIp = "546.0.42.102";
            }
            default -> {
                getPrinter().printerName = "INKJET Printer";
                getPrinter().printerIp = "725.0.42.102";
            }
        }
    }


}

enum PrinterType {
    LASER_PRINTER,
    THERMAL_PRINTER,
    INKJET_PRINTER
}
