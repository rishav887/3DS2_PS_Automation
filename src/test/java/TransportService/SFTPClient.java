package TransportService;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;


public class SFTPClient {

    // private String host = "linuxqaapp130a.hzlab.lab.emc.com";
    private Session session = null;
    private static Logger Log = Logger.getLogger(SFTPClient.class.getName());
    public SFTPClient() {

    }

    public void download(String source, String destination, String host) throws JSchException,SftpException {
        Session session = new JSch().getSession("cyinst", host , 22);
        session.setPassword("!orbis2k");
        session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setConfig("StrictHostKeyChecking", "no"); // disable check for RSA key
        session.connect();
        Log.info("Connected to Host.");
        Channel channel = session.openChannel("sftp");
        channel.connect();
        Log.info("SFTP Channel connected");
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        sftpChannel.get(source, destination);
        Log.info("Download of File complete at " +destination);
        sftpChannel.exit();
    }

    public void upload(String source, String destination, String host) throws JSchException, SftpException {
        Session session = new JSch().getSession("cyinst", host , 22);
        session.setPassword("!orbis2k");
        session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setConfig("StrictHostKeyChecking", "no"); // disable check for RSA key
        session.connect();
        Log.info("Connected to Host.");
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        sftpChannel.put(source, destination);
        Log.info("Upload of File complete.");
        sftpChannel.exit();
    }


    public void disconnect() {
        if (session != null) {
            session.disconnect();
            Log.info("Session disconnected.");
        }
    }


}