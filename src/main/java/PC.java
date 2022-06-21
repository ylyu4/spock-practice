public class PC {

    private String vendor;

    private Integer clockRate;

    private Integer ram;

    private String os;


    public PC() {
        this.vendor = "Sunny";
        this.clockRate = 2333;
        this.ram = 4096;
        this.os = "Linux";
    }

    public String getVendor() {
        return vendor;
    }

    public Integer getClockRate() {
        return clockRate;
    }

    public Integer getRam() {
        return ram;
    }

    public String getOs() {
        return os;
    }
}
