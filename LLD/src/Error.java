public class Error implements Logger{
    @Override
    public void createLogger(String Message) {
        System.out.println("ERROR : "+Message);
    }
}
