import java.io.*;

public class SerializableTest implements Serializable{
    transient private FileOutputStream fos;

    public static void main(String[] args) throws Exception{
        SerializableTest serializableTest = new SerializableTest();
        File file = new File("/Users/daihuijun/Desktop/操作系统.docx");
        try (FileOutputStream fileOutputStream =  new FileOutputStream(file)) {
            serializableTest.fos = fileOutputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("/Users/daihuijun/Desktop/test"));
        oos.writeObject(serializableTest);
    }
}
