package command.validcommands;

import client.ClientUtil;
import server.ServerUtil;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

public class CreateSvgCommand implements ExecuteCommand {

    /**
     * Create an undirected graph using users and their friends
     * @return  graph
     */
    private DefaultUndirectedGraph<String, DefaultEdge> createGraph() {
        DefaultUndirectedGraph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        for (String user : ServerUtil.INSTANCE.getUsers()) {
            graph.addVertex(user);
        }

        for (String key : ServerUtil.INSTANCE.getFriends().keySet()) {
            Set<String> friends = ServerUtil.INSTANCE.getFriends().get(key);

            for (String friend : friends) {
                graph.addEdge(key, friend);
            }
        }
        return graph;
    }

    /**
     * Creates png file
     * @param imgFileName   path
     * @throws IOException
     */
    private void createPNG(String imgFileName) throws IOException {
        File imgFile = new File("src/main/resources/" + imgFileName + ".png");

        JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(createGraph());
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        ImageIO.write(image, "PNG", imgFile);
    }

    /**
     * Computes the png image
     * @param g graphics
     * @param imgFileName   path
     * @throws IOException
     */
    private void drawImg(Graphics g, String imgFileName) throws IOException {
        File imageSrc = new File("src/main/resources/" + imgFileName + ".png");
        BufferedImage img = ImageIO.read(imageSrc);
        g.drawImage(img,0,0,null);
    }

    /**
     * Converts png file to svg file
     * @param imgFileName   path
     * @throws IOException
     */
    private void createSvg(String imgFileName) throws IOException {
        createPNG(imgFileName);

        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();

        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);

        SVGGraphics2D graphics = new SVGGraphics2D(document);

        drawImg(graphics, imgFileName);

        boolean useCSS = true;
        Writer out = new OutputStreamWriter(new FileOutputStream("src/main/resources/" + imgFileName + ".svg"), StandardCharsets.UTF_8);
        graphics.stream(out, useCSS);
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
           createSvg(imgFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Svg representation of social network created successfully.";
    }
}
