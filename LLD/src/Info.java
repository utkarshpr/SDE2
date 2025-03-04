public class Info implements Logger{
    @Override
    public void createLogger(String Message) {
        System.out.println("INFO : "+Message);
    }
}
