public class Warn implements Logger{
    @Override
    public void createLogger(String Message) {
        System.out.println("WARN : "+Message);
    }
}
