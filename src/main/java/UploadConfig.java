public class UploadConfig {
    final String host;
    final int port;
    final String path;
    final String userName;
    final String password;

    public UploadConfig(String host, int port, String path, String userName, String password) {
        this.host = host;
        this.port = port;
        this.path = path;
        this.userName = userName;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public String getPath() {
        return path;
    }

    public int getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }
}
