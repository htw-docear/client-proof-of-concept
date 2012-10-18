import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;

public class DocearFileListener implements FileListener {
    @Override
    public void fileCreated(FileChangeEvent event) throws Exception {
        printEvent(event, "fileCreated");
    }

    private void printEvent(FileChangeEvent event, String message) {
        System.out.println(message + " " + event.getFile());
    }

    @Override
    public void fileDeleted(FileChangeEvent event) throws Exception {
        printEvent(event, "fileDeleted");
    }

    @Override
    public void fileChanged(FileChangeEvent event) throws Exception {
        printEvent(event, "fileChanged");
    }
}
