package TransportService;

import BaseFramework.BaseClass;
import com.sshtools.net.SocketTransport;
import com.sshtools.ssh.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SshImplimentation extends BaseClass {

    String hostName = "lnqaapp130.hzlab.lab.emc.com";
    String userName = "rsaapp";
    String userPassword = "!orbis2k";

    String hostNameOld = "linuxqaapp130a.hzlab.lab.emc.com";
    String userNameOld = "cyota";
    String userPasswordOld = "!orbis2k";
    private String commandOutput;

    private void runCommand(String commandToRun, String hostName) {
        // log.log(Level.FINE, "Initiating connection to {0}", hostName);
        logger.info("Initiating connection to {0} " + hostName);
        System.out.println("Initiating connection to {0}");
        try {
            String hostname = hostName;
            int idx = hostname.indexOf(':');
            int port = 22;
            if (idx > -1) {
                port = Integer.parseInt(hostname.substring(idx + 1));
                hostname = hostname.substring(0, idx);
            }

            String username = userName;

            SshConnector con = SshConnector.createInstance();

            SocketTransport transport = new SocketTransport(hostname, port);

            final SshClient ssh = con.connect(transport, username);

            PasswordAuthentication pwd = new PasswordAuthentication();

            do {
                pwd.setPassword(userPassword);

            } while (ssh.authenticate(pwd) != SshAuthentication.COMPLETE
                    && ssh.isConnected());

            if (ssh.isAuthenticated()) {

                logger.info("Connected");
                System.out.println("Connected");
                final SshSession session = ssh.openSessionChannel();

                String cmd = commandToRun;
                logger.info("Running command.");
                session.startShell();
                session.getOutputStream().write(cmd.getBytes());

                byte[] buf = new byte[1024];
                int r;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while ((r = session.getInputStream().read(buf)) > -1)
                    bos.write(buf, 0, r);

                commandOutput = bos.toString();
                logger.info(commandOutput);
                test.info(commandOutput);
                session.close();

            }

            ssh.disconnect();

            logger.info("Disconnected");

        } catch (NumberFormatException | SshException | IOException | ChannelOpenException ex) {
            logger.error(ex.toString());
            System.out.println(ex.toString());
        }
    }


    private void runCommandOldServer(String commandToRun, String hostNameOld) {
        // log.log(Level.FINE, "Initiating connection to {0}", hostName);
        logger.info("Initiating connection to {0} " + hostNameOld);
        System.out.println("Initiating connection to {0}");
        try {
            String hostname = hostNameOld;
            int idx = hostname.indexOf(':');
            int port = 22;
            if (idx > -1) {
                port = Integer.parseInt(hostname.substring(idx + 1));
                hostname = hostname.substring(0, idx);
            }

            String username = userNameOld;

            SshConnector con = SshConnector.createInstance();

            SocketTransport transport = new SocketTransport(hostname, port);

            final SshClient ssh = con.connect(transport, username);

            PasswordAuthentication pwd = new PasswordAuthentication();

            do {
                pwd.setPassword(userPasswordOld);

            } while (ssh.authenticate(pwd) != SshAuthentication.COMPLETE
                    && ssh.isConnected());

            if (ssh.isAuthenticated()) {

                logger.info("Connected");
                System.out.println("Connected");
                final SshSession session = ssh.openSessionChannel();

                String cmd = commandToRun;
                logger.info("Running command.");
                session.startShell();
                session.getOutputStream().write(cmd.getBytes());

                byte[] buf = new byte[1024];
                int r;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while ((r = session.getInputStream().read(buf)) > -1)
                    bos.write(buf, 0, r);

                commandOutput = bos.toString();
                logger.info(commandOutput);
                session.close();

            }

            ssh.disconnect();
            logger.info("Disconnected");

        } catch (NumberFormatException | SshException | IOException | ChannelOpenException ex) {
            logger.error(ex.toString());
            System.out.println(ex.toString());
        }
    }

    public void recycleServer(String routingCode, String env) {
        logger.info("Running command recycleServer for region: {0} " + routingCode);
        String commandToRun = "recycle_servers.ksh " + routingCode + ";exit;" + '\n';
        runCommand(commandToRun, env);
        logger.info("Recycle Server done.");
    }


    public void checkCavvWithVersion(String fiid) {
        logger.info("Running command to check CAVV with Version ");
        String commandToRun = "cd /opt/rsa/3ds_2.0/3ds/logs/components/authentication-backend && less authentication-backend_" + fiid + ".1.log | grep cavv | grep VERSION_7 | tail -n 10;exit;" + '\n';
        runCommand(commandToRun, hostName);
        logger.info("check done.");
    }

    public void checkCavvWithValue(String fiid) {
        logger.info("Running command to check CAVV with value ");
        String commandToRun = "cd /opt/rsa/3ds_2.0/3ds/logs/components/authentication-backend && less authentication-backend_" + fiid + ".1.log | grep cavv | grep ZEROS | tail -n 10;exit;" + '\n';
        runCommand(commandToRun, hostName);
        logger.info("check done.");
    }

    public void CleanDB(String region) {
        logger.info("Running command to CleanDB for the PAN. ");
        String commandToRun = "cleanDB.sh  " + region + ";exit;" + '\n';
        runCommandOldServer(commandToRun, hostNameOld);
        logger.info("CleanDB done.");
    }
}
