public class Syc {
    private String mem = "";

    public String getMem(){
        return mem;
    }

    public void setMem(String mem){
        String newLine = this.mem + mem;
        this.mem = newLine;
    }
}
