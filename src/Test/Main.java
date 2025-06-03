package Test;




class Main{

    // services -> inplemenmt one interface -> method
    public static void main(String[] args) {

        String s1="15";
        String s2="15";
        System.out.println(multiplq(s1,s2));

    }

    private static String multiplq(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        int [] result=new int[len2+len1];
        for(int i=len1-1;i>=0;i--){
            int n1=s1.charAt(i)-'0';
            for(int j=len2-1;j>=0;j--){
                int n2=s2.charAt(j)-'0';
                int sum=n1*n2+result[i+j+1];
                result[i+j+1]=sum%10;
                result[i+j]+=sum/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int x:result){
            if(sb.length()==0 && x==0){
                continue;
            }
            sb.append(x);
        }
        return  sb.length()==0?"0":sb.toString();
    }
}
//
//public interface Notifaction{
//    void send(String message);
//}
//
//
//public class Email implemets Notification{
//    @Override
//    public void send(String message){
//        //
//    }
//}
//public class Text implemets Notification{
//    @Override
//    public void send(String message){
//        //
//    }
//}
//../Notification
//
//EmailNotifictio
//TextNotification
//
//class main{
//
//    public static void main(String[] args) {
//        serviceLoader<Notification> l=serviceloader.load(Notification.class);
//    }
//
//}
