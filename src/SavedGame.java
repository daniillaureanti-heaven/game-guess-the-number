import java.io.*;

public class SavedGame {

    FileOutputStream fos = null;
    FileInputStream fin = null;

    public void savedGame() {
        {
            try {
                fos = new FileOutputStream("./src/streams/saved_game/saved.txt");
                String str = String.valueOf(Game.getCtnAttempts());
                byte[] buffer = str.getBytes();
                fos.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int loadSavedGame() {
        byte[] buffer;
        String str;
        int num = 0;
        try {
            fin = new FileInputStream("./src/streams/saved_game/saved.txt");
            buffer = new byte[fin.available()];
            fin.read(buffer,0, buffer.length);
            str = (new String(buffer, "UTF-8"));
            num = Integer.parseInt(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
}