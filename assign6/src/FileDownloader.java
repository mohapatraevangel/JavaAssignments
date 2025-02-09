
import java.io.*;
import java.net.URL;
import java.util.concurrent.*;

public class FileDownloader {

    // URL list for the photos (you can add 25 URLs here)
    private static final String[] FILE_URLS = {
            "https://www.dropbox.com/photo1.jpg",
            "https://www.dropbox.com/photo2.jpg",
            "https://www.dropbox.com/photo3.jpg",
            "https://www.dropbox.com/photo4.jpg",
            "https://www.dropbox.com/photo5.jpg",
            "https://www.dropbox.com/photo6.jpg",
            "https://www.dropbox.com/photo7.jpg",
            "https://www.dropbox.com/photo8.jpg",
            "https://www.dropbox.com/photo9.jpg",
            "https://www.dropbox.com/photo10.jpg",
            "https://www.dropbox.com/photo11.jpg",
            "https://www.dropbox.com/photo12.jpg",
            "https://www.dropbox.com/photo13.jpg",
            "https://www.dropbox.com/photo14.jpg",
            "https://www.dropbox.com/photo15.jpg",
            "https://www.dropbox.com/photo16.jpg",
            "https://www.dropbox.com/photo17.jpg",
            "https://www.dropbox.com/photo18.jpg",
            "https://www.dropbox.com/photo19.jpg",
            "https://www.dropbox.com/photo20.jpg",
            "https://www.dropbox.com/photo21.jpg",
            "https://www.dropbox.com/photo22.jpg",
            "https://www.dropbox.com/photo23.jpg",
            "https://www.dropbox.com/photo24.jpg",
            "https://www.dropbox.com/photo25.jpg"
    };

    public static void main(String[] args) {
        // Create a fixed thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Loop through the file URLs and submit each download task
        for (String fileUrl : FILE_URLS) {
            executorService.submit(new Downloader(fileUrl));
        }

        // Shutdown the executor service after all tasks are submitted
        executorService.shutdown();
    }

    // Downloader task that implements Runnable
    static class Downloader implements Runnable {
        private final String fileUrl;

        public Downloader(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        @Override
        public void run() {
            try {
                downloadFile(fileUrl);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Simulate file download
        private void downloadFile(String fileUrl) throws IOException, InterruptedException {
            // Extract file name from the URL
            String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
            System.out.println("Downloading file: " + fileName);

            // Simulate downloading by sleeping for 2 seconds
            Thread.sleep(2000);

            // In a real-world scenario, you would use a URLConnection to download the file
            // For now, just printing out a message
            System.out.println("Downloaded file: " + fileName);
        }
    }
}
