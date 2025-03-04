public class LoggerFactory {
    public static Logger createLogger(LoggerValue lv) throws Exception {
        switch (lv){
            case ERROR :return new Error();
            case INFO: return  new Info();
            case WARN:return new Warn();
            default:
                throw new Exception("Ilegal Log Value "+lv);
        }
        //return null;
    }
}
