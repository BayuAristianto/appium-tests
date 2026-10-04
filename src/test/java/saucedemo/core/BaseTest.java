package saucedemo.core;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        DriverManager.initDriver();

        if(DriverManager.getDriver()!=null){
            ((AndroidDriver) DriverManager.getDriver()).startRecordingScreen();
        }
    }

    @AfterTest
    public void tearDown() {
        if(DriverManager.getDriver()!=null){
            try{
                String base64Video = ((AndroidDriver) DriverManager.getDriver()).stopRecordingScreen();
                byte[] videoBytes = Base64.getDecoder().decode(base64Video);

                File folder = new File(System.getProperty("user.dir") + File.separator + "recordings");
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
                String savePath = folder.getAbsolutePath() + File.separator + "test_video_" + timestamp + ".mp4";
                try (FileOutputStream stream = new FileOutputStream(savePath)) {
                    stream.write(videoBytes);
                    System.out.println("-> Screen record berhasil disimpan di: " + savePath);
                }
            }catch (Exception e) {
                System.out.println("Gagal menyimpan rekaman layar: " + e.getMessage());
            } finally {
                DriverManager.quitDriver();
            }
        }
    }
}
