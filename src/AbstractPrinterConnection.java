public abstract class AbstractPrinterConnection {
    String printerName;
    String printerIp;

    public AbstractPrinterConnection(String printerName, String printerIp) {
        super();
        this.printerName = printerName;
        this.printerIp = printerIp;
    }

    protected AbstractPrinterConnection() {
    }

    //the method should print a message showing the printer name, IP and the document name
    public abstract void print(String documentName);

    //you can return a random/predefined boolean
    public abstract boolean checkConnectionStatus();
}