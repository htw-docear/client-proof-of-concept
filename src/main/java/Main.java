
//see http://commons.apache.org/vfs/apidocs/org/apache/commons/vfs2/impl/DefaultFileMonitor.html
//commons io has such tools too: http://commons.apache.org/io/api-release/index.html?org/apache/commons/io/monitor/package-summary.html

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Uploader.upload(args[0], args[1], args[2]);
        //watch();
    }

    private static void watch() throws FileSystemException {
        FileSystemManager fsManager = VFS.getManager();
        FileObject watchDir = fsManager.resolveFile("/tmp/towatch/");//todo command line param


        DefaultFileMonitor fm = new DefaultFileMonitor(new DocearFileListener());
        fm.setRecursive(true);
        fm.addFile(watchDir);
        fm.start();

        System.out.println("press Enter to quit");
        Scanner scanIn = new Scanner(System.in);
        String input = scanIn.nextLine();
        scanIn.close();
    }
}
