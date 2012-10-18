import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;

import java.io.IOException;
import java.net.URISyntaxException;

public class DocearFileListener implements FileListener {
    private final String syncFile;
    private final UploadConfig config;

    public DocearFileListener(String syncFile, UploadConfig config) {
        this.syncFile = syncFile;
        this.config = config;
    }

    @Override
    public void fileCreated(FileChangeEvent event) throws Exception {
        printEvent(event, "fileCreated");
        process(event);
    }

    @Override
    public void fileDeleted(FileChangeEvent event) throws Exception {
        printEvent(event, "fileDeleted");
    }

    @Override
    public void fileChanged(FileChangeEvent event) throws Exception {
        printEvent(event, "fileChanged");
        process(event);
    }

    private void process(FileChangeEvent event) {
        final String fileNameChangedFile = event.getFile().getName().getBaseName();
        if (fileNameChangedFile.equalsIgnoreCase(syncFile)) {
            try {
                Uploader.upload(config, event.getFile().getURL());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    private void printEvent(FileChangeEvent event, String message) {
        System.out.println(message + " " + event.getFile());
    }
}
