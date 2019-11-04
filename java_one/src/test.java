public class test {
    public static void main(String[] args) {

        aa aa=new bb();
        aa.say();
    }
}
interface aa{
    void say();
}
class  bb implements aa{

    @Override
    public void say() {
        System.out.println("aaa");
    }
}
