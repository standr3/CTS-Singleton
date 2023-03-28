

public class Main {
    public static void main(String[] args) {

        OfficePrinter printer = OfficePrinter.getPrinter();
//        OfficePrinter printer = OfficePrinter.getPrinter(PrinterType.THERMAL_PRINTER);
        printer.print("test");

        System.out.println();
        OfficePrinter printerRef2 = OfficePrinter.getPrinter(PrinterType.LASER_PRINTER);
        printerRef2.print("test2");

        System.out.println();
        OfficePrinter printerRef3 = OfficePrinter.getPrinter(PrinterType.THERMAL_PRINTER);
        printerRef3.print("test3");

        System.out.println();
        OfficePrinter printer4 = OfficePrinter.getPrinter(PrinterType.INKJET_PRINTER);
        printer4.print("test4");



    }
}