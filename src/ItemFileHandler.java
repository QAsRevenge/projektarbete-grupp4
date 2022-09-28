import java.nio.file.Files;
import java.nio.file.Paths;

public class ItemFileHandler {

  public static void write(String filePath, String content){
    try {
      Files.writeString(Paths.get(filePath), content);
    }
    catch(Exception error){
      throw(new RuntimeException(error));
    }
  }

  public static String read(String filePath){
    try {
      return Files.readString(Paths.get(filePath));
    }
    catch(Exception error){
      throw(new RuntimeException(error));
    }
  }

  public static boolean fileExists(String filePath){
    return Files.exists(Paths.get(filePath));
  }

}