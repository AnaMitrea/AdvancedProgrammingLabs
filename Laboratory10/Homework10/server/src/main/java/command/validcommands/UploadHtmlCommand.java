package command.validcommands;

import client.ClientUtil;
import com.jcraft.jsch.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadHtmlCommand implements ExecuteCommand{

    /**
     * Create the html file with the svg representation.
     * @param imgName   image path
     * @throws IOException
     * @throws TemplateException
     */
    private void createHtml(String imgName) throws IOException, TemplateException {
        File f = new File("src/main/resources/index.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/template/"));

        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        Map<String, Object> root = new HashMap<>();
        root.put("title", "HTML REPRESENTATION OF THE SOCIAL NETWORK");
        root.put("image_source", "./" + imgName + ".svg");

        Template template = cfg.getTemplate("template.ftl");
        template.process(root, bw);

        Desktop.getDesktop().browse(f.toURI());
    }

    /**
     * Upload a HTML document containing the social network representation directly from the application to a Web server using JCraft for connecting to a server using SFTP and transferring a file
     * @return  response
     */
    private String uploadHTML() {
        try {
            JSch ssh = new JSch();
            Session session = ssh.getSession("epiz_31723941", "a0tum9on.epizy.com", 22);

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword("fEAqycF88f");

            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftp = (ChannelSftp) channel;

            sftp.cd("/directory");

            sftp.put("src/main/resources/index.html", "/home/vol9_5/epizy.com/epiz_31723941/laborator10/index.html");

            channel.disconnect();
            session.disconnect();

            return "Uploaded";
        } catch (SftpException | JSchException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * Method that executed the current command.
     * @param args  Arguments
     * @param clientUtil    Current client state
     * @return  Response
     */
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil){
        if (args.size() == 0)
            return "Insufficient arguments!";

        String imgFileName = args.get(0);

        try {
            File file = new File("src/main/resources/" + imgFileName + ".svg");
            if(!file.exists())
                return "Representation doesn't exist! Specify a valid title or create a new svg representation";

            createHtml(imgFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploadHTML();
    }
}
