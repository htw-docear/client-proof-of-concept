//see http://commons.apache.org/vfs/apidocs/org/apache/commons/vfs2/impl/DefaultFileMonitor.html
//commons io has such tools too: http://commons.apache.org/io/api-release/index.html?org/apache/commons/io/monitor/package-summary.html

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 5) {
            System.err.println("usage: host port path userName password");
        } else {
            watch("sync.txt", new UploadConfig(args[0], parseInt(args[1]), args[2], args[3], args[4]));
        }
    }

    private static void watch(final String syncFile, UploadConfig config) throws FileSystemException {
        FileSystemManager fsManager = VFS.getManager();
        FileObject watchDir = fsManager.resolveFile(SystemUtils.getUserDir(), ".");
        DefaultFileMonitor fm = new DefaultFileMonitor(new DocearFileListener(syncFile, config));
        fm.setRecursive(true);
        fm.addFile(watchDir);
        fm.start();
        System.out.println("watching directory " + watchDir.getName().toString().replace("file://", ""));


        System.out.println("press Enter to quit");
        Scanner scanIn = new Scanner(System.in);
        String input = scanIn.nextLine();
        scanIn.close();
    }
}
