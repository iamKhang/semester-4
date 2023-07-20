package tuan05_24_UsingJtableComponent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StoreData {
	public Object loadFile(String path) throws IOException, Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
	
	public boolean saleFile(Object obj, String path) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
}
